package com.feed.dto;

/**
 * Created by kasun on 7/16/16.
 */
public class FeedObj {

    private String food;
    private Double tdn;
    private Double dm;

    public FeedObj() {
    }

    public FeedObj(String food, Double tdn, Double dm) {
        this.food = food;
        this.tdn = tdn;
        this.dm = dm;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Double getTdn() {
        return tdn;
    }

    public void setTdn(Double tdn) {
        this.tdn = tdn;
    }

    public Double getDm() {
        return dm;
    }

    public void setDm(Double dm) {
        this.dm = dm;
    }
}
