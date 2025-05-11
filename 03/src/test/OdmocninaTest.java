package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test pro funkci Math.sqrt() počítající odmocninu čísla
 */
public class OdmocninaTest {

    @Test
    public void testOdmocnina() {
        // Arrange - připravíme testovací data
        double cislo1 = 9.0;
        double cislo2 = 2.0;
        double cislo3 = 0.0;

        // Act - zavoláme testovanou funkci
        double vysledek1 = Math.sqrt(cislo1);
        double vysledek2 = Math.sqrt(cislo2);
        double vysledek3 = Math.sqrt(cislo3);

        // Assert - ověříme výsledky
        assertEquals(3.0, vysledek1, "Odmocnina z 9 by měla být 3");
        assertEquals(1.4142135623730951, vysledek2, "Odmocnina z 2 by měla být přibližně 1.414");
        assertEquals(0.0, vysledek3, "Odmocnina z 0 by měla být 0");

        // Testování hraničních hodnot
        assertTrue(Double.isNaN(Math.sqrt(-1.0)), "Odmocnina z negativního čísla by měla být NaN");
        assertEquals(Double.POSITIVE_INFINITY, Math.sqrt(Double.POSITIVE_INFINITY), "Odmocnina z nekonečna by měla být nekonečno");
    }
}