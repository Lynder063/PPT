import java.io.IOException;
import java.util.List;

public interface DataReader {
    List<Trida> nactiTridy(String soubor) throws IOException;
    void nactiZnamky(List<Trida> tridy, String soubor) throws IOException;
}