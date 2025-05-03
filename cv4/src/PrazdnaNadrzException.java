/**
 * Výjimka označující situaci, kdy je operace prováděna na plné nádrži
 * nebo kdy by operace vedla k překročení kapacity nádrže.
 *
 * @author Student
 * @version 2.0
 */
public class PlnaNadrzException extends Exception {

    /**
     * Vytvoří novou výjimku bez zprávy
     */
    public PlnaNadrzException() {
        super("Operace nelze provést - nádrž je plná nebo by došlo k překročení kapacity");
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