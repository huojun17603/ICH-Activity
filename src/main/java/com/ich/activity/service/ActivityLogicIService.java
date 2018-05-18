package com.ich.activity.service;

import com.ich.activity.dto.ActivityResponse;
import com.ich.activity.pojo.Activitylogic;

import java.util.Map;

/**
 * 逻辑接口
 * 开发时调用此接口
 */
public interface ActivityLogicIService {

    public void execute(Activitylogic logic, ActivityResponse response);

}
