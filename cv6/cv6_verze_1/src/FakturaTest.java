import java.time.LocalDate;

public class FakturaTest {
    public static void main(String[] args) {
        // Test 1: Vytvoření a výpis faktury se základní sazbou DPH
        testZakladniFaktura();

        // Test 2: Faktura s nulovou hodnotou
        testNulovaFaktura();

        // Test 3: Faktura se sníženou sazbou DPH
        testSnizenaFaktura();
    }

    public static void testZakladniFaktura() {
        System.out.println("Test 1: Vytvoření a výpis faktury se základní sazbou DPH");

        Prijemce prijemce = new Prijemce(
                "Jan", "Novák",
                "Dlouhá 123", "Praha", "11000",
                "+420123456789", "jan.novak@email.cz"
        );

        Sazba sazba = new Sazba("DPH 21%", 21.0);
        CastkyDokladu castky = new CastkyDokladu(1000.0, sazba);

        Faktura faktura = new Faktura(
                "FV2023001",
                LocalDate.of(2023, 4, 1),
                LocalDate.of(2023, 4, 15),
                prijemce,
                castky
        );

        System.out.println(faktura);
        System.out.println("\n-----------------------------\n");
    }

    public static void testNulovaFaktura() {
        System.out.println("Test 2: Faktura s nulovou hodnotou");

        Prijemce prijemce = new Prijemce(
                "Petr", "Svoboda",
                "Krátká 456", "Brno", "60200",
                "+420987654321", "petr.svoboda@email.cz"
        );

        Sazba sazba = new Sazba("DPH 21%", 21.0);
        CastkyDokladu castky = new CastkyDokladu(0.0, sazba);

        Faktura faktura = new Faktura(
                "FV2023002",
                LocalDate.of(2023, 4, 2),
                LocalDate.of(2023, 4, 16),
                prijemce,
                castky
        );

        System.out.println(faktura);
        System.out.println("\n-----------------------------\n");
    }

    public static void testSnizenaFaktura() {
        System.out.println("Test 3: Faktura se sníženou sazbou DPH");

        Prijemce prijemce = new Prijemce(
                "Marie", "Dvořáková",
                "Široká 789", "Olomouc", "77900",
                "+420111222333", "marie.dvorakova@email.cz"
        );

        Sazba sazba = new Sazba("DPH 10%", 10.0);
        CastkyDokladu castky = new CastkyDokladu(500.0, sazba);

        Faktura faktura = new Faktura(
                "FV2023003",
                LocalDate.of(2023, 4, 3),
                LocalDate.of(2023, 4, 17),
                prijemce,
                castky
        );

        System.out.println(faktura);
        System.out.println("\n-----------------------------\n");
    }
}