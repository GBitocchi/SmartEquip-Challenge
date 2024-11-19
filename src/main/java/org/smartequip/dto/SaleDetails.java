package org.smartequip.dto;

public class SaleDetails {
    private double cost;
    private int retailSaleCount;
    private int auctionSaleCount;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getRetailSaleCount() {
        return retailSaleCount;
    }

    public void setRetailSaleCount(int retailSaleCount) {
        this.retailSaleCount = retailSaleCount;
    }

    public int getAuctionSaleCount() {
        return auctionSaleCount;
    }

    public void setAuctionSaleCount(int auctionSaleCount) {
        this.auctionSaleCount = auctionSaleCount;
    }
}
