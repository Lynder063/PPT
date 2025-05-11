public class CastkyDokladu {
    private final double cenaBezDph;
    private final double cenaSdph;
    private final double dph;
    private final Sazba sazba;

    public CastkyDokladu(double cenaBezDph, Sazba sazba) {
        this.cenaBezDph = cenaBezDph;
        this.sazba = sazba;
        this.dph = cenaBezDph * sazba.getHodnota() / 100;
        this.cenaSdph = cenaBezDph + dph;
    }

    // Nový konstruktor pro fixní DPH
    public CastkyDokladu(double cenaBezDph, double fixniDph, Sazba sazba) {
        this.cenaBezDph = cenaBezDph;
        this.sazba = sazba;
        this.dph = fixniDph;
        this.cenaSdph = cenaBezDph + dph;
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
        return dph;
    }

    @Override
    public String toString() {
        return "Cena bez DPH: " + cenaBezDph + " Kč\n" +
                "Sazba DPH: " + sazba + "\n" +
                "DPH: " + dph + " Kč\n" +
                "Cena s DPH: " + cenaSdph + " Kč";
    }
}