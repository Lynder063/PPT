/**
 * Třída poskytující různé metody pro zpracování numerických dat.
 */
public class Zpracovani {

    /**
     * Ověří, zda je hodnota v intervalu (odkud, kam), tzn. krajní meze nejsou součástí intervalu.
     * @param odkud dolní mez intervalu (není součástí intervalu)
     * @param kam horní mez intervalu (není součástí intervalu)
     * @param value hodnota k ověření
     * @return true pokud hodnota leží v intervalu (odkud, kam), jinak false
     */
    public static boolean interval(int odkud, int kam, int value)
    {
        return (odkud < value) && (value < kam);
    }

    /**
     * Generuje pole hodnot od 'kam' k 'odkud' sestupně s daným krokem.
     * @param kam počáteční hodnota (včetně)
     * @param odkud koncová hodnota (není zahrnuta)
     * @param krok velikost kroku mezi hodnotami
     * @return pole hodnot seřazených sestupně
     */
    public double[] vzorkySestupně(double kam, double odkud, double krok)
    {
        if (krok <= 0) {
            throw new IllegalArgumentException("Krok musí být kladný");
        }
        if (kam <= odkud) {
            throw new IllegalArgumentException("Hodnota 'kam' musí být větší než 'odkud'");
        }

        final int N = (int)Math.ceil((kam - odkud) / krok);
        double[] values = new double[N];
        double actual = kam;
        int n = 0;
        while (actual > odkud) {
            values[n++] = actual;
            actual -= krok;
        }
        return values;
    }
}