package com.ich.activity.dao;

import com.ich.activity.pojo.Activity;

import java.util.List;

public interface ActivityMapper {
    List<Activity> selectEffectiveList(String code);
}
