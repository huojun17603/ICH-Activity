package com.ich.activity.dao;

import com.ich.activity.pojo.Activitytrigger;

public interface ActivitytriggerMapper {

    int insert(Activitytrigger activitytrigger);

    Activitytrigger selectById(String code);

}
