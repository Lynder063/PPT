/**
 * Main.java - Hlavní třída s metodou main
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputFilename;

        // Načtení jména vstupního souboru z parametrů nebo od uživatele
        if (args.length > 0) {
            inputFilename = args[0];
        } else {
            System.out.print("Zadejte jméno vstupního souboru: ");
            Scanner scanner = new Scanner(System.in);
            inputFilename = scanner.nextLine();
        }

        // Vytvoření a spuštění provideru
        try {
            Provider provider = Builder.create1(inputFilename);
            provider.execute();
        } catch (Exception e) {
            System.out.println("Program selhal s chybou: " + e.getMessage());
        }
    }
}