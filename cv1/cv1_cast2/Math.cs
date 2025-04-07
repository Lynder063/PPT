using System;

namespace MyMathLibrary
{
    /// <summary>
    /// Třída pro matematické funkce.
    /// </summary>
    public class Math
    {
        /// <summary>
        /// Vypočítá faktoriál zadaného čísla.
        /// </summary>
        /// <param name="n">Číslo, pro které se má faktoriál spočítat</param>
        /// <returns>Faktoriál čísla n</returns>
        public static long Faktoriyl(int n)
        {
            if (n < 0)
                throw new ArgumentException("Číslo musí být nezáporné.");

            long result = 1;
            for (int i = 1; i <= n; i++)
            {
                result *= i;
            }
            return result;
        }
    }
}
