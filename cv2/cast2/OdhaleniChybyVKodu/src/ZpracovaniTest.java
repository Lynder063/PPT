/**
 * Testovací třída pro metody třídy Zpracovani.
 */
public class ZpracovaniTest {
    public static void main(String[] args) {
        testInterval();
        testVzorkySestupně();
        System.out.println("Všechny testy Zpracovani proběhly úspěšně!");
    }

    /**
     * Test metody interval.
     */
    private static void testInterval() {
        // Test kladných hodnot
        assert Zpracovani.interval(1, 5, 3) == true : "3 je v intervalu (1, 5)";
        assert Zpracovani.interval(1, 5, 1) == false : "1 není v intervalu (1, 5) (hranice)";
        assert Zpracovani.interval(1, 5, 5) == false : "5 není v intervalu (1, 5) (hranice)";
        assert Zpracovani.interval(1, 5, 0) == false : "0 není v intervalu (1, 5)";
        assert Zpracovani.interval(1, 5, 6) == false : "6 není v intervalu (1, 5)";

        // Test záporných hodnot
        assert Zpracovani.interval(-5, -1, -3) == true : "-3 je v intervalu (-5, -1)";
        assert Zpracovani.interval(-5, -1, -5) == false : "-5 není v intervalu (-5, -1) (hranice)";
        assert Zpracovani.interval(-5, -1, -1) == false : "-1 není v intervalu (-5, -1) (hranice)";

        // Test intervalu zahrnujícího nulu
        assert Zpracovani.interval(-3, 3, 0) == true : "0 je v intervalu (-3, 3)";

        System.out.println("Testy interval prošly.");
    }

    /**
     * Test metody vzorkySestupně.
     */
    private static void testVzorkySestupně() {
        Zpracovani zpracovani = new Zpracovani();

        // Test základní funkčnosti
        double[] result1 = zpracovani.vzorkySestupně(5.0, 2.0, 1.0);
        assert result1.length == 3 : "Měly by být 3 vzorky: 5, 4, 3";
        assert result1[0] == 5.0 : "První vzorek by měl být 5.0";
        assert result1[1] == 4.0 : "Druhý vzorek by měl být 4.0";
        assert result1[2] == 3.0 : "Třetí vzorek by měl být 3.0";

        // Test s desetinným krokem
        double[] result2 = zpracovani.vzorkySestupně(3.0, 1.0, 0.5);
        assert result2.length == 4 : "Měly by být 4 vzorky: 3.0, 2.5, 2.0, 1.5";
        assert result2[0] == 3.0 : "První vzorek by měl být 3.0";
        assert result2[1] == 2.5 : "Druhý vzorek by měl být 2.5";
        assert result2[2] == 2.0 : "Třetí vzorek by měl být 2.0";
        assert result2[3] == 1.5 : "Čtvrtý vzorek by měl být 1.5";

        // Test výjimek pro neplatné vstupy
        try {
            zpracovani.vzorkySestupně(2.0, 5.0, 1.0);
            assert false : "Měla by být vyhozena výjimka pro kam <= odkud";
        } catch (IllegalArgumentException e) {
            // očekávaná výjimka
        }

        try {
            zpracovani.vzorkySestupně(5.0, 2.0, -1.0);
            assert false : "Měla by být vyhozena výjimka pro záporný krok";
        } catch (IllegalArgumentException e) {
            // očekávaná výjimka
        }

        try {
            zpracovani.vzorkySestupně(5.0, 2.0, 0.0);
            assert false : "Měla by být vyhozena výjimka pro nulový krok";
        } catch (IllegalArgumentException e) {
            // očekávaná výjimka
        }

        System.out.println("Testy vzorkySestupně prošly.");
    }
}