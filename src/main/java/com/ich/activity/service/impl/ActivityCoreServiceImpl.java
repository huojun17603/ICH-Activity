package com.ich.activity.service.impl;

import com.ich.activity.dao.*;
import com.ich.activity.dto.ActivityResponse;
import com.ich.activity.dto.ActivityUser;
import com.ich.activity.dto.PrizeDto;
import com.ich.activity.pojo.*;
import com.ich.activity.service.ActivityPrizeIService;
import com.ich.activity.service.ActivityCoreService;
import com.ich.activity.service.ActivityLogicIService;
import com.ich.core.base.IDUtils;
import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.spring.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ActivityCoreServiceImpl implements ActivityCoreService {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivitylogicMapper activitylogicMapper;
    @Autowired
    private ActivitytriggerMapper activitytriggerMapper;
    @Autowired
    private ActivityrecordMapper activityrecordMapper;
    @Autowired
    private ActivityprizeMapper activityprizeMapper;
    @Autowired
    private ActivityPrizeIService activityPrizeIService;

    @Override
    public ActivityResponse execute(String triCode, Map<String, Object> agrMaps) {
        ActivityResponse response = new ActivityResponse(HttpResponse.HTTP_OK,HttpResponse.HTTP_MSG_OK);
        List<PrizeDto> list = new ArrayList<>();
        ActivityUser user = new ActivityUser();
        response.setUser(user);
        response.setPrizes(list);
        response.setAgrsMap(agrMaps);
        Activitytrigger trigger = activitytriggerMapper.selectById(triCode);
        if(ObjectHelper.isEmpty(trigger)){
            response.setStatus(HttpResponse.HTTP_ERROR);
            return response;
        }
        //1.获取有效的活动列表
        List<Activity> activitys = activityMapper.selectEffectiveList(triCode);
        for(Activity activity : activitys){
            //2.获取逻辑明细
            List<Activitylogic> logics = activitylogicMapper.selectByActivityId(activity.getId());
            for(Activitylogic logic : logics){
                //执行逻辑
                ActivityLogicIService service = (ActivityLogicIService)SpringContextUtil.getBean(trigger.getServiceimpl());
                service.execute(logic,response);
                if(response.getStatus()==HttpResponse.HTTP_OK) {
                    String prizenames = "";
                    //3.发放奖品
                    if (trigger.getRewardsystem()) {
                        //执行发放逻辑，保证排序
                        List<Activityprize> prizes = activityprizeMapper.selectByLogicId(logic.getId());
                        Integer group = 0;
                        boolean sended = false;//发放标志
                        int i = 0;
                        if(ObjectHelper.isNotEmpty(prizes)){
                            for(Activityprize prize : prizes){
                                if(prize.getGrp()!=group){
                                    if(group!=0&&!sended){//分组更换，时发现上一次没有发放
                                        Activityprize defPrize = activityprizeMapper.selectDafByGrp(logic.getId(),group);//获取上个分组的默认奖品
                                        PrizeDto dto = sendPrize(user,defPrize);
                                        if(ObjectHelper.isNotEmpty(dto)){
                                            list.add(dto);
                                            prizenames += resultPrizeString(defPrize)+ ",";
                                        }
                                    }
                                    group = prize.getGrp();
                                    sended = false;//分组更换，则标记为未发放
                                }

                                if(!sended){
                                    Random random = new Random();
                                    int rd = random.nextInt(100);//随机，几率叠加算法
                                    if(prize.getGrplv()>=rd && rd!=0){//符合几率,数量
                                        sended = true;
                                        PrizeDto dto = sendPrize(user,prize);
                                        if(ObjectHelper.isNotEmpty(dto)){
                                            list.add(dto);
                                            prizenames += resultPrizeString(prize)+ ",";
                                        }
                                    }
                                }
                                i++;
                                if(prizes.size()==i&&!sended){
                                    Activityprize defPrize = activityprizeMapper.selectDafByGrp(logic.getId(),group);//获取上个分组的默认奖品
                                    PrizeDto dto = sendPrize(user,defPrize);
                                    if(ObjectHelper.isNotEmpty(dto)){
                                        list.add(dto);
                                        prizenames += resultPrizeString(defPrize)+ ",";
                                    }
                                }
                            }
                        }
                        //配置奖励数据
                    }else{
                        //如果是通过逻辑来发放奖励，则由逻辑的返回来提供奖励数据
                        for(PrizeDto prizeDto : list){
                            if(prizeDto.getNum()!=1){
                                prizenames += prizeDto.getPrizename() + "*" + prizeDto.getNum()+ ",";
                            }else{
                                prizenames += prizeDto.getPrizename() + ",";
                            }
                        }
                    }
                    //记录
                    Activityrecord record = new Activityrecord();
                    record.setId(IDUtils.createUUId());
                    record.setActivityid(activity.getId());
                    record.setLogicid(logic.getId());
                    record.setCreatetime(new Date());
                    record.setUserid(response.getUser().getUserid());
                    record.setUsername(response.getUser().getUsername());
                    if(ObjectHelper.isNotEmpty(prizenames)){
                        record.setHavprize(true);
                        record.setPrizenames(prizenames.substring(0,prizenames.length()-1));
                    }
                    activityrecordMapper.insert(record);
                }
            }
        }
        if(ObjectHelper.isNotEmpty(response.getPrizes())){
            response.setBingo(true);
        }else{
            response.setBingo(false);
        }
        return response;
    }

    private PrizeDto sendPrize(ActivityUser user, Activityprize prize) {
        //保证数量，注意：如果请求过于频繁请自定义发放机制，或者排队模式以保证数量问题
        PrizeDto dto = null;
        if(prize.getSurnum()==-1 || prize.getSurnum()>=prize.getIssuenum()){
            //发放奖品
            activityPrizeIService.execute(user,prize);
            activityprizeMapper.updateSurnum(prize.getId(),prize.getIssuenum());
            dto = new PrizeDto();
            dto.setNum(prize.getIssuenum());
            dto.setPrizename(prize.getPrizename());
            dto.setPrizeexplain(prize.getPrizeexplain());
        }
        return dto;
    }

    private String resultPrizeString(Activityprize prize){
        if(prize.getIssuenum()!=1){
            return prize.getPrizename() + "*" + prize.getIssuenum();
        }else{
            return prize.getPrizename() ;
        }
    }


}
