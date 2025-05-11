import histogram.*;

public class Main {
    public static void main(String[] args) {
        // Ukázkový text pro analýzu
        String text = "Hello World! Tohle je text pro ukol cislo 9 k spocitani charakteru v tomto Stringu do predmetu PPT";

        // Vytvoření provideru a analyzátorů
        HistogramProvider provider = new HistogramProvider();
        HistogramAnalyzer caseInsensitive = new CaseInsensitiveHistogram();
        HistogramAnalyzer caseSensitive = new CaseSensitiveHistogram();
        HistogramAnalyzer withUnrecognized = new CaseInsensitiveWithUnrecognizedHistogram();

        // Zpracování textu a zobrazení výsledků
        System.out.println("Analyzuji text: " + text);
        System.out.println();

        HistogramResult result1 = provider.process(text, caseInsensitive);
        provider.displayResults(result1);
        System.out.println();

        HistogramResult result2 = provider.process(text, caseSensitive);
        provider.displayResults(result2);
        System.out.println();

        HistogramResult result3 = provider.process(text, withUnrecognized);
        provider.displayResults(result3);
    }
}