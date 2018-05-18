package com.ich.activity.dto;

public class PrizeDto {

    //奖励名称
    private String prizename;
    //奖励说明
    private String prizeexplain;
    //数量
    private Integer num;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
