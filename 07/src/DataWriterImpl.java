import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataWriterImpl implements DataWriter {

    @Override
    public void zapisSeznamyStudentu(List<Trida> tridy, String adresar) throws IOException {
        File dir = new File(adresar);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (Trida trida : tridy) {
            String soubor = adresar + File.separator + trida.getZkratka() + ".csv";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(soubor))) {
                bw.write(trida.getZkratka());
                bw.newLine();
                bw.write(String.valueOf(trida.getStudenti().size()));
                bw.newLine();

                for (Student student : trida.getStudenti()) {
                    bw.write(student.toString());
                    bw.newLine();
                }
            }
        }
    }

    @Override
    public void zapisProspech(List<Trida> tridy, String soubor) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(soubor))) {
            bw.write("PROSPĚCH STUDENTŮ A TŘÍD");
            bw.newLine();
            bw.newLine();

            for (Trida trida : tridy) {
                bw.write("Třída: " + trida.getZkratka());
                bw.newLine();
                bw.write("-----------------------------");
                bw.newLine();

                // Průměry předmětů
                Map<String, Double> prumeryPredmetu = trida.vypocitejPrumerPredmetu();
                bw.write("Průměry předmětů:");
                bw.newLine();

                for (Map.Entry<String, Double> entry : prumeryPredmetu.entrySet()) {
                    bw.write(entry.getKey() + ": " + String.format("%.2f", entry.getValue()));
                    bw.newLine();
                }

                bw.write("Celkový průměr třídy: " + String.format("%.2f", trida.vypocitejCelkovyPrumer()));
                bw.newLine();
                bw.newLine();

                // Průměry studentů
                bw.write("Průměry studentů:");
                bw.newLine();

                for (Student student : trida.getStudenti()) {
                    bw.write(student.getCislo() + ". " + student.getJmeno() + " " + student.getPrijmeni() +
                            ": " + String.format("%.2f", student.vypocitejPrumer()));
                    bw.newLine();
                }

                bw.newLine();
                bw.write("=============================");
                bw.newLine();
                bw.newLine();
            }
        }
    }
}