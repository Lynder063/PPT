/**
 * VystupDataCSV_DataKvadratickeRovnice.java - Konkrétní implementace výstupu dat do CSV
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class VystupDataCSV_DataKvadratickeRovnice extends VystupData_DataKvadratickeRovnice {

    /**
     * Konstruktor
     * @param filename jméno souboru
     */
    public VystupDataCSV_DataKvadratickeRovnice(String filename) {
        super(filename);
    }

    /**
     * Implementace metody pro zápis dat do CSV souboru
     * @param data data k zápisu
     * @throws Exception pokud dojde k chybě při zápisu
     */
    @Override
    public void write(List<String> data) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            throw new Exception("Chyba při zápisu do souboru: " + e.getMessage());
        }
    }
}
