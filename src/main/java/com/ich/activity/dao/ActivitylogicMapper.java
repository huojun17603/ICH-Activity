package com.ich.activity.dao;

import com.ich.activity.pojo.Activitylogic;

import java.util.List;

public interface ActivitylogicMapper {

    List<Activitylogic> selectByActivityId(String activityid);
}
