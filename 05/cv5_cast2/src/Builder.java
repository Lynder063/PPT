/**
 * Builder.java - Třída pro vytváření instancí Provider
 */
public class Builder {

    /**
     * Vytvoří Provider s načítáním a výstupem dat z/do CSV souborů
     * @param inputFilename jméno vstupního souboru
     * @return instance Provider
     */
    public static Provider create1(String inputFilename) {
        String outputFilename = inputFilename.replace(".csv", "_output.csv");
        if (outputFilename.equals(inputFilename)) {
            outputFilename = inputFilename + "_output";
        }

        NacteniDat_DataKvadratickeRovnice nacteniDat = new NacteniDatCSV_DataKvadratickeRovnice(inputFilename);
        VystupData_DataKvadratickeRovnice vystupData = new VystupDataCSV_DataKvadratickeRovnice(outputFilename);

        return new Provider(nacteniDat, vystupData);
    }
}