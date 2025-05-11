public class CastkyDokladu {
    private final double cenaBezDph;
    private final double cenaSdph;
    private final Sazba sazba;

    public CastkyDokladu(double cenaBezDph, Sazba sazba) {
        this.cenaBezDph = cenaBezDph;
        this.sazba = sazba;
        this.cenaSdph = cenaBezDph * (1 + sazba.getHodnota() / 100);
    }

    public double getCenaBezDph() {
        return cenaBezDph;
    }

    public double getCenaSdph() {
        return cenaSdph;
    }

    public Sazba getSazba() {
        return sazba;
    }

    public double getDph() {
        return cenaSdph - cenaBezDph;
    }

    @Override
    public String toString() {
        return "Cena bez DPH: " + cenaBezDph + " Kč\n" +
                "Sazba DPH: " + sazba + "\n" +
                "DPH: " + getDph() + " Kč\n" +
                "Cena s DPH: " + cenaSdph + " Kč";
    }
}