package histogram;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída pro uchování výsledků histogramu.
 */
public class HistogramResult {
    private Map<String, Integer> histogram;
    private String histogramType;
    private int totalCharacters;

    public HistogramResult(Map<String, Integer> histogram, String histogramType) {
        this.histogram = new HashMap<>(histogram);
        this.histogramType = histogramType;
        this.totalCharacters = histogram.values().stream().mapToInt(Integer::intValue).sum();
    }

    public Map<String, Integer> getHistogram() {
        return new HashMap<>(histogram);
    }

    public String getHistogramType() {
        return histogramType;
    }

    public int getTotalCharacters() {
        return totalCharacters;
    }

    /**
     * Vrátí počet výskytů daného znaku.
     *
     * @param character Znak
     * @return Počet výskytů znaku
     */
    public int getCount(String character) {
        return histogram.getOrDefault(character, 0);
    }
}
