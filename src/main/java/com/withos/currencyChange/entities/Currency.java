package com.withos.currencyChange.entities;

public class Currency {
    private final String currName;
    private final int multiplier;
    private final String currCode;
    private final double avgExchRate;

    public Currency(String name, int mult, String code, double rate){
        this.currName = name;
        this.multiplier = mult;
        this.currCode = code;
        this.avgExchRate = rate;
    }

    public double getAvgExchRate() {
        return avgExchRate;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public String getCurrCode() {
        return currCode;
    }

    public String getCurrName() {
        return currName;
    }
}
