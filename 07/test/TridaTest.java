import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TridaTest {

    private Trida trida;
    private Student student1;
    private Student student2;

    @BeforeEach
    public void setUp() {
        trida = new Trida("4A");

        student1 = new Student("Jan", "Novák", 1);
        student1.pridejZnamku("MAT", 1);
        student1.pridejZnamku("FYZ", 2);
        student1.pridejZnamku("IT", 1);

        student2 = new Student("Marie", "Svobodová", 2);
        student2.pridejZnamku("MAT", 2);
        student2.pridejZnamku("FYZ", 3);
        student2.pridejZnamku("IT", 1);

        trida.pridejStudenta(student1);
        trida.pridejStudenta(student2);
    }

    @Test
    public void testKonstruktor() {
        assertEquals("4A", trida.getZkratka());
        assertTrue(trida.getStudenti() instanceof List);
    }

    @Test
    public void testPridejStudenta() {
        Student student3 = new Student("Petr", "Dvořák", 3);
        trida.pridejStudenta(student3);

        List<Student> studenti = trida.getStudenti();
        assertEquals(3, studenti.size());
        assertSame(student3, studenti.get(2));
    }

    @Test
    public void testVypocitejPrumerPredmetu() {
        Map<String, Double> prumery = trida.vypocitejPrumerPredmetu();

        assertEquals(3, prumery.size());
        assertEquals(1.5, prumery.get("MAT"));
        assertEquals(2.5, prumery.get("FYZ"));
        assertEquals(1.0, prumery.get("IT"));
    }


    @Test
    public void testVypocitejCelkovyPrumer_BezStudentu() {
        Trida prazdnaTrida = new Trida("Prázdná");
        assertEquals(0, prazdnaTrida.vypocitejCelkovyPrumer());
    }
}