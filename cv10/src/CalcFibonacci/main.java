package CalcFibonacci;

public class main {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int n = 10;
        System.out.println("Iterativně: " + fib.calcNerek(n));
        System.out.println("Rekurzivně: " + fib.calcRek(n));
        System.out.println("Dynamické programování:");
        fib.init(n);
        System.out.println("Výsledek: " + fib.calcRekTable(n));
    }
}
