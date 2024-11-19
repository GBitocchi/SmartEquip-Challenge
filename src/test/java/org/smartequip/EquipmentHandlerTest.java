package org.smartequip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.smartequip.dto.EquipmentData;
import org.smartequip.result.ValueCalculationResult;
import org.smartequip.result.ValueCalculationStatus;
import org.smartequip.service.EquipmentHandler;
import org.smartequip.service.EquipmentHandlerImpl;
import org.smartequip.util.DataLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipmentHandlerTest {
    private EquipmentHandler equipmentHandler;

    @BeforeEach
    void setUp() throws Exception {
        EquipmentData equipmentData = DataLoader.parseJson("api-response.json", EquipmentData.class);
        equipmentHandler = new EquipmentHandlerImpl(equipmentData.getEquipmentMap());
    }

    @Test
    void testValidCalculation() {
        ValueCalculationResult result = equipmentHandler.calculateMarketAndAuctionValues(67352, 2007);
        assertEquals(ValueCalculationStatus.SUCCESS, result.status(), "Expected status to be 'SUCCESS'");
        assertEquals(216384.71025600002, result.marketValue(), "Market value calculation mismatch");
        assertEquals(126089.52642, result.auctionValue(), "Auction value calculation mismatch");
    }

    @Test
    void testInvalidModelId() {
        ValueCalculationResult result = equipmentHandler.calculateMarketAndAuctionValues(99999, 2007);
        assertEquals(ValueCalculationStatus.EQUIPMENT_ID_NOT_FOUND, result.status(), "Expected status to be 'EQUIPMENT_ID_NOT_FOUND'");
    }

    @Test
    void testInvalidYear() {
        ValueCalculationResult result = equipmentHandler.calculateMarketAndAuctionValues(67352, 1999);
        assertEquals(ValueCalculationStatus.YEAR_NOT_FOUND, result.status(), "Expected status to be 'YEAR_NOT_FOUND'");
    }
}
