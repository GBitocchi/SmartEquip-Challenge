package org.smartequip.dto;

import java.util.Map;

public class Schedule {
    private Map<String, YearData> years;
    private double defaultMarketRatio;
    private double defaultAuctionRatio;

    public Map<String, YearData> getYears() {
        return years;
    }

    public void setYears(Map<String, YearData> years) {
        this.years = years;
    }

    public double getDefaultMarketRatio() {
        return defaultMarketRatio;
    }

    public void setDefaultMarketRatio(double defaultMarketRatio) {
        this.defaultMarketRatio = defaultMarketRatio;
    }

    public double getDefaultAuctionRatio() {
        return defaultAuctionRatio;
    }

    public void setDefaultAuctionRatio(double defaultAuctionRatio) {
        this.defaultAuctionRatio = defaultAuctionRatio;
    }
}
