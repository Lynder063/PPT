/**
 * SpoctiYKvR.java - Třída pro výpočet hodnoty y kvadratické rovnice pro dané x
 */
public class SpoctiYKvR {

    /**
     * Vypočítá hodnotu y pro danou kvadratickou rovnici a hodnotu x
     * @param kvr kvadratická rovnice
     * @param x hodnota x
     * @return hodnota y = ax^2 + bx + c
     */
    public double calc(KvR kvr, double x) {
        return kvr.getA() * x * x + kvr.getB() * x + kvr.getC();
    }

    /**
     * Vypočítá pole hodnot y pro danou kvadratickou rovnici a pole hodnot x
     * @param kvr kvadratická rovnice
     * @param x pole hodnot x
     * @return pole vypočítaných hodnot y
     */
    public double[] calcY(KvR kvr, double[] x) {
        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = calc(kvr, x[i]);
        }
        return result;
    }
}