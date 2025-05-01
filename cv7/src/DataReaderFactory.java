public class DataReaderFactory {
    public static DataReader createReader(String format) {
        switch (format) {
            case "FORMAT1":
                return new Format1Reader();
            case "FORMAT2":
                return new Format2Reader();
            case "FORMAT3":
                return new Format3Reader();
            default:
                throw new IllegalArgumentException("Nepodporovaný formát: " + format);
        }
    }
}