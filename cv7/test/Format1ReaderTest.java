import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Format1ReaderTest {

    private Format1Reader reader;

    @TempDir
    Path tempDir;

    private File studentiFile;
    private File znamkyFile;

    @BeforeEach
    public void setUp() throws IOException {
        reader = new Format1Reader();

        // Vytvoření testovacího souboru s třídami a studenty
        studentiFile = tempDir.resolve("studenti.csv").toFile();
        try (FileWriter writer = new FileWriter(studentiFile)) {
            writer.write("4A\n");
            writer.write("Jan;Novák\n");
            writer.write("Marie;Svobodová\n\n");
            writer.write("4B\n");
            writer.write("Petr;Dvořák\n");
        }

        // Vytvoření testovacího souboru se známkami
        znamkyFile = tempDir.resolve("znamky.csv").toFile();
        try (FileWriter writer = new FileWriter(znamkyFile)) {
            writer.write("4A\n");
            writer.write("1;2;1;2;1\n");
            writer.write("2;3;2;1;1\n\n");
            writer.write("4B\n");
            writer.write("1;2;2;3;1\n");
        }
    }

    @Test
    public void testNactiTridy() throws IOException {
        List<Trida> tridy = reader.nactiTridy(studentiFile.getAbsolutePath());

        assertEquals(2, tridy.size());

        Trida trida1 = tridy.get(0);
        assertEquals("4A", trida1.getZkratka());
        assertEquals(2, trida1.getStudenti().size());
        assertEquals("Jan", trida1.getStudenti().get(0).getJmeno());
        assertEquals("Novák", trida1.getStudenti().get(0).getPrijmeni());
        assertEquals(1, trida1.getStudenti().get(0).getCislo());
        assertEquals("Marie", trida1.getStudenti().get(1).getJmeno());

        Trida trida2 = tridy.get(1);
        assertEquals("4B", trida2.getZkratka());
        assertEquals(1, trida2.getStudenti().size());
    }

    @Test
    public void testNactiZnamky() throws IOException {
        List<Trida> tridy = reader.nactiTridy(studentiFile.getAbsolutePath());
        reader.nactiZnamky(tridy, znamkyFile.getAbsolutePath());

        Trida trida1 = tridy.get(0);
        Student student1 = trida1.getStudenti().get(0);
        Student student2 = trida1.getStudenti().get(1);

        // Kontrola známek prvního studenta
        assertEquals(5, student1.getZnamky().size());
        assertEquals(1, student1.getZnamky().get("MAT"));
        assertEquals(2, student1.getZnamky().get("FYZ"));
        assertEquals(1, student1.getZnamky().get("IT"));
        assertEquals(2, student1.getZnamky().get("CJ"));
        assertEquals(1, student1.getZnamky().get("TV"));

        // Kontrola známek druhého studenta
        assertEquals(5, student2.getZnamky().size());
        assertEquals(2, student2.getZnamky().get("MAT"));
        assertEquals(3, student2.getZnamky().get("FYZ"));

        // Kontrola známek studenta z druhé třídy
        Trida trida2 = tridy.get(1);
        Student student3 = trida2.getStudenti().get(0);
        assertEquals(5, student3.getZnamky().size());
        assertEquals(1, student3.getZnamky().get("MAT"));
        assertEquals(3, student3.getZnamky().get("CJ"));
    }

    @Test
    public void testSouborNeexistuje() {
        assertThrows(IOException.class, () -> {
            reader.nactiTridy("neexistujici_soubor.csv");
        });
    }

    @Test
    public void testHledaniTridy() throws IOException {
        List<Trida> tridy = reader.nactiTridy(studentiFile.getAbsolutePath());

        // Přidání neexistující třídy do souboru se známkami
        try (FileWriter writer = new FileWriter(znamkyFile)) {
            writer.write("4A\n");
            writer.write("1;2;1;2;1\n");
            writer.write("2;3;2;1;1\n\n");
            writer.write("4C\n");  // Tato třída neexistuje v seznamu tříd
            writer.write("1;2;2;3;1\n");
        }

        // Reader by měl ignorovat známky pro neexistující třídu
        reader.nactiZnamky(tridy, znamkyFile.getAbsolutePath());

        // Kontrola, že byly načteny jen známky pro existující třídy
        assertEquals(2, tridy.size());
        assertTrue(tridy.stream().noneMatch(t -> t.getZkratka().equals("4C")));
    }
}