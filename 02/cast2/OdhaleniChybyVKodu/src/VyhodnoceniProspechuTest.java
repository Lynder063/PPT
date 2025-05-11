/**
 * Testovací třída pro VyhodnoceniProspechu.
 */
public class VyhodnoceniProspechuTest {
    public static void main(String[] args) {
        testProspech();
        testPrumerException();
        System.out.println("Všechny testy VyhodnoceniProspechu proběhly úspěšně!");
    }

    /**
     * Test metody prospech pro různá pole známek.
     */
    private static void testProspech() {
        VyhodnoceniProspechu vyhodnoceni = new VyhodnoceniProspechu();

        // Test "výborně" (průměr <= 1.5)
        assert vyhodnoceni.prospech(new int[]{1, 1, 1}).equals("výborně") : "Průměr 1.0 by měl být 'výborně'";
        assert vyhodnoceni.prospech(new int[]{1, 2, 1}).equals("výborně") : "Průměr 1.33 by měl být 'výborně'";
        assert vyhodnoceni.prospech(new int[]{1, 2, 2}).equals("výborně") : "Průměr 1.67 by měl být 'výborně'";

        // Test "chvalitebně" (1.5 < průměr <= 2.5)
        assert vyhodnoceni.prospech(new int[]{2, 2, 2}).equals("chvalitebně") : "Průměr 2.0 by měl být 'chvalitebně'";
        assert vyhodnoceni.prospech(new int[]{1, 3, 3}).equals("chvalitebně") : "Průměr 2.33 by měl být 'chvalitebně'";

        // Test "dobře" (2.5 < průměr <= 3.5)
        assert vyhodnoceni.prospech(new int[]{3, 3, 3}).equals("dobře") : "Průměr 3.0 by měl být 'dobře'";
        assert vyhodnoceni.prospech(new int[]{2, 4, 4}).equals("dobře") : "Průměr 3.33 by měl být 'dobře'";

        // Test "dostatečně" (3.5 < průměr <= 4.5)
        assert vyhodnoceni.prospech(new int[]{4, 4, 4}).equals("dostatečně") : "Průměr 4.0 by měl být 'dostatečně'";
        assert vyhodnoceni.prospech(new int[]{4, 5, 4}).equals("dostatečně") : "Průměr 4.33 by měl být 'dostatečně'";

        // Test "nedostatečně" (průměr > 4.5)
        assert vyhodnoceni.prospech(new int[]{5, 5, 5}).equals("nedostatečně") : "Průměr 5.0 by měl být 'nedostatečně'";

        System.out.println("Testy prospěchu prošly.");
    }

    /**
     * Test výjimky při prázdném poli nebo null.
     */
    private static void testPrumerException() {
        VyhodnoceniProspechu vyhodnoceni = new VyhodnoceniProspechu();

        try {
            vyhodnoceni.prospech(null);
            assert false : "Měla by být vyhozena výjimka pro null";
        } catch (IllegalArgumentException e) {
            // očekávaná výjimka
        }

        try {
            vyhodnoceni.prospech(new int[]{});
            assert false : "Měla by být vyhozena výjimka pro prázdné pole";
        } catch (IllegalArgumentException e) {
            // očekávaná výjimka
        }

        System.out.println("Testy výjimek prošly.");
    }
}