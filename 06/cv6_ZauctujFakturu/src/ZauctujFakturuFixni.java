import java.time.LocalDate;

/**
 * Výpočet s fixní hodnotou DPH
 */
public class ZauctujFakturuFixni extends ZauctujFakturu {
    private final double fixniDph;

    public ZauctujFakturuFixni(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                               Prijemce prijemce, double castka, String zkratkaSazby, double hodnotaSazby,
                               double fixniDph) {
        super(cisloDokladu, datumVystaveni, datumSplatnosti, prijemce, castka, zkratkaSazby, hodnotaSazby);
        this.fixniDph = fixniDph;
    }

    @Override
    protected CastkyDokladu vypoctiCastky(Sazba sazba) {
        // Upravená implementace CastkyDokladu pro fixní DPH
        return new CastkyDokladu(castka, fixniDph, sazba);
    }
}