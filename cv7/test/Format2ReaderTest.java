import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Format2ReaderTest {

    private Format2Reader reader;

    @TempDir
    Path tempDir;

    private File studentiFile;
    private File znamkyFile;

    @BeforeEach
    public void setUp() throws IOException {
        reader = new Format2Reader();

        // Vytvoření testovacího souboru s třídami a studenty
        studentiFile = tempDir.resolve("studenti.csv").toFile();
        try (FileWriter writer = new FileWriter(studentiFile)) {
            writer.write("3A\n");
            writer.write("2\n");
            writer.write("Jan;Malý\n");
            writer.write("Karolína;Zelenková\n\n");
            writer.write("3B\n");
            writer.write("1\n");
            writer.write("Michal;Doležal\n");
        }

        // Vytvoření testovacího souboru se známkami
        znamkyFile = tempDir.resolve("znamky.csv").toFile();
        try (FileWriter writer = new FileWriter(znamkyFile)) {
            writer.write("3A\n");
            writer.write("2\n");
            writer.write("2;1;1;1;1\n");
            writer.write("3;2;2;2;1\n\n");
            writer.write("3B\n");
            writer.write("1\n");
            writer.write("2;2;1;1;1\n");
        }
    }

    @Test
    public void testNactiTridy() throws IOException {
        List<Trida> tridy = reader.nactiTridy(studentiFile.getAbsolutePath());

        assertEquals(2, tridy.size());

        Trida trida1 = tridy.get(0);
        assertEquals("3A", trida1.getZkratka());
        assertEquals(2, trida1.getStudenti().size());
        assertEquals("Jan", trida1.getStudenti().get(0).getJmeno());
        assertEquals("Malý", trida1.getStudenti().get(0).getPrijmeni());
        assertEquals(1, trida1.getStudenti().get(0).getCislo());
        assertEquals("Karolína", trida1.getStudenti().get(1).getJmeno());

        Trida trida2 = tridy.get(1);
        assertEquals("3B", trida2.getZkratka());
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
        assertEquals(2, student1.getZnamky().get("MAT"));
        assertEquals(1, student1.getZnamky().get("FYZ"));
        assertEquals(1, student1.getZnamky().get("IT"));
        assertEquals(1, student1.getZnamky().get("CJ"));
        assertEquals(1, student1.getZnamky().get("TV"));

        // Kontrola známek druhého studenta
        assertEquals(5, student2.getZnamky().size());
        assertEquals(3, student2.getZnamky().get("MAT"));
        assertEquals(2, student2.getZnamky().get("FYZ"));

        // Kontrola známek studenta z druhé třídy
        Trida trida2 = tridy.get(1);
        Student student3 = trida2.getStudenti().get(0);
        assertEquals(5, student3.getZnamky().size());
        assertEquals(2, student3.getZnamky().get("MAT"));
        assertEquals(1, student3.getZnamky().get("CJ"));
    }

    @Test
    public void testNespravnyPocetStudentu() throws IOException {
        // Vytvoření souboru s nesprávným počtem studentů
        File chybnyFile = tempDir.resolve("chybny.csv").toFile();
        try (FileWriter writer = new FileWriter(chybnyFile)) {
            writer.write("3C\n");
            writer.write("3\n");  // Uveden počet 3, ale v souboru jsou jen 2
            writer.write("Jan;Malý\n");
            writer.write("Karolína;Zelenková\n");
        }

        // Test by měl projít, reader načte jen ty studenty, které v souboru jsou
        List<Trida> tridy = reader.nactiTridy(chybnyFile.getAbsolutePath());
        assertEquals(1, tridy.size());
        assertEquals(2, tridy.get(0).getStudenti().size());
    }

    @Test
    public void testNespravnyFormatZnamek() throws IOException {
        List<Trida> tridy = reader.nactiTridy(studentiFile.getAbsolutePath());

        // Vytvoření souboru s nesprávným formátem známek
        File chybnyFile = tempDir.resolve("chybne_znamky.csv").toFile();
        try (FileWriter writer = new FileWriter(chybnyFile)) {
            writer.write("3A\n");
            writer.write("2\n");
            writer.write("2;x;1;1;1\n");  // 'x' není platná známka
            writer.write("3;2;y;2;1\n");  // 'y' není platná známka
        }

        // Reader by měl zpracovat platné známky a ignorovat neplatné
        reader.nactiZnamky(tridy, chybnyFile.getAbsolutePath());

        Student student1 = tridy.get(0).getStudenti().get(0);
        assertEquals(4, student1.getZnamky().size());  // Jen 4 platné známky, jedna ignorována
        assertEquals(2, student1.getZnamky().get("MAT"));
        assertEquals(1, student1.getZnamky().get("IT"));
        assertNull(student1.getZnamky().get("FYZ"));  // FYZ známka byla neplatná
    }
}