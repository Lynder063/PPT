import java.time.LocalDate;

/**
 * Výpočet DPH zdola (z ceny bez DPH)
 */
public class ZauctujFakturuZdola extends ZauctujFakturu {
    public ZauctujFakturuZdola(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                               Prijemce prijemce, double castka, String zkratkaSazby, double hodnotaSazby) {
        super(cisloDokladu, datumVystaveni, datumSplatnosti, prijemce, castka, zkratkaSazby, hodnotaSazby);
    }

    @Override
    protected CastkyDokladu vypoctiCastky(Sazba sazba) {
        // Castka je interpretována jako cena bez DPH
        return new CastkyDokladu(castka, sazba);
    }
}