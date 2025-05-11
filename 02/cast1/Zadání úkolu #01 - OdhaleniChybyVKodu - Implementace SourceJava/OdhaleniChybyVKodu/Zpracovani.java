public class Zpracovani {

    public static boolean interval(int odkud, int kam, int value)
    {
        return (odkud <= value) && (value < kam);
        //return Integer.compare(odkud, value) == -1 && Integer.compare(value, kam) == -1
    }

    public double[] vzorkySestupně(double kam, double odkud, double krok)
    {
        final int N = (int)((kam - odkud) / krok);
        double values[] = new double[N];
        double actual = kam;
        int n = 0;
        while (Double.compare(odkud, actual) == -1) {
            values[n++] = actual;
            actual -= krok;
        }
        return values;
    }
}
