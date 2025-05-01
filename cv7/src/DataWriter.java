import java.io.IOException;
import java.util.List;

public interface DataWriter {
    void zapisSeznamyStudentu(List<Trida> tridy, String adresar) throws IOException;
    void zapisProspech(List<Trida> tridy, String soubor) throws IOException;
}