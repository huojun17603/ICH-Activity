package com.ich.activity.pojo;

public class Activitytrigger {

    private String code;

    private String name;

    private String remark;
    //是否使用自带的奖励机制
    private Boolean rewardsystem;
    //实现接口的类名
    private String serviceimpl;

    public String getServiceimpl() {
        return serviceimpl;
    }

    public void setServiceimpl(String serviceimpl) {
        this.serviceimpl = serviceimpl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getRewardsystem() {
        return rewardsystem;
    }

    public void setRewardsystem(Boolean rewardsystem) {
        this.rewardsystem = rewardsystem;
    }
}
