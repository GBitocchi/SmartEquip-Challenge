package org.smartequip.dto;

public class Equipment {
    private Schedule schedule;
    private SaleDetails saleDetails;
    private Classification classification;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public SaleDetails getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(SaleDetails saleDetails) {
        this.saleDetails = saleDetails;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }
}
