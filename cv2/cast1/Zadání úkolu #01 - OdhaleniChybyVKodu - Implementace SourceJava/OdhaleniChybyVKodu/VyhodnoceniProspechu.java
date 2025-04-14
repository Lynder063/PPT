public class VyhodnoceniProspechu {

    private String[] slovniHodnocení = new String[] {"výborně", "chvalitebně", "dobře", "dostatečně", "nedostatečně"};

    public String prospech(int znamky[])
    {
        double prumer_znamek = prumer(znamky);
        int prumer_comp = Double.compare(prumer_znamek, 1.5);
        if (prumer_comp <= 0)
            return slovniHodnocení[0];
        else {
            prumer_comp = Double.compare(prumer_znamek, 2.5);
            if (prumer_comp <= 0)
                return slovniHodnocení[1];
            else {
                prumer_comp = Double.compare(prumer_znamek, 3.5);
                if (prumer_comp < 0)
                    return slovniHodnocení[2];
                else {
                    prumer_comp = Double.compare(prumer_znamek, 4.5);
                    if (prumer_comp <= 0)
                        return slovniHodnocení[3];
                    else
                        return slovniHodnocení[4];
                }
            }

        }
    }

    private double prumer(int znamky[])
    {
        int suma = 0;
        for (int i = 0; i < znamky.length; i++)
            suma += znamky[i];
        return suma / znamky.length;
    }
}
