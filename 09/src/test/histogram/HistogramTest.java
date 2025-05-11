package test.histogram;

import histogram.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testy pro ověření funkčnosti histogramů.
 */
public class HistogramTest {

    private HistogramProvider provider;
    private HistogramAnalyzer caseInsensitive;
    private HistogramAnalyzer caseSensitive;
    private HistogramAnalyzer withUnrecognized;

    @BeforeEach
    void setUp() {
        provider = new HistogramProvider();
        caseInsensitive = new CaseInsensitiveHistogram();
        caseSensitive = new CaseSensitiveHistogram();
        withUnrecognized = new CaseInsensitiveWithUnrecognizedHistogram();
    }

    @Test
    void testCaseInsensitiveHistogram() {
        String text = "Hello World";
        HistogramResult result = provider.process(text, caseInsensitive);

        assertNotNull(result);
        assertEquals("Case-Insensitive Histogram", result.getHistogramType());

        Map<String, Integer> histogram = result.getHistogram();
        assertEquals(7, histogram.size()); // h, e, l (2x), o, w, r, d
        assertEquals(1, histogram.get("h"));
        assertEquals(1, histogram.get("e"));
        assertEquals(3, histogram.get("l"));
        assertEquals(2, histogram.get("o"));
        assertEquals(1, histogram.get("w"));
        assertEquals(1, histogram.get("r"));
        assertEquals(1, histogram.get("d"));
    }

    @Test
    void testCaseSensitiveHistogram() {
        String text = "Hello World";
        HistogramResult result = provider.process(text, caseSensitive);

        assertNotNull(result);
        assertEquals("Case-Sensitive Histogram", result.getHistogramType());

        Map<String, Integer> histogram = result.getHistogram();
        assertEquals(8, histogram.size()); // H, e, l (2x), o, W, o, r, l, d
        assertEquals(1, histogram.get("H"));
        assertEquals(1, histogram.get("e"));
        assertEquals(2, histogram.get("l"));
        assertEquals(1, histogram.get("o"));
        assertEquals(1, histogram.get("W"));
        assertEquals(1, histogram.get("r"));
        assertEquals(1, histogram.get("d"));
    }

    @Test
    void testCaseInsensitiveWithUnrecognizedHistogram() {
        String text = "Hello, World! 123";
        HistogramResult result = provider.process(text, withUnrecognized);

        assertNotNull(result);
        assertEquals("Case-Insensitive with Unrecognized Histogram", result.getHistogramType());

        Map<String, Integer> histogram = result.getHistogram();
        assertTrue(histogram.containsKey("unrecognized"));
        assertEquals(5, histogram.get("unrecognized")); // , ! 1 2 3
    }

    @Test
    void testEmptyText() {
        String text = "";
        HistogramResult result = provider.process(text, caseInsensitive);

        assertNotNull(result);
        assertTrue(result.getHistogram().isEmpty());
        assertEquals(0, result.getTotalCharacters());
    }

    @Test
    void testNullText() {
        assertThrows(IllegalArgumentException.class, () -> {
            provider.process(null, caseInsensitive);
        });
    }

    @Test
    void testNullAnalyzer() {
        assertThrows(IllegalArgumentException.class, () -> {
            provider.process("Test", null);
        });
    }
}
