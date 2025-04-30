package CalcFibonacci;

import java.util.Arrays;

public class Fibonacci {
    private int[] table;

    // Nerekurzivní výpočet Fibonacciho čísla
    public int calcNerek(int n) {
        if (n < 0) throw new IllegalArgumentException("Index musí být nezáporný.");
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    // Rekurzivní výpočet Fibonacciho čísla (pomalejší)
    public int calcRek(int n) {
        if (n < 0) throw new IllegalArgumentException("Index musí být nezáporný.");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return calcRek(n - 1) + calcRek(n - 2);
    }

    // Inicializace tabulky pro dynamické programování
    public void init(int n) {
        table = new int[n + 1];
        Arrays.fill(table, -1);
    }

    // Výpočet Fibonacciho čísla s využitím dynamického programování
    public int calcRekTable(int n) {
        if (n < 0) throw new IllegalArgumentException("Index musí být nezáporný.");
        if (table == null || table.length <= n) {
            init(n);
        }

        if (n == 0) return 0;
        if (n == 1) return 1;

        if (table[n] != -1) {
            return table[n];
        }

        table[n] = calcRekTable(n - 1) + calcRekTable(n - 2);

        // Výpis stavu tabulky při každém výpočtu
        System.out.println("Tabulka po výpočtu F(" + n + "): " + Arrays.toString(table));

        return table[n];
    }



}
