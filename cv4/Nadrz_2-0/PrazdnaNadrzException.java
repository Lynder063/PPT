/**
 * Výjimka označující situaci, kdy je operace prováděna na prázdné nádrži
 */
public class PrazdnaNadrzException extends Exception {

    /**
     * Vytvoří novou výjimku bez zprávy
     */
    public PrazdnaNadrzException() {
        super();
    }

    /**
     * Vytvoří novou výjimku se zprávou
     *
     * @param message Text popisující výjimku
     */
    public PrazdnaNadrzException(String message) {
        super(message);
    }
}