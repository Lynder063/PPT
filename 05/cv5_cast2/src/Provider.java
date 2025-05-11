/**
 * Provider.java - Třída zajišťující zpracování dat
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Provider {
    private NacteniDat_DataKvadratickeRovnice nacteniDat;
    private VystupData_DataKvadratickeRovnice vystupData;

    /**
     * Konstruktor
     * @param nacteniDat objekt pro načítání dat
     * @param vystupData objekt pro výstup dat
     */
    public Provider(NacteniDat_DataKvadratickeRovnice nacteniDat, VystupData_DataKvadratickeRovnice vystupData) {
        this.nacteniDat = nacteniDat;
        this.vystupData = vystupData;
    }

    /**
     * Metoda pro zpracování dat
     * @throws Exception pokud dojde k chybě
     */
    public void execute() throws Exception {
        List<String> inputLines = null;
        SpoctiYKvR calculator = new SpoctiYKvR();

        // Pokus o načtení dat, s možností zadat nový soubor při chybě
        boolean dataLoaded = false;
        while (!dataLoaded) {
            try {
                inputLines = nacteniDat.load();
                dataLoaded = true;
            } catch (Exception e) {
                if (e.getMessage().contains("neexistuje")) {
                    System.out.println("Chyba: " + e.getMessage());
                    System.out.print("Zadejte nový název souboru: ");
                    Scanner scanner = new Scanner(System.in);
                    String newFilename = scanner.nextLine();
                    nacteniDat.setFilename(newFilename);
                } else {
                    // Ostatní chyby pouze oznámíme a přerušíme
                    System.out.println("Chyba: " + e.getMessage());
                    throw e;
                }
            }
        }

        List<String> outputLines = new ArrayList<>();

        // Zpracování každého řádku
        for (String line : inputLines) {
            String[] parts = line.split(";");

            // Parsování koeficientů a, b, c
            double a = Double.parseDouble(parts[0].replace(',', '.'));
            double b = Double.parseDouble(parts[1].replace(',', '.'));
            double c = Double.parseDouble(parts[2].replace(',', '.'));

            KvR rovnice = new KvR(a, b, c);

            // Sestavení výstupního řádku
            StringBuilder outputLine = new StringBuilder();
            outputLine.append(a).append(";").append(b).append(";").append(c);

            // Výpočet pro každé x a přidání do výstupu
            for (int i = 3; i < parts.length; i++) {
                double x = Double.parseDouble(parts[i].replace(',', '.'));
                double y = calculator.calc(rovnice, x);
                outputLine.append(";").append(x).append(":").append(y);
            }

            outputLines.add(outputLine.toString());
        }

        // Zápis výsledků
        try {
            vystupData.write(outputLines);
        } catch (Exception e) {
            System.out.println("Chyba při zápisu výstupu: " + e.getMessage());
            throw e;
        }

        System.out.println("Výpočty byly úspěšně provedeny a uloženy do souboru: " + vystupData.getFilename());
    }
}
