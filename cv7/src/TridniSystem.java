import java.io.IOException;
import java.util.List;

public class TridniSystem {
    private List<Trida> tridy;
    private DataWriter writer;
    private String adresarVystupu;
    private String souborProspech;

    public TridniSystem(List<Trida> tridy, DataWriter writer, String adresarVystupu, String souborProspech) {
        this.tridy = tridy;
        this.writer = writer;
        this.adresarVystupu = adresarVystupu;
        this.souborProspech = souborProspech;
    }

    public void zapisSeznamyStudentu() throws IOException {
        writer.zapisSeznamyStudentu(tridy, adresarVystupu);
    }

    public void zapisProspech() throws IOException {
        writer.zapisProspech(tridy, adresarVystupu + '/' + souborProspech);
    }
}