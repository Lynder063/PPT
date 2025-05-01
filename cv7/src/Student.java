import java.util.HashMap;
import java.util.Map;

public class Student {
    private String jmeno;
    private String prijmeni;
    private int cislo;
    private Map<String, Integer> znamky;

    public Student(String jmeno, String prijmeni, int cislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.cislo = cislo;
        this.znamky = new HashMap<>();
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getCislo() {
        return cislo;
    }

    public void pridejZnamku(String predmet, int znamka) {
        znamky.put(predmet, znamka);
    }

    public Map<String, Integer> getZnamky() {
        return znamky;
    }

    public double vypocitejPrumer() {
        if (znamky.isEmpty()) {
            return 0;
        }

        int soucet = 0;
        for (int znamka : znamky.values()) {
            soucet += znamka;
        }

        return (double) soucet / znamky.size();
    }

    @Override
    public String toString() {
        return jmeno + ";" + prijmeni;
    }
}