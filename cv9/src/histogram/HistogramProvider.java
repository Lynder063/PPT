package histogram;

import java.util.Map;

/**
 * Třída pro zpracování textu a zobrazení výsledků histogramu.
 */
public class HistogramProvider {

    /**
     * Zpracuje text pomocí daného analyzátoru a vrátí výsledky.
     *
     * @param text Text k analýze
     * @param analyzer Analyzátor histogramu
     * @return Výsledek histogramu
     */
    public HistogramResult process(String text, HistogramAnalyzer analyzer) {
        if (text == null || analyzer == null) {
            throw new IllegalArgumentException("Text a analyzátor nesmí být null");
        }

        return analyzer.analyze(text);
    }

    /**
     * Zobrazí výsledky histogramu.
     *
     * @param result Výsledek histogramu
     */
    public void displayResults(HistogramResult result) {
        if (result == null) {
            throw new IllegalArgumentException("Výsledek nesmí být null");
        }

        System.out.println("=== " + result.getHistogramType() + " ===");
        System.out.println("Celkový počet zpracovaných znaků: " + result.getTotalCharacters());
        System.out.println("Histogram:");

        Map<String, Integer> histogram = result.getHistogram();
        histogram.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
