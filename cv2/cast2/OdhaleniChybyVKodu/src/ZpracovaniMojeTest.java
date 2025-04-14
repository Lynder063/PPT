/**
 * Testovací třída pro komparační funkce ZpracovaniMoje.
 */
public class ZpracovaniMojeTest {
    public static void main(String[] args) {
        testCompInt();
        testCompString();
        System.out.println("Všechny testy ZpracovaniMoje proběhly úspěšně!");
    }

    /**
     * Test pro porovnání celých čísel.
     */
    private static void testCompInt() {
        // Test pro porovnání čísel
        assert ZpracovaniMoje.comp(5, 10) == -1 : "5 by mělo být menší než 10";
        assert ZpracovaniMoje.comp(10, 5) == 1 : "10 by mělo být větší než 5";
        assert ZpracovaniMoje.comp(7, 7) == 0 : "7 by mělo být rovno 7";
        assert ZpracovaniMoje.comp(-3, 3) == -1 : "-3 by mělo být menší než 3";
        assert ZpracovaniMoje.comp(0, -5) == 1 : "0 by mělo být větší než -5";

        System.out.println("Testy pro porovnání čísel prošly.");
    }

    /**
     * Test pro porovnání řetězců.
     */
    private static void testCompString() {
        // Test pro porovnání řetězců
        assert ZpracovaniMoje.comp("abc", "def") < 0 : "\"abc\" by mělo být menší než \"def\"";
        assert ZpracovaniMoje.comp("def", "abc") > 0 : "\"def\" by mělo být větší než \"abc\"";
        assert ZpracovaniMoje.comp("abc", "abc") == 0 : "\"abc\" by mělo být rovno \"abc\"";
        assert ZpracovaniMoje.comp("", "abc") < 0 : "Prázdný řetězec by měl být menší než \"abc\"";
        assert ZpracovaniMoje.comp(null, "abc") < 0 : "null by měl být menší než \"abc\"";
        assert ZpracovaniMoje.comp("abc", null) > 0 : "\"abc\" by měl být větší než null";
        assert ZpracovaniMoje.comp(null, null) == 0 : "null by měl být roven null";

        System.out.println("Testy pro porovnání řetězců prošly.");
    }
}