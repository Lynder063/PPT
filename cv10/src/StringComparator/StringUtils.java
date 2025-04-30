package StringComparator;

public class StringUtils {

    /**
     * Porovná dva řetězce lexikograficky bez použití vestavěných metod jako equals() nebo compareTo().
     *
     * @param s1 První řetězec
     * @param s2 Druhý řetězec
     * @return 0 pokud jsou řetězce stejné, -1 pokud je s1 < s2, 1 pokud je s1 > s2
     */
    public static int customCompare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return c1 < c2 ? -1 : 1;
            }
        }

        if (len1 == len2) {
            return 0;
        } else {
            return len1 < len2 ? -1 : 1;
        }
    }
}
