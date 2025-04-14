public class ZpracovaniMy {
    /**
     * Porovná dvě celá čísla.
     * @param a první číslo
     * @param b druhé číslo
     * @return -1 pokud a < b, 0 pokud a == b, 1 pokud a > b
     */
    public static int comp(int a, int b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Porovná dva řetězce lexikograficky.
     * @param a první řetězec
     * @param b druhý řetězec
     * @return záporné číslo pokud a < b, 0 pokud a == b, kladné číslo pokud a > b
     */
    public static int comp(String a, String b) {
        // Kontrola null hodnot
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        // Použití vestavěné metody compareTo pro porovnání řetězců
        return a.compareTo(b);
    }
}