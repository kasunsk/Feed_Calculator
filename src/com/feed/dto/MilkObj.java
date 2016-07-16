package com.feed.dto;

/**
 * Created by kasun on 7/16/16.
 */
public class MilkObj {

    private Integer liters;
    private Double tdn;
    private Double dcp;

    public MilkObj() {
    }

    public MilkObj(Integer liters, Double tdn, Double dcp) {
        this.liters = liters;
        this.tdn = tdn;
        this.dcp = dcp;
    }

    public Integer getLiters() {
        return liters;
    }

    public void setLiters(Integer liters) {
        this.liters = liters;
    }

    public Double getTdn() {
        return tdn;
    }

    public void setTdn(Double tdn) {
        this.tdn = tdn;
    }

    public Double getDcp() {
        return dcp;
    }

    public void setDcp(Double dcp) {
        this.dcp = dcp;
    }
}
