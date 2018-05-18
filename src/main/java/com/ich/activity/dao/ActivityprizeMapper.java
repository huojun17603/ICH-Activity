package com.ich.activity.dao;

import com.ich.activity.pojo.Activityprize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityprizeMapper {

    List<Activityprize> selectByLogicId(String logicid);

    Activityprize selectDafByGrp(@Param("logicid") String logicid,@Param("group") Integer grp);

    void updateSurnum(@Param("id") String id, @Param("issuenum") Integer issuenum);
}
