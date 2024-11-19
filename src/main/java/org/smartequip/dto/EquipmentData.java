package org.smartequip.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class EquipmentData {
    private final Map<String, Equipment> equipmentMap = new HashMap<>();

    @JsonAnySetter
    public void addEquipment(String id, Equipment equipment) {
        equipmentMap.put(id, equipment);
    }

    public Map<String, Equipment> getEquipmentMap() {
        return equipmentMap;
    }
}
