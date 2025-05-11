/**
 * Třída reprezentující nádrž s definovanou kapacitou
 * a možností přidávání a odebírání obsahu.
 * Verze 2.0 - s podporou výjimek pro neprovedené operace.
 *
 * @author Student
 * @version 2.0
 */
public class Nadrz {

    // Budoucí možné rozšíření
    //enum NAPLN { NATURAL95, NATURAL98, NAFTA}

    /** Kapacita nádrže */
    private double kapacita;

    /** Aktuální stav nádrže */
    private double stav;

    /**
     * Vytvoří novou nádrž s definovanou kapacitou
     *
     * @param kapacita Kapacita nádrže (musí být větší než 0)
     */
    public Nadrz(double kapacita) {
        set_kapacita(kapacita);
        stav = 0.0;
    }

    /**
     * Nastaví kapacitu nádrže (pouze pokud je větší než 0)
     *
     * @param kapacita Kapacita nádrže
     */
    private void set_kapacita(double kapacita) {
        if (kapacita > 0.0)
            this.kapacita = kapacita;
    }

    /**
     * Vrátí aktuální kapacitu nádrže
     *
     * @return Kapacita nádrže
     */
    public double get_kapacita() {
        return kapacita;
    }

    /**
     * Vrátí aktuální stav nádrže
     *
     * @return Aktuální stav nádrže
     */
    public double get_stav() {
        return stav;
    }

    /**
     * Přidá definované množství do nádrže
     *
     * @param kolik Množství k přidání (musí být nezáporné)
     * @return true pokud byla operace úspěšná
     * @throws PlnaNadrzException pokud by přidání vedlo k překročení kapacity
     */
    public boolean add(double kolik) throws PlnaNadrzException {
        if (kolik < 0.0)
            return false;

        final double stav_new = stav + kolik;
        if (stav_new > kapacita)
            throw new PlnaNadrzException("Nelze přidat " + kolik + ", kapacita by byla překročena. Aktuální stav: " + stav + ", kapacita: " + kapacita);

        stav = stav_new;
        return true;
    }

    /**
     * Odebere definované množství z nádrže
     *
     * @param kolik Množství k odebrání (musí být nezáporné)
     * @return true pokud byla operace úspěšná
     * @throws PrazdnaNadrzException pokud není v nádrži dostatek obsahu
     */
    public boolean remove(double kolik) throws PrazdnaNadrzException {
        if (kolik < 0.0)
            return false;

        final double stav_new = stav - kolik;
        if (stav_new < 0.0)
            throw new PrazdnaNadrzException("Nelze odebrat " + kolik + ", v nádrži je pouze " + stav);

        stav = stav_new;
        return true;
    }
}