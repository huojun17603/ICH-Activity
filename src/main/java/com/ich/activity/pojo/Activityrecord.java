package com.ich.activity.pojo;

import java.util.Date;

public class Activityrecord {
    //ID
    private String id;
    //活动ID
    private String activityid;
    //逻辑ID
    private String logicid;
    //获得者ID
    private String userid;
    //获得者名称
    private String username;
    //获得时间
    private Date createtime;
    //是否活动礼物
    private Boolean havprize;
    //获得的礼物
    private String prizenames;

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

    public String getLogicid() {
        return logicid;
    }

    public void setLogicid(String logicid) {
        this.logicid = logicid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPrizenames() {
        return prizenames;
    }

    public void setPrizenames(String prizenames) {
        this.prizenames = prizenames;
    }

    public Boolean getHavprize() {
        return havprize;
    }

    public void setHavprize(Boolean havprize) {
        this.havprize = havprize;
    }
}
