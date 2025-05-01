import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Zadejte cestu k souboru se seznamy studentů:");
            String vstupniSoubor = scanner.nextLine();

            System.out.println("\nZadejte formát souboru (FORMAT1/FORMAT2/FORMAT3):");
            String format = scanner.nextLine();

            System.out.println("\nZadejte cestu k souboru se známkami:");
            String souborZnamky = scanner.nextLine();

            System.out.println("\nZadejte adresář pro výstupní soubory se studenty:");
            String adresarVystupu = scanner.nextLine();

            System.out.println("\nZadejte cestu k výstupnímu souboru s prospěchem:");
            String souborProspech = scanner.nextLine();

            TridniSystem system = new TridniSystemBuilder()
                    .setVstupniSoubor(vstupniSoubor)
                    .setFormatVstupu(format)
                    .setSouborZnamky(souborZnamky)
                    .setAdresarVystupu(adresarVystupu)
                    .setSouborProspech(souborProspech)
                    .build();

            system.zapisSeznamyStudentu();
            system.zapisProspech();

            System.out.println();
            System.out.println("Export byl úspěšně dokončen.");

        } catch (IOException e) {
            System.err.println("Chyba při práci se soubory: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Chyba: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Chyba konfigurace: " + e.getMessage());
        }
    }
}