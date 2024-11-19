package org.smartequip.result;

public record ValueCalculationResult(ValueCalculationStatus status,
                                     int equipmentID,
                                     int year,
                                     double marketValue,
                                     double auctionValue) {

    @Override
    public String toString() {
        return "Equipment ID: " + equipmentID + ", year: " + year + ", Calculation Status: " + status + ", Market Value: " + marketValue + ", Auction Value: " + auctionValue;
    }
}
