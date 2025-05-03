package dvojbran;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro ověření funkčnosti třídy ElektrickyDvojbran
 */
public class ElektrickyDvojbranTest {

    /**
     * Test metody pro výpočet výstupního napětí a proudu v obecném dvojbranu
     */
    @Test
    public void testVypocitejVystupy() {
        ElektrickyDvojbran dvojbran = new ElektrickyDvojbran(1.5, 200, 0.005, 1.0);

        double vstupniNapeti = 230.0;
        double zatez = 1000.0;

        double ocekavaneVystupniNapeti = vstupniNapeti / (1.5 + (200.0 / 1000.0));
        double ocekavanyVystupniProud = ocekavaneVystupniNapeti / zatez;

        ocekavaneVystupniNapeti = Math.round(ocekavaneVystupniNapeti * 100.0) / 100.0;
        ocekavanyVystupniProud = Math.round(ocekavanyVystupniProud * 100.0) / 100.0;

        double[] vysledek = dvojbran.vypocitejVystupy(vstupniNapeti, zatez);

        assertEquals(ocekavaneVystupniNapeti, vysledek[0], 0.01,
                "Výstupní napětí by mělo být " + ocekavaneVystupniNapeti);
        assertEquals(ocekavanyVystupniProud, vysledek[1], 0.01,
                "Výstupní proud by měl být " + ocekavanyVystupniProud);
    }

    /**
     * Test metody pro výpočet výstupního napětí a proudu v napěťovém děliči
     */
    @Test
    public void testNapetovyDelic() {
        ElektrickyDvojbran napetovyDelic = ElektrickyDvojbran.vytvorNapetovyDelic(5.0);

        double vstupniNapeti = 10.0;
        double zatez = 15.0;

        double ocekavaneVystupniNapeti = vstupniNapeti * (zatez / (5.0 + zatez));

        double ocekavanyVystupniProud = ocekavaneVystupniNapeti / zatez;

        ocekavaneVystupniNapeti = Math.round(ocekavaneVystupniNapeti * 100.0) / 100.0;
        ocekavanyVystupniProud = Math.round(ocekavanyVystupniProud * 100.0) / 100.0;

        double[] vysledek = napetovyDelic.vypocitejVystupy(vstupniNapeti, zatez);

        assertEquals(ocekavaneVystupniNapeti, vysledek[0], 0.01,
                "Výstupní napětí by mělo být " + ocekavaneVystupniNapeti);
        assertEquals(ocekavanyVystupniProud, vysledek[1], 0.01,
                "Výstupní proud by měl být " + ocekavanyVystupniProud);
    }

    /**
     * Test pro mezní hodnoty
     */
    @Test
    public void testMezniHodnoty() {
        ElektrickyDvojbran dvojbran = new ElektrickyDvojbran(1.0, 0.0, 0.0, 1.0);

        double[] vysledek = dvojbran.vypocitejVystupy(100.0, 50.0);
        assertEquals(100.0, vysledek[0], 0.01);
        assertEquals(2.0, vysledek[1], 0.01);
    }

    /**
     * Test pro různé hodnoty zátěže
     */
    @Test
    public void testRuzneZateze() {
        ElektrickyDvojbran dvojbran = new ElektrickyDvojbran(1.0, 100.0, 0.01, 1.0);
        double vstupniNapeti = 100.0;

        double[] vysledek1 = dvojbran.vypocitejVystupy(vstupniNapeti, 100.0);

        double[] vysledek2 = dvojbran.vypocitejVystupy(vstupniNapeti, 1000.0);


        assertTrue(vysledek2[0] > vysledek1[0],
                "S vyšší zátěží by mělo být vyšší výstupní napětí");

        assertTrue(vysledek2[1] < vysledek1[1],
                "S vyšší zátěží by měl být nižší výstupní proud");
    }

    /**
     * Test pro porovnání implementace napěťového děliče s obecným dvojbranem
     */
    @Test
    public void testEkvivalenceDeliceDvojbranu() {
        ElektrickyDvojbran delic = ElektrickyDvojbran.vytvorNapetovyDelic(10.0);

        ElektrickyDvojbran dvojbran = new ElektrickyDvojbran(1.0, 10.0, 0.0, 1.0);

        double vstupniNapeti = 12.0;
        double zatez = 20.0;

        double[] vysledekDelic = delic.vypocitejVystupy(vstupniNapeti, zatez);
        double[] vysledekDvojbran = dvojbran.vypocitejVystupy(vstupniNapeti, zatez);

        assertEquals(vysledekDelic[0], vysledekDvojbran[0], 0.01,
                "Výstupní napětí by mělo být stejné pro obě implementace");
        assertEquals(vysledekDelic[1], vysledekDvojbran[1], 0.01,
                "Výstupní proud by měl být stejný pro obě implementace");
    }
}