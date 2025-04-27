/**
 * Rozšířená třída KvR, která navíc obsahuje x a y souřadnici bodu na křivce
 */
public class KvREx extends KvR {
    // Souřadnice bodu na křivce
    private double x;
    private double y;

    /**
     * Konstruktor pro vytvoření rozšířené kvadratické rovnice s bodem
     * @param a koeficient u x^2
     * @param b koeficient u x
     * @param c konstantní člen
     * @param x hodnota x souřadnice bodu
     */
    public KvREx(double a, double b, double c, double x) {
        super(a, b, c);
        this.x = x;
        // y se vypočítá v konstruktoru
        this.y = calcY();
    }

    /**
     * Getter pro x souřadnici
     * @return x souřadnice
     */
    public double getX() {
        return x;
    }

    /**
     * Getter pro y souřadnici
     * @return y souřadnice
     */
    public double getY() {
        return y;
    }

    /**
     * Vypočítá hodnotu y pro aktuální hodnotu x
     * @return vypočítaná hodnota y
     */
    public double calcY() {
        return getA() * x * x + getB() * x + getC();
    }
}