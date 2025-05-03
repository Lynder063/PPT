import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro Nadrz
 */
public class NadrzTest {

    /**
     * Test pro inicializaci nádrže
     */
    @Test
    public void testInicializace() {
        Nadrz nadrz = new Nadrz(100.0);
        assertEquals(100.0, nadrz.get_kapacita(), "Kapacita nádrže by měla být 100.0");
    }

    /**
     * Test pro přidání kapaliny do nádrže
     */
    @Test
    public void testAdd() {
        Nadrz nadrz = new Nadrz(100.0);

        // Přidání platné hodnoty
        assertTrue(nadrz.add(50.0), "Přidání 50.0 by mělo být úspěšné");

        // Přidání další platné hodnoty
        assertTrue(nadrz.add(30.0), "Přidání 30.0 by mělo být úspěšné");

        // Přidání hodnoty, která by překročila kapacitu
        assertFalse(nadrz.add(30.0), "Přidání 30.0 by mělo selhat, protože by překročilo kapacitu");

        // Přidání záporné hodnoty
        assertFalse(nadrz.add(-10.0), "Přidání záporné hodnoty by mělo selhat");
    }

    /**
     * Test pro odebrání kapaliny z nádrže
     */
    @Test
    public void testRemove() {
        Nadrz nadrz = new Nadrz(100.0);

        // Nejprve přidat kapalinu
        assertTrue(nadrz.add(80.0), "Přidání 80.0 by mělo být úspěšné");

        // Odebrání platné hodnoty
        assertTrue(nadrz.remove(30.0), "Odebrání 30.0 by mělo být úspěšné");

        // Odebrání další platné hodnoty
        assertTrue(nadrz.remove(40.0), "Odebrání 40.0 by mělo být úspěšné");

        // Odebrání hodnoty větší než aktuální stav
        assertFalse(nadrz.remove(20.0), "Odebrání 20.0 by mělo selhat, protože ve stavu je pouze 10.0");

        // Odebrání záporné hodnoty
        assertFalse(nadrz.remove(-10.0), "Odebrání záporné hodnoty by mělo selhat");
    }

    /**
     * Test pro ověření hraničních hodnot
     */
    @Test
    public void testHranicniHodnoty() {
        Nadrz nadrz = new Nadrz(100.0);

        // Plná nádrž
        assertTrue(nadrz.add(100.0), "Přidání přesně do plné kapacity by mělo být úspěšné");

        // Přidání malého množství do plné nádrže
        assertFalse(nadrz.add(0.1), "Přidání do plné nádrže by mělo selhat");

        // Odebrání veškerého obsahu
        assertTrue(nadrz.remove(100.0), "Odebrání veškerého obsahu by mělo být úspěšné");

        // Odebrání z prázdné nádrže
        assertFalse(nadrz.remove(0.1), "Odebrání z prázdné nádrže by mělo selhat");
    }

    /**
     * Test pro ověření vytvoření nádrže s neplatnou kapacitou
     */
    @Test
    public void testNeplatnaKapacita() {
        Nadrz nadrz = new Nadrz(-100.0);
        assertEquals(0.0, nadrz.get_kapacita(), "Kapacita nádrže by měla být 0.0 nebo větší");
    }
}