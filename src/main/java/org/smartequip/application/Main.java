package org.smartequip.application;

import org.smartequip.dto.EquipmentData;
import org.smartequip.service.EquipmentHandler;
import org.smartequip.service.EquipmentHandlerImpl;
import org.smartequip.util.DataLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final EquipmentData equipmentData = DataLoader.parseJson("api-response.json", EquipmentData.class);

        final EquipmentHandler equipmentsHandler = new EquipmentHandlerImpl(equipmentData.getEquipmentMap());

        System.out.println(equipmentsHandler.calculateMarketAndAuctionValues(67352, 2007));
        System.out.println(equipmentsHandler.calculateMarketAndAuctionValues(87964, 2011));
    }
}