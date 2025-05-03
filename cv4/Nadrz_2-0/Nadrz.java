import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro Nadrz (verze 2.0)
 */
public class NadrzTest {

    /**
     * Test pro inicializaci nádrže
     */
    @Test
    public void testInicializace() {
        Nadrz nadrz = new Nadrz(100.0);
        assertEquals(100.0, nadrz.get_kapacita(), "Kapacita nádrže by měla být 100.0");
        assertEquals(0.0, nadrz.get_stav(), "Počáteční stav nádrže by měl být 0.0");
    }

    /**
     * Test pro přidání kapaliny do nádrže
     */
    @Test
    public void testAdd() {
        Nadrz nadrz = new Nadrz(100.0);

        try {
            // Přidání platné hodnoty
            assertTrue(nadrz.add(50.0), "Přidání 50.0 by mělo být úspěšné");
            assertEquals(50.0, nadrz.get_stav(), "Stav nádrže by měl být 50.0");

            // Přidání další platné hodnoty
            assertTrue(nadrz.add(30.0), "Přidání 30.0 by mělo být úspěšné");
            assertEquals(80.0, nadrz.get_stav(), "Stav nádrže by měl být 80.0");

            // Přidání záporné hodnoty
            assertFalse(nadrz.add(-10.0), "Přidání záporné hodnoty by mělo selhat");
            assertEquals(80.0, nadrz.get_stav(), "Stav nádrže by se neměl změnit");
        } catch (PlnaNadrzException e) {
            fail("Neměla by být vyhozena výjimka při standardním přidávání");
        }
    }

    /**
     * Test pro výjimku při přeplnění nádrže
     */
    @Test
    public void testAddVyjimka() {
        Nadrz nadrz = new Nadrz(100.0);

        try {
            // Nejprve přidat platnou hodnotu
            nadrz.add(80.0);

            // Pokus o přidání hodnoty, která přeplní nádrž
            assertThrows(PlnaNadrzException.class, () -> {
                nadrz.add(30.0);
            }, "Měla by být vyhozena výjimka PlnaNadrzException");

        } catch (PlnaNadrzException e) {
            fail("Neměla by být vyhozena výjimka při standardním přidávání");
        }
    }

    /**
     * Test pro odebrání kapaliny z nádrže
     */
    @Test
    public void testRemove() {
        Nadrz nadrz = new Nadrz(100.0);

        try {
            // Nejprve přidat kapalinu
            nadrz.add(80.0);

            // Odebrání platné hodnoty
            assertTrue(nadrz.remove(30.0), "Odebrání 30.0 by mělo být úspěšné");
            assertEquals(50.0, nadrz.get_stav(), "Stav nádrže by měl být 50.0");

            // Odebrání další platné hodnoty
            assertTrue(nadrz.remove(40.0), "Odebrání 40.0 by mělo být úspěšné");
            assertEquals(10.0, nadrz.get_stav(), "Stav nádrže by měl být 10.0");

            // Odebrání záporné hodnoty
            assertFalse(nadrz.remove(-10.0), "Odebrání záporné hodnoty by mělo selhat");
            assertEquals(10.0, nadrz.get_stav(), "Stav nádrže by se neměl změnit");
        } catch (Exception e) {
            fail("Neměla by být vyhozena výjimka při standardním odebírání");
        }
    }

    /**
     * Test pro výjimku při vyprázdnění nádrže
     */
    @Test
    public void testRemoveVyjimka() {
        Nadrz nadrz = new Nadrz(100.0);

        try {
            // Nejprve přidat kapalinu
            nadrz.add(50.0);

            // Pokus o odebrání hodnoty větší než je v nádrži
            assertThrows(PrazdnaNadrzException.class, () -> {
                nadrz.remove(60.0);
            }, "Měla by být vyhozena výjimka PrazdnaNadrzException");

        } catch (PlnaNadrzException e) {
            fail("Neměla by být vyhozena výjimka při standardním přidávání");
        }
    }

    /**
     * Test pro ověření hraničních hodnot
     */
    @Test
    public void testHranicniHodnoty() {
        Nadrz nadrz = new Nadrz(100.0);

        try {
            // Plná nádrž
            assertTrue(nadrz.add(100.0), "Přidání přesně do plné kapacity by mělo být úspěšné");
            assertEquals(100.0, nadrz.get_stav(), "Stav nádrže by měl být 100.0");

            // Přidání malého množství do plné nádrže
            assertThrows(PlnaNadrzException.class, () -> {
                nadrz.add(0.1);
            }, "Měla by být vyhozena výjimka PlnaNadrzException");

            // Odebrání veškerého obsahu
            assertTrue(nadrz.remove(100.0), "Odebrání veškerého obsahu by mělo být úspěšné");
            assertEquals(0.0, nadrz.get_stav(), "Stav nádrže by měl být 0.0");

            // Odebrání z prázdné nádrže
            assertThrows(PrazdnaNadrzException.class, () -> {
                nadrz.remove(0.1);
            }, "Měla by být vyhozena výjimka PrazdnaNadrzException");

        } catch (Exception e) {
            fail("Neočekávaná výjimka: " + e.getMessage());
        }
    }

    /**
     * Test pro ověření vytvoření nádrže s neplatnou kapacitou
     */
    @Test
    public void testNeplatnaKapacita() {
        Nadrz nadrz = new Nadrz(-100.0);
        assertEquals(0.0, nadrz.get_kapacita(), "Kapacita nádrže by měla být 0.0 pro zápornou vstupní hodnotu");
    }
}