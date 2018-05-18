package com.ich.activity.service;

import com.ich.activity.dto.ActivityResponse;
import com.ich.core.http.entity.HttpResponse;

import java.util.Map;

public interface ActivityCoreService {
    /**
     *  执行活动、任务
     * @param triCode 触发器CODE
     * @param agrMaps 参数MAP，
     * @return 中奖信息
     */
    public ActivityResponse execute(String triCode,  Map<String,Object> agrMaps);
}
