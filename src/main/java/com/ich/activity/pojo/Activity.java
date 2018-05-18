package com.ich.activity.pojo;

import java.util.Date;

public class Activity {
    //ID
    private String id;
    //期号
    private String datenum;
    //触发器CODE
    private String code;
    //标题
    private String title;
    //简介
    private String info;
    //开始时间
    private Date starttime;
    //结束时间
    private Date endtime;
    //类别；1：任务；2：活动
    private Integer classes;
    //HTTP链接
    private String http;
    //状态；1：未激活；2：激活；3：关闭
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatenum() {
        return datenum;
    }

    public void setDatenum(String datenum) {
        this.datenum = datenum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
