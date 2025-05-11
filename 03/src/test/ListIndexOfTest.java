package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test pro třídu List a její metodu indexOf
 */
public class ListIndexOfTest {

    @Test
    public void testListIndexOf() {
        // Arrange - připravíme testovací data
        List<String> seznam = new ArrayList<>();
        seznam.add("jablko");
        seznam.add("hruška");
        seznam.add("švestka");
        seznam.add("hruška");  // Duplicitní prvek

        // Act & Assert - zavoláme testovanou metodu a ověříme výsledky
        assertEquals(0, seznam.indexOf("jablko"), "IndexOf by měl vrátit 0 pro první prvek");
        assertEquals(1, seznam.indexOf("hruška"), "IndexOf by měl vrátit index prvního výskytu");
        assertEquals(2, seznam.indexOf("švestka"), "IndexOf by měl vrátit správný index pro 'švestka'");
        assertEquals(-1, seznam.indexOf("banán"), "IndexOf by měl vrátit -1 pro neexistující prvek");

        // Test s referenčními objekty
        Object obj1 = new Object();
        Object obj2 = new Object();
        List<Object> objekty = new ArrayList<>();
        objekty.add(obj1);
        objekty.add(obj2);

        assertEquals(0, objekty.indexOf(obj1), "IndexOf by měl porovnávat reference objektů");
        assertEquals(1, objekty.indexOf(obj2), "IndexOf by měl porovnávat reference objektů");
        assertEquals(-1, objekty.indexOf(new Object()), "Nový objekt by měl mít jinou referenci");
    }
}