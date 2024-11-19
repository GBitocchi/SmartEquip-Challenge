package org.smartequip;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.smartequip.dto.Equipment;
import org.smartequip.dto.EquipmentData;

import java.io.InputStream;
import java.util.Map;

class DataLoaderTest {
    @Test
    void testValidFileLoading() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("api-response.json");
        assertNotNull(inputStream, "File should be loaded from the resources folder");

        EquipmentData data = new ObjectMapper().readValue(inputStream, EquipmentData.class);
        assertNotNull(data, "Data should not be null for a valid file");

        Map<String, Equipment> equipmentMap = data.getEquipmentMap();
        assertNotNull(equipmentMap, "Equipment map should not be null");
        assertTrue(equipmentMap.containsKey("67352"), "Equipment map should contain key '67352'");
        assertTrue(equipmentMap.containsKey("87390"), "Equipment map should contain key '87390'");

        Equipment equipment = equipmentMap.get("67352");
        assertEquals("Caterpillar", equipment.getClassification().getMake(), "Make mismatch for equipment '67352'");
        assertEquals(681252, equipment.getSaleDetails().getCost(), "Cost mismatch for equipment '67352'");
    }

    @Test
    void testFileNotFound() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("non-existent.json");
        assertNull(inputStream, "InputStream should be null for non-existent file");
    }
}
