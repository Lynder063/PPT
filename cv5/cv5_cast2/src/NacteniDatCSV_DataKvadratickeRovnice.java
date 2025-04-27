/**
 * NacteniDatCSV_DataKvadratickeRovnice.java - Konkrétní implementace načítání dat z CSV
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class NacteniDatCSV_DataKvadratickeRovnice extends NacteniDat_DataKvadratickeRovnice {

    /**
     * Konstruktor
     * @param filename jméno souboru
     */
    public NacteniDatCSV_DataKvadratickeRovnice(String filename) {
        super(filename);
    }

    /**
     * Implementace metody pro načtení dat z CSV souboru
     * @return seznam řádků dat
     * @throws Exception pokud dojde k chybě při načítání
     */
    @Override
    public List<String> load() throws Exception {
        List<String> lines = new ArrayList<>();

        // Kontrola existence souboru
        File file = new File(filename);
        if (!file.exists()) {
            throw new Exception("Soubor " + filename + " neexistuje.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Kontrola formátu dat
                String[] parts = line.split(";");
                if (parts.length < 4) {
                    throw new Exception("Špatný formát dat: " + line);
                }

                // Kontrola, že první tři hodnoty jsou číselné
                try {
                    double a = Double.parseDouble(parts[0].replace(',', '.'));
                    double b = Double.parseDouble(parts[1].replace(',', '.'));
                    double c = Double.parseDouble(parts[2].replace(',', '.'));
                } catch (NumberFormatException e) {
                    throw new Exception("Špatný formát číselných hodnot: " + line);
                }

                lines.add(line);
            }
        }

        return lines;
    }
}