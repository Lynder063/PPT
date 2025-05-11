/**
 * Hlavní třída aplikace pro demonstraci použití třídy Nadrz
 *
 * @author Student
 * @version 2.0
 */
public class Main {

    /**
     * Hlavní metoda aplikace
     *
     * @param args Argumenty příkazové řádky (nejsou využity)
     */
    public static void main(String[] args) {
        System.out.println("Demonstrace použití třídy Nadrz (verze 2.0)");
        System.out.println("-----------------------------------------");

        // Vytvoření nádrže
        Nadrz nadrz = new Nadrz(100.0);
        System.out.println("Vytvořena nádrž s kapacitou: " + nadrz.get_kapacita());
        System.out.println("Počáteční stav: " + nadrz.get_stav());

        try {
            // Přidání kapaliny
            System.out.println("\nPřidávám 50 jednotek...");
            nadrz.add(50.0);
            System.out.println("Nový stav: " + nadrz.get_stav());

            // Pokus o přidání příliš mnoha jednotek
            System.out.println("\nPokus o přidání 60 jednotek (překročí kapacitu)...");
            try {
                nadrz.add(60.0);
            } catch (PlnaNadrzException e) {
                System.out.println("Zachycena výjimka: " + e.getMessage());
            }

            // Odebrání kapaliny
            System.out.println("\nOdebírám 30 jednotek...");
            nadrz.remove(30.0);
            System.out.println("Nový stav: " + nadrz.get_stav());

            // Pokus o odebrání příliš mnoha jednotek
            System.out.println("\nPokus o odebrání 30 jednotek (to je více než zbývá)...");
            try {
                nadrz.remove(30.0);
            } catch (PrazdnaNadrzException e) {
                System.out.println("Zachycena výjimka: " + e.getMessage());
            }

            // Demonstrace zkrácené syntaxe pro zachycení výjimek
            System.out.println("\nDalší operace s využitím try-catch:");

            // Přidání více než je kapacita
            System.out.println("Pokus o přidání příliš mnoha jednotek...");
            try {
                nadrz.add(100.0);
            } catch (PlnaNadrzException e) {
                System.out.println("Výjimka: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }

            // Vyprázdnění nádrže
            System.out.println("\nVyprazdňuji nádrž...");
            nadrz.remove(nadrz.get_stav());
            System.out.println("Stav nádrže: " + nadrz.get_stav());

            // Odebrání z prázdné nádrže
            System.out.println("Pokus o odebrání z prázdné nádrže...");
            try {
                nadrz.remove(10.0);
            } catch (PrazdnaNadrzException e) {
                System.out.println("Výjimka: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Nastala neočekávaná chyba: " + e.getMessage());
            e.printStackTrace();
        }
    }
}