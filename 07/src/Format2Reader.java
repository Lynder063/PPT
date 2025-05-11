import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Format2Reader implements DataReader {

    @Override
    public List<Trida> nactiTridy(String soubor) throws IOException {
        List<Trida> tridy = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            Trida aktualni = null;
            int cisloStudenta = 1;
            boolean ocekavejPocet = false;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (!line.contains(";") && !ocekavejPocet) {
                    // Nová třída
                    aktualni = new Trida(line.trim());
                    tridy.add(aktualni);
                    ocekavejPocet = true;
                    cisloStudenta = 1;
                } else if (ocekavejPocet) {
                    // Počet studentů - jen přečteme a pokračujeme
                    ocekavejPocet = false;
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
            boolean prvniRadek = true;
            boolean ocekavejPocet = false;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (!line.contains(";") && !ocekavejPocet) {
                    // Název třídy
                    String zkratka = line.trim();
                    aktualni = najdiTridu(tridy, zkratka);
                    ocekavejPocet = true;
                    indexStudenta = 0;
                } else if (ocekavejPocet) {
                    // Počet studentů - jen přečteme a pokračujeme
                    ocekavejPocet = false;
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
}