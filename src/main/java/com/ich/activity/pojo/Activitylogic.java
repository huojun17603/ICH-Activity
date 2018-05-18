package com.ich.activity.pojo;

public class Activitylogic {
    //ID
    private String id;
    //活动ID
    private String activityid;
    //逻辑名称
    private String name;
    //逻辑值
    private String logicval;
    //逻辑说明
    private String logicexplain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogicval() {
        return logicval;
    }

    public void setLogicval(String logicval) {
        this.logicval = logicval;
    }

    public String getLogicexplain() {
        return logicexplain;
    }

    public void setLogicexplain(String logicexplain) {
        this.logicexplain = logicexplain;
    }
}
