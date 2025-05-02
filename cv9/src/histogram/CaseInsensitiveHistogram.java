package histogram;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementace histogramu písmen anglické abecedy bez rozlišení velkých a malých písmen.
 */
public class CaseInsensitiveHistogram implements HistogramAnalyzer {

    @Override
    public HistogramResult analyze(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text nesmí být null");
        }

        Map<String, Integer> histogram = new HashMap<>();

        // Zpracování textu a počítání výskytů písmen
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                String key = String.valueOf(Character.toLowerCase(c));
                histogram.put(key, histogram.getOrDefault(key, 0) + 1);
            }
        }

        return new HistogramResult(histogram, getHistogramType());
    }

    @Override
    public String getHistogramType() {
        return "Case-Insensitive Histogram";
    }
}
