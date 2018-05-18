package com.ich.activity.dto;

import com.ich.core.http.entity.HttpResponse;

import java.util.List;
import java.util.Map;

public class ActivityResponse extends HttpResponse{

    private ActivityUser user;

    private List<PrizeDto> prizes;

    private Map<String,Object> agrsMap;

    private Boolean bingo;

    public ActivityResponse(int status, String msg) {
        super(status, msg);
    }

    public ActivityUser getUser() {
        return user;
    }

    public void setUser(ActivityUser user) {
        this.user = user;
    }

    public List<PrizeDto> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<PrizeDto> prizes) {
        this.prizes = prizes;
    }

    public Map<String, Object> getAgrsMap() {
        return agrsMap;
    }

    public void setAgrsMap(Map<String, Object> agrsMap) {
        this.agrsMap = agrsMap;
    }

    public Boolean getBingo() {
        return bingo;
    }

    public void setBingo(Boolean bingo) {
        this.bingo = bingo;
    }
}
