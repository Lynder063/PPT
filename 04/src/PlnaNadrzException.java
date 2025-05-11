/**
 * Výjimka označující situaci, kdy je operace prováděna na prázdné nádrži
 * nebo kdy by operace vedla k vyprázdnění nádrže pod nulovou hodnotu.
 *
 * @author Student
 * @version 2.0
 */
public class PrazdnaNadrzException extends Exception {

    /**
     * Vytvoří novou výjimku bez zprávy
     */
    public PrazdnaNadrzException() {
        super("Operace nelze provést - nádrž je prázdná nebo by byla vyprázdněna pod nulovou hodnotu");
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