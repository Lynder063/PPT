import java.time.LocalDate;

public class FakturaBuilderTest {
    public static void main(String[] args) {
        testVypocetZdola();
        testVypocetShora();
        testVypocetFixni();
    }

    public static void testVypocetZdola() {
        System.out.println("Test: Výpočet DPH zdola (z ceny bez DPH)");

        Faktura faktura = new FakturaBuilder()
                .cisloDokladu("FV2023004")
                .datumVystaveni(LocalDate.of(2023, 5, 1))
                .datumSplatnosti(LocalDate.of(2023, 5, 15))
                .novyPrijemce(
                        "Jan", "Novák",
                        "Dlouhá 123", "Praha", "11000",
                        "+420123456789", "jan.novak@email.cz")
                .castka(1000.0)  // 1000 Kč bez DPH
                .sazba("DPH 21%", 21.0)
                .typVypoctuDane(TypVypoctuDane.ZDOLA)
                .build();

        System.out.println(faktura);
        System.out.println("\nOčekávaný výsledek: Cena bez DPH = 1000 Kč, DPH = 210 Kč, Cena s DPH = 1210 Kč");
        System.out.println("\n-----------------------------\n");
    }

    public static void testVypocetShora() {
        System.out.println("Test: Výpočet DPH shora (z celkové ceny)");

        Faktura faktura = new FakturaBuilder()
                .cisloDokladu("FV2023005")
                .datumVystaveni(LocalDate.of(2023, 5, 2))
                .datumSplatnosti(LocalDate.of(2023, 5, 16))
                .novyPrijemce(
                        "Petr", "Svoboda",
                        "Krátká 456", "Brno", "60200",
                        "+420987654321", "petr.svoboda@email.cz")
                .castka(1210.0)  // 1210 Kč celkem (s DPH)
                .sazba("DPH 21%", 21.0)
                .typVypoctuDane(TypVypoctuDane.SHORA)
                .build();

        System.out.println(faktura);
        System.out.println("\nOčekávaný výsledek: Cena bez DPH ≈ 1000 Kč, DPH ≈ 210 Kč, Cena s DPH = 1210 Kč");
        System.out.println("\n-----------------------------\n");
    }

    public static void testVypocetFixni() {
        System.out.println("Test: Výpočet s fixní hodnotou DPH");

        Faktura faktura = new FakturaBuilder()
                .cisloDokladu("FV2023006")
                .datumVystaveni(LocalDate.of(2023, 5, 3))
                .datumSplatnosti(LocalDate.of(2023, 5, 17))
                .novyPrijemce(
                        "Marie", "Dvořáková",
                        "Široká 789", "Olomouc", "77900",
                        "+420111222333", "marie.dvorakova@email.cz")
                .castka(1000.0)  // 1000 Kč bez DPH
                .sazba("DPH 21%", 21.0)
                .typVypoctuDane(TypVypoctuDane.FIXNI)
                .fixniDph(200.0)  // Pevně stanovená hodnota DPH
                .build();

        System.out.println(faktura);
        System.out.println("\nOčekávaný výsledek: Cena bez DPH = 1000 Kč, DPH = 200 Kč, Cena s DPH = 1200 Kč");
        System.out.println("\n-----------------------------\n");
    }
}