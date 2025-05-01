import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Format1Reader implements DataReader {

    @Override
    public List<Trida> nactiTridy(String soubor) throws IOException {
        List<Trida> tridy = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            Trida aktualni = null;
            int cisloStudenta = 1;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (!line.contains(";")) {
                    // Nová třída
                    aktualni = new Trida(line.trim());
                    tridy.add(aktualni);
                    cisloStudenta = 1;
                } else {
                    // Student
                    if (aktualni != null) {
                        String[] parts = line.split(";");
                        if (parts.length >= 2) {
                            Student student = new Student(parts[0], parts[1], cisloStudenta);
                            aktualni.pridejStudenta(student);
                            cisloStudenta++;
                        }
                    }
                }
            }
        }

        return tridy;
    }

    @Override
    public void nactiZnamky(List<Trida> tridy, String soubor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            Trida aktualni = null;
            int indexStudenta = 0;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (!line.contains(";")) {
                    // Název třídy
                    String zkratka = line.trim();
                    aktualni = najdiTridu(tridy, zkratka);
                    indexStudenta = 0;
                } else {
                    // Známky pro studenta
                    if (aktualni != null && indexStudenta < aktualni.getStudenti().size()) {
                        Student student = aktualni.getStudenti().get(indexStudenta);
                        nactiZnamkyPevnePoradi(student, line);
                        indexStudenta++;
                    }
                }
            }
        }
    }

    private Trida najdiTridu(List<Trida> tridy, String zkratka) {
        for (Trida trida : tridy) {
            if (trida.getZkratka().equals(zkratka)) {
                return trida;
            }
        }
        return null;
    }

    private void nactiZnamkyPevnePoradi(Student student, String line) {
        String[] znamky = line.split(";");
        String[] predmety = {"MAT", "FYZ", "IT", "CJ", "TV"};

        for (int i = 0; i < znamky.length && i < predmety.length; i++) {
            try {
                int znamka = Integer.parseInt(znamky[i]);
                student.pridejZnamku(predmety[i], znamka);
            } catch (NumberFormatException e) {
                // Ignorujeme neplatné známky
            }
        }
    }

    // Alternativní metoda pro načtení známek s proměnným pořadím předmětů
    private void nactiZnamkyPromenlivePoradi(Student student, String line) {
        // Formát: MAT:1;FYZ:2;IT:1;CJ:1;TV:5
        String[] pairs = line.split(";");

        for (String pair : pairs) {
            String[] parts = pair.split(":");
            if (parts.length == 2) {
                try {
                    String predmet = parts[0];
                    int znamka = Integer.parseInt(parts[1]);
                    student.pridejZnamku(predmet, znamka);
                } catch (NumberFormatException e) {
                    // Ignorujeme neplatné známky
                }
            }
        }
    }
}