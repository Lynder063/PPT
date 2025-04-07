using System;
using MyMathLibrary;

class Program
{
    static void Main()
    {
        // Testování metody Faktoriyl
        int number = 5;
        long result = MyMathLibrary.Math.Faktoriyl(number);  // Použití metody
        Console.WriteLine($"Faktoriál čísla {number} je {result}");

        // Další test s jiným číslem
        number = 7;
        result = MyMathLibrary.Math.Faktoriyl(number);
        Console.WriteLine($"Faktoriál čísla {number} je {result}");

        // Použití vestavěné knihovny Math (explicitně kvalifikované)
        double squareRoot = System.Math.Sqrt(16);  // Explicitně použijeme System.Math
        Console.WriteLine($"Druhá odmocnina z 16 je {squareRoot}");

        Console.ReadLine();  // Aby okno konzole nezavřelo okamžitě
    }
}
