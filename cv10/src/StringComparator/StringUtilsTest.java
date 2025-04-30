package StringComparator;

public class StringUtilsTest {
    public static void main(String[] args) {
        test("ABCDEF", "ABCD", 1);
        test("ABCD", "ABCDEF", -1);
        test("ABCDEF", "ABCDEF", 0);
        test("ABCD", "ABCE", -1);
        test("ABCE", "ABCD", 1);
        test("ABCD", "ABCD", 0);
    }

    private static void test(String s1, String s2, int expected) {
        int result = StringUtils.customCompare(s1, s2);
        String status = (result == expected) ? "OK" : "FAIL";
        System.out.printf("Porovnání \"%s\" vs \"%s\" => Výsledek: %d, Očekáváno: %d [%s]%n",
                s1, s2, result, expected, status);
    }
}

