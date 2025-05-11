import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataWriterImplTest {

    private DataWriterImpl dataWriter;
    private List<Trida> testTridy;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        dataWriter = new DataWriterImpl();
        testTridy = new ArrayList<>();

        // Vytvoření testovacích dat - třída 1
        Trida trida1 = new Trida("1A");
        Student student1 = new Student("Jan", "Novák", 1);
        Student student2 = new Student("Marie", "Svobodová", 2);

        // Přidání známek studentům
        student1.pridejZnamku("MAT", 1);
        student1.pridejZnamku("CJL", 2);

        student2.pridejZnamku("MAT", 3);
        student2.pridejZnamku("CJL", 1);

        trida1.pridejStudenta(student1);
        trida1.pridejStudenta(student2);

        // Vytvoření testovacích dat - třída 2
        Trida trida2 = new Trida("2B");
        Student student3 = new Student("Petr", "Černý", 1);

        student3.pridejZnamku("MAT", 2);
        student3.pridejZnamku("FYZ", 1);

        trida2.pridejStudenta(student3);

        // Přidání tříd do seznamu
        testTridy.add(trida1);
        testTridy.add(trida2);
    }

    @Test
    void zapisSeznamyStudentu_vytvoriSpravneSoubory() throws IOException {
        // Arrange
        String adresarCesta = tempDir.toString();

        // Act
        dataWriter.zapisSeznamyStudentu(testTridy, adresarCesta);

        // Assert
        File file1A = new File(adresarCesta + File.separator + "1A.csv");
        File file2B = new File(adresarCesta + File.separator + "2B.csv");

        assertTrue(file1A.exists(), "Soubor 1A.csv by měl existovat");
        assertTrue(file2B.exists(), "Soubor 2B.csv by měl existovat");

        // Kontrola obsahu souboru 1A.csv
        List<String> lines1A = Files.readAllLines(file1A.toPath());
        assertEquals("1A", lines1A.get(0), "První řádek by měl obsahovat zkratku třídy");
        assertEquals("2", lines1A.get(1), "Druhý řádek by měl obsahovat počet studentů");
        assertEquals(4, lines1A.size(), "Soubor by měl mít správný počet řádků");

        // Kontrola obsahu souboru 2B.csv
        List<String> lines2B = Files.readAllLines(file2B.toPath());
        assertEquals("2B", lines2B.get(0), "První řádek by měl obsahovat zkratku třídy");
        assertEquals("1", lines2B.get(1), "Druhý řádek by měl obsahovat počet studentů");
        assertEquals(3, lines2B.size(), "Soubor by měl mít správný počet řádků");
    }

    @Test
    void zapisProspech_vytvoriSpraveProspechSoubor() throws IOException {
        // Arrange
        String souborCesta = tempDir.resolve("prospech.txt").toString();

        // Act
        dataWriter.zapisProspech(testTridy, souborCesta);

        // Assert
        File prospechFile = new File(souborCesta);
        assertTrue(prospechFile.exists(), "Soubor prospech.txt by měl existovat");

        // Kontrola obsahu souboru s prospěchem
        try (BufferedReader reader = new BufferedReader(new FileReader(prospechFile))) {
            String firstLine = reader.readLine();
            assertEquals("PROSPĚCH STUDENTŮ A TŘÍD", firstLine, "První řádek by měl mít správný titulek");

            // Přeskočení prázdného řádku
            reader.readLine();

            String tridaLine = reader.readLine();
            assertTrue(tridaLine.contains("Třída: 1A"), "Soubor by měl obsahovat informace o třídě 1A");

            // Přeskočení oddělovací čáry
            reader.readLine();

            String heading = reader.readLine();
            assertEquals("Průměry předmětů:", heading, "Soubor by měl obsahovat sekci s průměry předmětů");

            // Čtení dalších řádků a kontrola, zda obsahuje průměry předmětů
            String line;
            boolean containsMatAvg = false;
            boolean containsCjlAvg = false;
            boolean containsFyzAvg = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("MAT:")) containsMatAvg = true;
                if (line.startsWith("CJL:")) containsCjlAvg = true;
                if (line.startsWith("FYZ:")) containsFyzAvg = true;

                // Pokud jsme narazili na sekci s třídou 2B, můžeme ukončit kontrolu pro třídu 1A
                if (line.contains("Třída: 2B")) break;
            }

            assertTrue(containsMatAvg, "Soubor by měl obsahovat průměr pro MAT");
            assertTrue(containsCjlAvg, "Soubor by měl obsahovat průměr pro CJL");
        }
    }
}