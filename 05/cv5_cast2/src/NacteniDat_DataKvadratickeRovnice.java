/**
 * NacteniDat_DataKvadratickeRovnice.java - Abstraktní třída pro načítání dat
 */
import java.util.List;

public abstract class NacteniDat_DataKvadratickeRovnice {
    protected String filename;

    /**
     * Konstruktor
     * @param filename jméno souboru
     */
    public NacteniDat_DataKvadratickeRovnice(String filename) {
        this.filename = filename;
    }

    /**
     * Abstraktní metoda pro načtení dat
     * @return seznam řádků dat
     * @throws Exception pokud dojde k chybě při načítání
     */
    public abstract List<String> load() throws Exception;

    /**
     * Getter pro filename
     * @return jméno souboru
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Setter pro filename
     * @param filename nové jméno souboru
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}
