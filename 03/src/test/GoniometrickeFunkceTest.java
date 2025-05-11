package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test pro výpočet sin a tg pro úhel zadaný ve stupních
 */
public class GoniometrickeFunkceTest {

    @Test
    public void testGoniometrickeFunkce() {
        // Arrange - připravíme testovací data
        double uhel1 = 30.0; // 30 stupňů
        double uhel2 = 45.0; // 45 stupňů
        double uhel3 = 90.0; // 90 stupňů

        // Pomocná metoda pro převod stupňů na radiány
        double toRadians1 = Math.toRadians(uhel1);
        double toRadians2 = Math.toRadians(uhel2);
        double toRadians3 = Math.toRadians(uhel3);

        // Act - zavoláme testované funkce
        double sin1 = Math.sin(toRadians1);
        double sin2 = Math.sin(toRadians2);
        double sin3 = Math.sin(toRadians3);

        double tg1 = Math.tan(toRadians1);
        double tg2 = Math.tan(toRadians2);

        // Assert - ověříme výsledky pro sin
        assertEquals(0.5, sin1, 0.0000001, "Sinus 30 stupňů by měl být 0.5");
        assertEquals(0.7071067811865475, sin2, 0.0000001, "Sinus 45 stupňů by měl být přibližně 0.707");
        assertEquals(1.0, sin3, 0.0000001, "Sinus 90 stupňů by měl být 1.0");

        // Assert - ověříme výsledky pro tg
        assertEquals(0.5773502691896257, tg1, 0.0000001, "Tangens 30 stupňů by měl být přibližně 0.577");
        assertEquals(1.0, tg2, 0.0000001, "Tangens 45 stupňů by měl být 1.0");

        // Test pro tangens 90 stupňů - očekáváme velmi vysokou hodnotu (téměř nekonečno)
        assertTrue(Math.tan(toRadians3) > 1e15, "Tangens 90 stupňů by měl být velmi vysoké číslo");
    }
}