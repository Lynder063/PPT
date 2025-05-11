import java.time.LocalDate;

/**
 * Builder pro vytváření faktur s různými metodami výpočtu DPH
 */
public class FakturaBuilder {
    private String cisloDokladu;
    private LocalDate datumVystaveni;
    private LocalDate datumSplatnosti;
    private Prijemce prijemce;
    private double castka;
    private String zkratkaSazby;
    private double hodnotaSazby;
    private TypVypoctuDane typVypoctuDane;
    private double fixniDph;

    public FakturaBuilder() {
        // Výchozí hodnoty
        this.datumVystaveni = LocalDate.now();
        this.datumSplatnosti = LocalDate.now().plusDays(14);
        this.typVypoctuDane = TypVypoctuDane.ZDOLA;
        this.zkratkaSazby = "DPH 21%";
        this.hodnotaSazby = 21.0;
    }

    public FakturaBuilder cisloDokladu(String cisloDokladu) {
        this.cisloDokladu = cisloDokladu;
        return this;
    }

    public FakturaBuilder datumVystaveni(LocalDate datumVystaveni) {
        this.datumVystaveni = datumVystaveni;
        return this;
    }

    public FakturaBuilder datumSplatnosti(LocalDate datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
        return this;
    }

    public FakturaBuilder prijemce(Prijemce prijemce) {
        this.prijemce = prijemce;
        return this;
    }

    public FakturaBuilder novyPrijemce(String jmeno, String prijmeni, String ulice, String mesto,
                                       String psc, String telefon, String email) {
        this.prijemce = new Prijemce(jmeno, prijmeni, ulice, mesto, psc, telefon, email);
        return this;
    }

    public FakturaBuilder castka(double castka) {
        this.castka = castka;
        return this;
    }

    public FakturaBuilder sazba(String zkratka, double hodnota) {
        this.zkratkaSazby = zkratka;
        this.hodnotaSazby = hodnota;
        return this;
    }

    public FakturaBuilder typVypoctuDane(TypVypoctuDane typVypoctuDane) {
        this.typVypoctuDane = typVypoctuDane;
        return this;
    }

    public FakturaBuilder fixniDph(double fixniDph) {
        this.fixniDph = fixniDph;
        return this;
    }

    /**
     * Vytvoří fakturu s použitím zvolené strategie výpočtu DPH
     * @return Faktura
     */
    public Faktura build() {
        if (cisloDokladu == null || cisloDokladu.isEmpty()) {
            throw new IllegalStateException("Číslo dokladu musí být zadáno");
        }

        if (prijemce == null) {
            throw new IllegalStateException("Příjemce musí být zadán");
        }

        if (castka < 0) {
            throw new IllegalArgumentException("Částka nemůže být záporná");
        }

        ZauctujFakturu zauctovani;

        switch (typVypoctuDane) {
            case ZDOLA:
                zauctovani = new ZauctujFakturuZdola(cisloDokladu, datumVystaveni, datumSplatnosti,
                        prijemce, castka, zkratkaSazby, hodnotaSazby);
                break;
            case SHORA:
                zauctovani = new ZauctujFakturuShora(cisloDokladu, datumVystaveni, datumSplatnosti,
                        prijemce, castka, zkratkaSazby, hodnotaSazby);
                break;
            case FIXNI:
                zauctovani = new ZauctujFakturuFixni(cisloDokladu, datumVystaveni, datumSplatnosti,
                        prijemce, castka, zkratkaSazby, hodnotaSazby, fixniDph);
                break;
            default:
                throw new IllegalStateException("Neznámý typ výpočtu daně");
        }

        return zauctovani.vytvorFakturu();
    }
}