import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("Jan", "Novák", 1);
    }

    @Test
    public void testKonstruktor() {
        assertEquals("Jan", student.getJmeno());
        assertEquals("Novák", student.getPrijmeni());
        assertEquals(1, student.getCislo());
        assertTrue(student.getZnamky().isEmpty());
    }

    @Test
    public void testPridejZnamku() {
        student.pridejZnamku("MAT", 1);
        student.pridejZnamku("FYZ", 2);

        Map<String, Integer> znamky = student.getZnamky();
        assertEquals(2, znamky.size());
        assertEquals(1, znamky.get("MAT"));
        assertEquals(2, znamky.get("FYZ"));
    }

    @Test
    public void testVypocitejPrumer_BezZnamek() {
        assertEquals(0, student.vypocitejPrumer());
    }

    @Test
    public void testVypocitejPrumer_SeZnamkami() {
        student.pridejZnamku("MAT", 1);
        student.pridejZnamku("FYZ", 2);
        student.pridejZnamku("IT", 3);

        double prumer = student.vypocitejPrumer();
        assertEquals(2.0, prumer);
    }

    @Test
    public void testToString() {
        assertEquals("Jan;Novák", student.toString());
    }
}