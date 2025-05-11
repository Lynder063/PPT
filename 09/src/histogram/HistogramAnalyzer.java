package histogram;

import java.util.Map;

/**
 * Rozhraní pro analyzátory histogramů znaků v textu.
 */
public interface HistogramAnalyzer {

    /**
     * Analyzuje text a vytvoří histogram znaků.
     *
     * @param text Text k analýze
     * @return Objekt obsahující výsledky histogramu
     */
    HistogramResult analyze(String text);

    /**
     * Vrátí název typu histogramu.
     *
     * @return Název typu histogramu
     */
    String getHistogramType();
}
