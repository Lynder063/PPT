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

    public String getCisloDokladu() {
        return cisloDokladu;
    }

    public LocalDate getDatumVystaveni() {
        return datumVystaveni;
    }

    public LocalDate getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public Prijemce getPrijemce() {
        return prijemce;
    }

    public CastkyDokladu getCastky() {
        return castky;
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