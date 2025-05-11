public class Sazba {
    private final String zkratka;
    private final double hodnota; // v procentech

    public Sazba(String zkratka, double hodnota) {
        this.zkratka = zkratka;
        this.hodnota = hodnota;
    }

    public String getZkratka() {
        return zkratka;
    }

    public double getHodnota() {
        return hodnota;
    }

    @Override
    public String toString() {
        return zkratka + " (" + hodnota + "%)";
    }
}