import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testovací třída pro SpoctiYKvR
 */
public class SpoctiYKvRTest {

    // Přesnost pro porovnávání čísel s plovoucí desetinnou čárkou
    private static final double DELTA = 1e-10;

    @Test
    public void testCalcSingleValue() {
        // Vytvoření instance kvadratické rovnice y = 2x^2 + 3x + 1
        KvR rovnice = new KvR(2, 3, 1);
        SpoctiYKvR calculator = new SpoctiYKvR();

        // Test pro x = 0
        assertEquals(1.0, calculator.calc(rovnice, 0), DELTA);

        // Test pro x = 1
        assertEquals(6.0, calculator.calc(rovnice, 1), DELTA);

        // Test pro x = -1
        assertEquals(0.0, calculator.calc(rovnice, -1), DELTA);

        // Test pro x = 2
        assertEquals(15.0, calculator.calc(rovnice, 2), DELTA);
    }

    @Test
    public void testCalcArrayValues() {
        // Vytvoření instance kvadratické rovnice y = 2x^2 + 3x + 1
        KvR rovnice = new KvR(2, 3, 1);
        SpoctiYKvR calculator = new SpoctiYKvR();

        // Pole vstupních hodnot x
        double[] xValues = {-2, -1, 0, 1, 2};

        // Očekávané výsledky pro dané vstupy
        double[] expectedResults = {11, 0, 1, 6, 15};

        // Výpočet skutečných výsledků
        double[] actualResults = calculator.calcY(rovnice, xValues);

        // Kontrola délky pole výsledků
        assertEquals(xValues.length, actualResults.length);

        // Kontrola jednotlivých výsledků
        for (int i = 0; i < xValues.length; i++) {
            assertEquals(expectedResults[i], actualResults[i], DELTA);
        }
    }

    @Test
    public void testEmptyArray() {
        KvR rovnice = new KvR(1, 1, 1);
        SpoctiYKvR calculator = new SpoctiYKvR();

        // Test pro prázdné pole
        double[] emptyArray = {};
        double[] result = calculator.calcY(rovnice, emptyArray);

        // Ověření, že výsledek je také prázdné pole
        assertEquals(0, result.length);
    }

    @Test
    public void testSpecialCases() {
        // Test pro rovnici y = 0 (nulové koeficienty)
        KvR nulovaRovnice = new KvR(0, 0, 0);
        SpoctiYKvR calculator = new SpoctiYKvR();

        assertEquals(0.0, calculator.calc(nulovaRovnice, 5), DELTA);

        // Test pro lineární rovnici (a = 0)
        KvR linearniRovnice = new KvR(0, 2, 3);
        assertEquals(13.0, calculator.calc(linearniRovnice, 5), DELTA);

        // Test pro konstantní funkci (a = 0, b = 0)
        KvR konstantniFunkce = new KvR(0, 0, 7);
        assertEquals(7.0, calculator.calc(konstantniFunkce, 100), DELTA);
    }
}