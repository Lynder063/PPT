import java.util.List;

/**
 * VystupData_DataKvadratickeRovnice.java - Abstraktní třída pro výstup dat
 */
public abstract class VystupData_DataKvadratickeRovnice {
    protected String filename;

    /**
     * Konstruktor
     * @param filename jméno souboru
     */
    public VystupData_DataKvadratickeRovnice(String filename) {
        this.filename = filename;
    }

    /**
     * Abstraktní metoda pro zápis dat
     * @param data data k zápisu
     * @throws Exception pokud dojde k chybě při zápisu
     */
    public abstract void write(List<String> data) throws Exception;

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