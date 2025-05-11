public class KvadratickaRovniceDemo {
    public static void main(String[] args) {
        // Vytvoření kvadratické rovnice y = 1x^2 - 2x + 3
        KvR rovnice = new KvR(1, -2, 3);

        // Vytvoření kalkulátoru
        SpoctiYKvR calculator = new SpoctiYKvR();

        // Výpočet pro jednotlivé hodnoty x
        System.out.println("Hodnota pro x = 0: " + calculator.calc(rovnice, 0));
        System.out.println("Hodnota pro x = 1: " + calculator.calc(rovnice, 1));
        System.out.println("Hodnota pro x = 2: " + calculator.calc(rovnice, 2));

        // Výpočet pro pole hodnot
        double[] xValues = {-2, -1, 0, 1, 2, 3};
        double[] results = calculator.calcY(rovnice, xValues);

        System.out.println("\nVýpočet pro pole hodnot:");
        for (int i = 0; i < xValues.length; i++) {
            System.out.println("f(" + xValues[i] + ") = " + results[i]);
        }

        // Ukázka KvREx
        KvREx extendedRovnice = new KvREx(1, -2, 3, 2);
        System.out.println("\nKvREx pro x = 2: y = " + extendedRovnice.getY());
    }
}