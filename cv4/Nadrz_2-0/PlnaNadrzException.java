/**
 * Výjimka označující situaci, kdy je operace prováděna na plné nádrži
 */
public class PlnaNadrzException extends Exception {

    /**
     * Vytvoří novou výjimku bez zprávy
     */
    public PlnaNadrzException() {
        super();
    }

    /**
     * Vytvoří novou výjimku se zprávou
     *
     * @param message Text popisující výjimku
     */
    public PlnaNadrzException(String message) {
        super(message);
    }
}