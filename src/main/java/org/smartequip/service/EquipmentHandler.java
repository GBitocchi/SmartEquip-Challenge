package org.smartequip.service;

import org.smartequip.result.ValueCalculationResult;

public interface EquipmentHandler {

    /**
     * Takes an equipment ID and a year and calculates its market and auction values.
     *
     * @param equipmentModelID an equipment model ID to perform the calculation
     * @param year a year to perform the calculation
     * @return the result from calculating the values of the equipment in a given year
     */
    ValueCalculationResult calculateMarketAndAuctionValues(final int equipmentModelID, final int year);
}
