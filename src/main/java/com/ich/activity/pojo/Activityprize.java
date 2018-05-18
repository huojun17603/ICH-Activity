package com.ich.activity.pojo;

public class Activityprize {
    //ID
    private String id;
    //逻辑ID
    private String logicid;
    //分组；同一组只能有一个奖品；大于0的整数
    private Integer grp;
    //几率
    private Integer grplv;
    //顺序
    private Integer grponum;
    //默认；1是；2否；
    private Integer grpdelf;
    //发放数量
    private Integer issuenum;
    //总数量,-1代表无限
    private Integer sumnum;
    //剩余数量,-1代表无限
    private Integer surnum;
    //奖励名称
    private String prizename;
    //奖励说明
    private String prizeexplain;
    //奖励来源
    private Integer prizesource;
    //奖励来源值
    private String prizesourceval;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogicid() {
        return logicid;
    }

    public void setLogicid(String logicid) {
        this.logicid = logicid;
    }

    public Integer getGrp() {
        return grp;
    }

    public void setGrp(Integer grp) {
        this.grp = grp;
    }

    public Integer getGrplv() {
        return grplv;
    }

    public void setGrplv(Integer grplv) {
        this.grplv = grplv;
    }

    public Integer getGrponum() {
        return grponum;
    }

    public void setGrponum(Integer grponum) {
        this.grponum = grponum;
    }

    public Integer getGrpdelf() {
        return grpdelf;
    }

    public void setGrpdelf(Integer grpdelf) {
        this.grpdelf = grpdelf;
    }

    public Integer getIssuenum() {
        return issuenum;
    }

    public void setIssuenum(Integer issuenum) {
        this.issuenum = issuenum;
    }

    public Integer getSumnum() {
        return sumnum;
    }

    public void setSumnum(Integer sumnum) {
        this.sumnum = sumnum;
    }

    public Integer getSurnum() {
        return surnum;
    }

    public void setSurnum(Integer surnum) {
        this.surnum = surnum;
    }

    public String getPrizename() {
        return prizename;
    }

    public void setPrizename(String prizename) {
        this.prizename = prizename;
    }

    public String getPrizeexplain() {
        return prizeexplain;
    }

    public void setPrizeexplain(String prizeexplain) {
        this.prizeexplain = prizeexplain;
    }

    public Integer getPrizesource() {
        return prizesource;
    }

    public void setPrizesource(Integer prizesource) {
        this.prizesource = prizesource;
    }

    public String getPrizesourceval() {
        return prizesourceval;
    }

    public void setPrizesourceval(String prizesourceval) {
        this.prizesourceval = prizesourceval;
    }
}
