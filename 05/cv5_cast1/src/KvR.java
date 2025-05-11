/**
 * Třída reprezentující kvadratickou rovnici ve tvaru y = ax^2 + bx + c
 */
public class KvR {
    // Koeficienty kvadratické rovnice
    private double a;
    private double b;
    private double c;

    /**
     * Konstruktor pro vytvoření kvadratické rovnice
     * @param a koeficient u x^2
     * @param b koeficient u x
     * @param c konstantní člen
     */
    public KvR(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Getter pro koeficient a
     * @return koeficient a
     */
    public double getA() {
        return a;
    }

    /**
     * Getter pro koeficient b
     * @return koeficient b
     */
    public double getB() {
        return b;
    }

    /**
     * Getter pro koeficient c
     * @return koeficient c
     */
    public double getC() {
        return c;
    }

    /**
     * Setter pro koeficient a
     * @param a nová hodnota koeficientu a
     */
    protected void setA(double a) {
        this.a = a;
    }

    /**
     * Setter pro koeficient b
     * @param b nová hodnota koeficientu b
     */
    protected void setB(double b) {
        this.b = b;
    }

    /**
     * Setter pro koeficient c
     * @param c nová hodnota koeficientu c
     */
    protected void setC(double c) {
        this.c = c;
    }
}