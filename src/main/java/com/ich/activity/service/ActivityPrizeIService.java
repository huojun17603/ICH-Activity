package com.ich.activity.service;

import com.ich.activity.dto.ActivityUser;
import com.ich.activity.pojo.Activityprize;
/**
 * 必须被实现的类
 */
public interface ActivityPrizeIService {

   public void execute(ActivityUser user, Activityprize prize);

}
