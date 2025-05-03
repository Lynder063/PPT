package dvojbran;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Třída pro výpočet zatíženého elektrického dvojbranu
 * Používá ABCD parametry pro popis dvojbranu
 */
public class ElektrickyDvojbran {

    private double A;
    private double B;
    private double C;
    private double D;


    private double vstupniNapeti;
    private double vystupniNapeti;
    private double vstupniProud;
    private double vystupniProud;


    private double zatez;


    private DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Konstruktor pro vytvoření dvojbranu s ABCD parametry
     */
    public ElektrickyDvojbran(double A, double B, double C, double D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    /**
     * Metoda pro výpočet výstupního napětí a proudu při zadaném vstupním napětí a zátěži
     * @param vstupniNapeti vstupní napětí U1
     * @param zatez hodnota zátěže Z2
     * @return pole s výstupními hodnotami [výstupní napětí, výstupní proud]
     */
    public double[] vypocitejVystupy(double vstupniNapeti, double zatez) {
        this.vstupniNapeti = vstupniNapeti;
        this.zatez = zatez;

        vystupniNapeti = vstupniNapeti / (A + (B / zatez));

        vystupniProud = vystupniNapeti / zatez;

        vstupniProud = C * vystupniNapeti + D * vystupniProud;

        zobrazMezivypocty();

        double zaokrouhleneVystupniNapeti = Math.round(vystupniNapeti * 100.0) / 100.0;
        double zaokrouhlenyVystupniProud = Math.round(vystupniProud * 100.0) / 100.0;


        return new double[] {zaokrouhleneVystupniNapeti, zaokrouhlenyVystupniProud};
    }

    /**
     * Metoda pro zobrazení mezivýpočtů
     */
    private void zobrazMezivypocty() {
        System.out.println("Mezivýpočty:");
        System.out.println("Parametry dvojbranu: A = " + df.format(A) + ", B = " + df.format(B) +
                ", C = " + df.format(C) + ", D = " + df.format(D));
        System.out.println("Zátěž Z2 = " + df.format(zatez) + " Ω");
        System.out.println("Vstupní hodnoty: U1 = " + df.format(vstupniNapeti) + " V");
        System.out.println("Jmenovatel pro U2: (A + (B / Z2)) = (" + df.format(A) + " + (" +
                df.format(B) + " / " + df.format(zatez) + ")) = " +
                df.format(A + (B / zatez)));
        System.out.println("Výpočet U2 = U1 / (A + (B / Z2)) = " + df.format(vstupniNapeti) + " / " +
                df.format(A + (B / zatez)) + " = " + df.format(vystupniNapeti) + " V");
        System.out.println("Výpočet I2 = U2 / Z2 = " + df.format(vystupniNapeti) + " / " +
                df.format(zatez) + " = " + df.format(vystupniProud) + " A");
        System.out.println("Výpočet I1 = C * U2 + D * I2 = " + df.format(C) + " * " +
                df.format(vystupniNapeti) + " + " + df.format(D) + " * " +
                df.format(vystupniProud) + " = " + df.format(vstupniProud) + " A");
    }

    /**
     * Metoda pro zobrazení zaokrouhlených výsledků
     */
    public void zobrazVysledky() {
        System.out.println("\nVýsledky (zaokrouhlené na 2 desetinná místa):");
        System.out.println("Výstupní napětí U2 = " + df.format(vystupniNapeti) + " V");
        System.out.println("Výstupní proud I2 = " + df.format(vystupniProud) + " A");
    }

    /**
     * Převede jednoduchý napěťový dělič na dvojbran.
     * Pro R1 = vnitřní odpor zdroje, R2 = odpor zátěže:
     * A = 1, B = R1, C = 0, D = 1
     * @param r1 vnitřní odpor zdroje
     * @return instance dvojbranu odpovídající napěťovému děliči
     */
    public static ElektrickyDvojbran vytvorNapetovyDelic(double r1) {
        return new ElektrickyDvojbran(1.0, r1, 0.0, 1.0);
    }

    /**
     * Hlavní metoda pro spuštění programu
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Výpočet zatíženého elektrického dvojbranu");
        System.out.println("----------------------------------------");

        System.out.println("Vyberte režim: ");
        System.out.println("1 - Obecný dvojbran (zadat ABCD parametry)");
        System.out.println("2 - Napěťový dělič (zadat pouze vnitřní odpor)");
        System.out.print("Vaše volba: ");
        int volba = sc.nextInt();

        ElektrickyDvojbran dvojbran;
        if (volba == 1) {
            System.out.print("Zadejte parametr A: ");
            double A = sc.nextDouble();

            System.out.print("Zadejte parametr B: ");
            double B = sc.nextDouble();

            System.out.print("Zadejte parametr C: ");
            double C = sc.nextDouble();

            System.out.print("Zadejte parametr D: ");
            double D = sc.nextDouble();

            dvojbran = new ElektrickyDvojbran(A, B, C, D);
        } else {
            System.out.print("Zadejte vnitřní odpor R1 [Ω]: ");
            double r1 = sc.nextDouble();

            dvojbran = vytvorNapetovyDelic(r1);
        }

        System.out.print("Zadejte vstupní napětí U1 [V]: ");
        double vstupniNapeti = sc.nextDouble();

        System.out.print("Zadejte hodnotu zátěže R2/Z2 [Ω]: ");
        double zatez = sc.nextDouble();

        double[] vystupy = dvojbran.vypocitejVystupy(vstupniNapeti, zatez);

        dvojbran.zobrazVysledky();

        System.out.println("\nPřesné hodnoty navrácené funkcí: U2 = " + vystupy[0] + " V, I2 = " + vystupy[1] + " A");

        sc.close();
    }
}