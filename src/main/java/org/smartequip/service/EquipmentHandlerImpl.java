package org.smartequip.service;

import org.smartequip.dto.Equipment;
import org.smartequip.result.ValueCalculationResult;
import org.smartequip.dto.YearData;
import org.smartequip.result.ValueCalculationStatus;

import java.util.Map;

public class EquipmentHandlerImpl implements EquipmentHandler {

    private final Map<String, Equipment> equipmentData;

    public EquipmentHandlerImpl(final Map<String, Equipment> equipmentData) {
        this.equipmentData = equipmentData;
    }

    @Override
    public ValueCalculationResult calculateMarketAndAuctionValues(final int equipmentModelID, final int year){
        try{
            if (!equipmentData.containsKey(String.valueOf(equipmentModelID))) {
                return new ValueCalculationResult(ValueCalculationStatus.EQUIPMENT_ID_NOT_FOUND, equipmentModelID, year, -1, -1);
            }
            final Equipment equipmentModelData = equipmentData.get(String.valueOf(equipmentModelID));

            final Map<String, YearData> equipmentModelYears = equipmentModelData.getSchedule().getYears();
            if (!equipmentModelYears.containsKey(String.valueOf(year))) {
                return new ValueCalculationResult(ValueCalculationStatus.YEAR_NOT_FOUND, equipmentModelID, year, -1, -1);
            }
            final YearData yearData = equipmentModelYears.get(String.valueOf(year));

            final double equipmentCost = equipmentModelData.getSaleDetails().getCost();
            final double marketRatio = yearData.getMarketRatio();
            final double auctionRatio = yearData.getAuctionRatio();
            final double equipmentMarketValue = equipmentCost * marketRatio;
            final double equipmentAuctionValue = equipmentCost * auctionRatio;

            return new ValueCalculationResult(ValueCalculationStatus.SUCCESS, equipmentModelID, year, equipmentMarketValue, equipmentAuctionValue);
        }
        catch (Exception exception) {
            System.err.println("Error while calculating values for an equipment: " + exception);
            throw exception;
        }
    }
}
