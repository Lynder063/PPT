package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Test pro třídu HashMap (slovník v Javě) a její metodu put() (ekvivalent Add)
 */
public class HashMapTest {

    @Test
    public void testMapPut() {
        // Arrange - připravíme testovací data
        Map<String, Integer> slovnik = new HashMap<>();

        // Act - vložíme data do slovníku
        Integer predchoziHodnota1 = slovnik.put("jablko", 10);
        Integer predchoziHodnota2 = slovnik.put("hruška", 20);

        // Assert - ověříme správné vložení dat
        assertEquals(10, slovnik.get("jablko"), "Hodnota pro klíč 'jablko' by měla být 10");
        assertEquals(20, slovnik.get("hruška"), "Hodnota pro klíč 'hruška' by měla být 20");
        assertNull(predchoziHodnota1, "Předchozí hodnota pro nový klíč by měla být null");
        assertNull(predchoziHodnota2, "Předchozí hodnota pro nový klíč by měla být null");

        // Test přepsání hodnoty pro existující klíč
        Integer predchoziHodnota3 = slovnik.put("jablko", 15);
        assertEquals(15, slovnik.get("jablko"), "Hodnota pro klíč 'jablko' by měla být přepsána na 15");
        assertEquals(10, predchoziHodnota3, "Předchozí hodnota by měla být původní hodnota 10");

        // Test pro null klíč a hodnotu
        slovnik.put(null, 30);
        slovnik.put("null-hodnota", null);

        assertEquals(30, slovnik.get(null), "HashMap umožňuje mít null jako klíč");
        assertNull(slovnik.get("null-hodnota"), "HashMap umožňuje mít null jako hodnotu");

        // Test velikosti a existence
        assertEquals(4, slovnik.size(), "Slovník by měl obsahovat 4 položky");
        assertTrue(slovnik.containsKey("jablko"), "Slovník by měl obsahovat klíč 'jablko'");
        assertFalse(slovnik.containsKey("banán"), "Slovník by neměl obsahovat klíč 'banán'");
    }
}