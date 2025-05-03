import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro Nadrz (aktuální verze)
 * Obsahuje kompletní testy pro verzi 2.0 třídy Nadrz
 *
 * @author Student
 * @version 2.0
 */
public class NadrzTest {

    private Nadrz nadrz;
    private final double KAPACITA = 100.0;

    /**
     * Inicializace nádrže před každým testem
     */
    @BeforeEach
    public void setUp() {
        nadrz = new Nadrz(KAPACITA);
    }

    /**
     * Test pro inicializaci nádrže
     */
    @Test
    public void testInicializace() {
        assertEquals(KAPACITA, nadrz.get_kapacita(), "Kapacita nádrže by měla být " + KAPACITA);
        assertEquals(0.0, nadrz.get_stav(), "Počáteční stav nádrže by měl být 0.0");
    }

    /**
     * Test pro přidání kapaliny do nádrže
     */
    @Test
    public void testAdd() {
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
            fail("Neměla by být vyhozena výjimka při standardním přidávání: " + e.getMessage());
        }
    }

    /**
     * Test pro výjimku při přeplnění nádrže
     */
    @Test
    public void testAddVyjimka() {
        try {
            // Nejprve přidat platnou hodnotu
            nadrz.add(80.0);

            // Pokus o přidání hodnoty, která přeplní nádrž
            PlnaNadrzException thrown = assertThrows(PlnaNadrzException.class, () -> {
                nadrz.add(30.0);
            }, "Měla by být vyhozena výjimka PlnaNadrzException");

            // Ověření, že výjimka obsahuje smysluplnou zprávu
            assertTrue(thrown.getMessage().contains("30.0"), "Zpráva výjimky by měla obsahovat přidávané množství");
            assertTrue(thrown.getMessage().contains("80.0") || thrown.getMessage().contains("stav"),
                    "Zpráva výjimky by měla obsahovat informaci o aktuálním stavu");
        } catch (PlnaNadrzException e) {
            fail("Neměla by být vyhozena výjimka při standardním přidávání: " + e.getMessage());
        }
    }

    /**
     * Test pro odebrání kapaliny z nádrže
     */
    @Test
    public void testRemove() {
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
            fail("Neměla by být vyhozena výjimka při standardním odebírání: " + e.getMessage());
        }
    }

    /**
     * Test pro výjimku při vyprázdnění nádrže
     */
    @Test
    public void testRemoveVyjimka() {
        try {
            // Nejprve přidat kapalinu
            nadrz.add(50.0);

            // Pokus o odebrání hodnoty větší než je v nádrži
            PrazdnaNadrzException thrown = assertThrows(PrazdnaNadrzException.class, () -> {
                nadrz.remove(60.0);
            }, "Měla by být vyhozena výjimka PrazdnaNadrzException");

            // Ověření, že výjimka obsahuje smysluplnou zprávu
            assertTrue(thrown.getMessage().contains("60.0"), "Zpráva výjimky by měla obsahovat odebírané množství");
            assertTrue(thrown.getMessage().contains("50.0") || thrown.getMessage().contains("pouze"),
                    "Zpráva výjimky by měla obsahovat informaci o aktuálním stavu");
        } catch (PlnaNadrzException e) {
            fail("Neměla by být vyhozena výjimka při standardním přidávání: " + e.getMessage());
        }
    }

    /**
     * Test pro ověření hraničních hodnot
     */
    @Test
    public void testHranicniHodnoty() {
        try {
            // Plná nádrž
            assertTrue(nadrz.add(KAPACITA), "Přidání přesně do plné kapacity by mělo být úspěšné");
            assertEquals(KAPACITA, nadrz.get_stav(), "Stav nádrže by měl být " + KAPACITA);

            // Přidání malého množství do plné nádrže
            assertThrows(PlnaNadrzException.class, () -> {
                nadrz.add(0.1);
            }, "Měla by být vyhozena výjimka PlnaNadrzException");

            // Odebrání veškerého obsahu
            assertTrue(nadrz.remove(KAPACITA), "Odebrání veškerého obsahu by mělo být úspěšné");
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
        Nadrz neplatnaNadrz = new Nadrz(-100.0);
        assertEquals(0.0, neplatnaNadrz.get_kapacita(), "Kapacita nádrže by měla být 0.0 pro zápornou vstupní hodnotu");
    }

    /**
     * Test pro ověření správné implementace hraničních případů výjimek
     */
    @Test
    public void testSpecialniPripady() {
        Nadrz malaNavrz = new Nadrz(50.0);

        try {
            // Naplnění nádrže přesně na kapacitu
            malaNavrz.add(50.0);

            // Vyprázdnění nádrže přesně na nulu
            malaNavrz.remove(50.0);
            assertEquals(0.0, malaNavrz.get_stav(), "Stav nádrže by měl být přesně 0.0");

            // Pokus o odebrání přesně 0 jednotek z prázdné nádrže
            assertTrue(malaNavrz.remove(0.0), "Odebrání 0 jednotek by mělo být vždy úspěšné");

            // Přidání přesně 0 jednotek do prázdné nádrže
            assertTrue(malaNavrz.add(0.0), "Přidání 0 jednotek by mělo být vždy úspěšné");

        } catch (Exception e) {
            fail("Neočekávaná výjimka při testování speciálních případů: " + e.getMessage());
        }
    }

    /**
     * Test pro postupné naplnění a vyprázdnění nádrže
     */
    @Test
    public void testPostupneOperace() {
        try {
            // Série přidání
            nadrz.add(10.0);
            assertEquals(10.0, nadrz.get_stav(), "Stav by měl být 10.0");

            nadrz.add(20.0);
            assertEquals(30.0, nadrz.get_stav(), "Stav by měl být 30.0");

            nadrz.add(30.0);
            assertEquals(60.0, nadrz.get_stav(), "Stav by měl být 60.0");

            // Série odebrání
            nadrz.remove(15.0);
            assertEquals(45.0, nadrz.get_stav(), "Stav by měl být 45.0");

            nadrz.remove(25.0);
            assertEquals(20.0, nadrz.get_stav(), "Stav by měl být 20.0");

            nadrz.remove(20.0);
            assertEquals(0.0, nadrz.get_stav(), "Stav by měl být 0.0");

            // Pokus o odebrání z prázdné nádrže
            assertThrows(PrazdnaNadrzException.class, () -> {
                nadrz.remove(1.0);
            }, "Měla by být vyhozena výjimka");

        } catch (Exception e) {
            fail("Neočekávaná výjimka: " + e.getMessage());
        }
    }
}