import java.io.IOException;
import java.util.List;

public class TridniSystemBuilder {
    private String vstupniSoubor;
    private String formatVstupu;
    private String soubOrZnamky;
    private String adresarVystupu;
    private String souborProspech;

    public TridniSystemBuilder setVstupniSoubor(String vstupniSoubor) {
        this.vstupniSoubor = vstupniSoubor;
        return this;
    }

    public TridniSystemBuilder setFormatVstupu(String formatVstupu) {
        this.formatVstupu = formatVstupu;
        return this;
    }

    public TridniSystemBuilder setSouborZnamky(String souborZnamky) {
        this.soubOrZnamky = souborZnamky;
        return this;
    }

    public TridniSystemBuilder setAdresarVystupu(String adresarVystupu) {
        this.adresarVystupu = adresarVystupu;
        return this;
    }

    public TridniSystemBuilder setSouborProspech(String souborProspech) {
        this.souborProspech = souborProspech;
        return this;
    }

    public TridniSystem build() throws IOException {
        if (vstupniSoubor == null || formatVstupu == null || soubOrZnamky == null ||
                adresarVystupu == null || souborProspech == null) {
            throw new IllegalStateException("Všechny parametry musí být nastaveny");
        }

        DataReader reader = DataReaderFactory.createReader(formatVstupu);
        DataWriter writer = new DataWriterImpl();

        List<Trida> tridy = reader.nactiTridy(vstupniSoubor);
        reader.nactiZnamky(tridy, soubOrZnamky);

        return new TridniSystem(tridy, writer, adresarVystupu, souborProspech);
    }
}