import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Format3Reader implements DataReader {

    @Override
    public List<Trida> nactiTridy(String soubor) throws IOException {
        List<Trida> tridy = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            Trida aktualni = null;
            boolean ocekavejPocet = false;
            boolean ocekavejJmeno = false;
            String jmeno = null;
            int cisloStudenta = 1;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                if (!ocekavejPocet && !ocekavejJmeno) {
                    // Nová třída
                    aktualni = new Trida(line);
                    tridy.add(aktualni);
                    ocekavejPocet = true;
                    cisloStudenta = 1;
                } else if (ocekavejPocet) {
                    // Počet studentů - jen přečteme a pokračujeme
                    ocekavejPocet = false;
                    ocekavejJmeno = true;
                } else if (ocekavejJmeno) {
                    // Zpracování jména
                    if (jmeno == null) {
                        jmeno = line;
                        ocekavejJmeno = false; // Další bude příjmení
                    } else {
                        // Máme jméno i příjmení
                        String prijmeni = line;
                        Student student = new Student(jmeno, prijmeni, cisloStudenta);
                        aktualni.pridejStudenta(student);
                        cisloStudenta++;
                        jmeno = null;
                        ocekavejJmeno = true; // Další bude zase jméno
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
            boolean ocekavejPocet = false;
            int indexStudenta = 0;
            int predmetIndex = 0;
            String[] predmety = {"MAT", "FYZ", "IT", "CJ", "TV"};

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                if (!ocekavejPocet) {
                    // Název třídy
                    String zkratka = line;
                    aktualni = najdiTridu(tridy, zkratka);
                    ocekavejPocet = true;
                    indexStudenta = 0;
                    predmetIndex = 0;
                } else if (ocekavejPocet) {
                    // Počet studentů - jen přečteme a pokračujeme
                    ocekavejPocet = false;
                } else {
                    // Známky pro studenta
                    if (aktualni != null && indexStudenta < aktualni.getStudenti().size()) {
                        try {
                            int znamka = Integer.parseInt(line);
                            Student student = aktualni.getStudenti().get(indexStudenta);

                            if (predmetIndex < predmety.length) {
                                student.pridejZnamku(predmety[predmetIndex], znamka);
                                predmetIndex++;

                                if (predmetIndex >= predmety.length) {
                                    indexStudenta++;
                                    predmetIndex = 0;
                                }
                            }
                        } catch (NumberFormatException e) {
                            // Ignorujeme neplatné známky
                        }
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
}
