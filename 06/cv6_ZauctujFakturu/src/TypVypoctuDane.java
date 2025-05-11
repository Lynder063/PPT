import java.time.LocalDate;

public enum TypVypoctuDane {
    ZDOLA,    // Výpočet DPH ze základu (běžný způsob)
    SHORA,    // Výpočet DPH z celkové částky (používá se při rozpočítání)
    FIXNI     // Pevně stanovená DPH
}

// Soubor: ZauctujFakturu.java
import java.time.LocalDate;

/**
 * Abstraktní třída pro účtování faktur s různými způsoby výpočtu DPH
 */
public abstract class ZauctujFakturu {
    protected final String cisloDokladu;
    protected final LocalDate datumVystaveni;
    protected final LocalDate datumSplatnosti;
    protected final Prijemce prijemce;
    protected final double castka;
    protected final String zkratkaSazby;
    protected final double hodnotaSazby;

    public ZauctujFakturu(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                          Prijemce prijemce, double castka, String zkratkaSazby, double hodnotaSazby) {
        this.cisloDokladu = cisloDokladu;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.prijemce = prijemce;
        this.castka = castka;
        this.zkratkaSazby = zkratkaSazby;
        this.hodnotaSazby = hodnotaSazby;
    }

    /**
     * Vytvoří fakturu s vypočtenými částkami
     * @return Faktura s vypočtenými částkami
     */
    public Faktura vytvorFakturu() {
        Sazba sazba = new Sazba(zkratkaSazby, hodnotaSazby);
        CastkyDokladu castkyDokladu = vypoctiCastky(sazba);
        return new Faktura(cisloDokladu, datumVystaveni, datumSplatnosti, prijemce, castkyDokladu);
    }

    /**
     * Abstraktní metoda pro výpočet částek podle konkrétního způsobu výpočtu DPH
     * @param sazba Sazba DPH
     * @return Vypočtené částky dokladu
     */
    protected abstract CastkyDokladu vypoctiCastky(Sazba sazba);
}