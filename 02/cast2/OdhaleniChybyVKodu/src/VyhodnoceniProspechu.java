/**
 * Třída pro vyhodnocení prospěchu studenta na základě známek.
 */
public class VyhodnoceniProspechu {

    private String[] slovniHodnocení = new String[] {"výborně", "chvalitebně", "dobře", "dostatečně", "nedostatečně"};

    /**
     * Vyhodnotí prospěch na základě pole známek.
     * @param znamky pole číselných známek (1-5)
     * @return slovní hodnocení prospěchu
     */
    public String prospech(int znamky[])
    {
        double prumer_znamek = prumer(znamky);
        if (prumer_znamek <= 1.5)
            return slovniHodnocení[0];
        else if (prumer_znamek <= 2.5)
            return slovniHodnocení[1];
        else if (prumer_znamek <= 3.5)
            return slovniHodnocení[2];
        else if (prumer_znamek <= 4.5)
            return slovniHodnocení[3];
        else
            return slovniHodnocení[4];
    }

    /**
     * Vypočítá aritmetický průměr známek.
     * @param znamky pole číselných známek
     * @return průměr známek
     */
    private double prumer(int znamky[])
    {
        if (znamky == null || znamky.length == 0) {
            throw new IllegalArgumentException("Pole známek nesmí být prázdné nebo null");
        }

        double suma = 0;
        for (int i = 0; i < znamky.length; i++)
            suma += znamky[i];
        return suma / znamky.length;
    }
}