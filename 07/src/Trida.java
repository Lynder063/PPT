import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trida {
    private String zkratka;
    private List<Student> studenti;

    public Trida(String zkratka) {
        this.zkratka = zkratka;
        this.studenti = new ArrayList<>();
    }

    public String getZkratka() {
        return zkratka;
    }

    public void pridejStudenta(Student student) {
        studenti.add(student);
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public Map<String, Double> vypocitejPrumerPredmetu() {
        Map<String, Double> prumeryPredmetu = new HashMap<>();
        Map<String, Integer> poctyZnamek = new HashMap<>();

        for (Student student : studenti) {
            for (Map.Entry<String, Integer> entry : student.getZnamky().entrySet()) {
                String predmet = entry.getKey();
                int znamka = entry.getValue();

                prumeryPredmetu.putIfAbsent(predmet, 0.0);
                poctyZnamek.putIfAbsent(predmet, 0);

                prumeryPredmetu.put(predmet, prumeryPredmetu.get(predmet) + znamka);
                poctyZnamek.put(predmet, poctyZnamek.get(predmet) + 1);
            }
        }

        for (String predmet : prumeryPredmetu.keySet()) {
            prumeryPredmetu.put(predmet, prumeryPredmetu.get(predmet) / poctyZnamek.get(predmet));
        }

        return prumeryPredmetu;
    }

    public double vypocitejCelkovyPrumer() {
        if (studenti.isEmpty()) {
            return 0;
        }

        double soucet = 0;
        for (Student student : studenti) {
            soucet += student.vypocitejPrumer();
        }

        return soucet / studenti.size();
    }
}