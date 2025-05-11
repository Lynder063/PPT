import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Faktura {
    private final String cisloDokladu;
    private final LocalDate datumVystaveni;
    private final LocalDate datumSplatnosti;
    private final Prijemce prijemce;
    private final CastkyDokladu castky;

    public Faktura(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                   Prijemce prijemce, CastkyDokladu castky) {
        this.cisloDokladu = cisloDokladu;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.prijemce = prijemce;
        this.castky = castky;
    }

    // Základní gettery
    public String getCisloDokladu() {
        return cisloDokladu;
    }

    public LocalDate getDatumVystaveni() {
        return datumVystaveni;
    }

    public LocalDate getDatumSplatnosti() {
        return datumSplatnosti;
    }

    // Poskytnutí celého objektu příjemce
    public Prijemce getPrijemce() {
        return prijemce;
    }

    // Poskytnutí celého objektu částek
    public CastkyDokladu getCastkyDokladu() {
        return castky;
    }

    // Zprostředkování dílčích hodnot příjemce
    public String getJmenoPrijemce() {
        return prijemce.getJmeno();
    }

    public String getPrijmeniPrijemce() {
        return prijemce.getPrijmeni();
    }

    public String getUlicePrijemce() {
        return prijemce.getUlice();
    }

    public String getMestoPrijemce() {
        return prijemce.getMesto();
    }

    public String getPscPrijemce() {
        return prijemce.getPsc();
    }

    public String getTelefonPrijemce() {
        return prijemce.getTelefon();
    }

    public String getEmailPrijemce() {
        return prijemce.getEmail();
    }

    // Zprostředkování dílčích hodnot částek
    public double getCenaBezDph() {
        return castky.getCenaBezDph();
    }

    public double getCenaSdph() {
        return castky.getCenaSdph();
    }

    public double getDph() {
        return castky.getDph();
    }

    public Sazba getSazba() {
        return castky.getSazba();
    }

    public String getZkratkaSazby() {
        return castky.getSazba().getZkratka();
    }

    public double getHodnotaSazby() {
        return castky.getSazba().getHodnota();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return "FAKTURA č. " + cisloDokladu + "\n" +
                "------------------------------\n" +
                "Datum vystavení: " + datumVystaveni.format(formatter) + "\n" +
                "Datum splatnosti: " + datumSplatnosti.format(formatter) + "\n\n" +
                "Příjemce:\n" + prijemce + "\n\n" +
                "Částky dokladu:\n" + castky;
    }
}