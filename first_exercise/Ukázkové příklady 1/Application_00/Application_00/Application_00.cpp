// Application_00.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <iostream>

int main()
{
	double c1, c2, c3, c4;

	printf("Zadej strany obdelnika:\n");
	scanf("%lf", &c1);
	scanf("%lf", &c2);

	c3 = 2 * (c1 + c2);
	c4 = c1 * c2;

	printf("\nObdelnik o stranach %.2f a %.2f ma obvod %.2f a obsah %.2f.\n", c1, c2, c3, c4);
}


// Spuštění programu: Ctrl+F5 nebo nabídka Ladit > Spustit bez ladění
// Ladění programu: F5 nebo nabídka Ladit > Spustit ladění

// Tipy pro zahájení práce:
//   1. K přidání nebo správě souborů použijte okno Průzkumník řešení.
//   2. Pro připojení ke správě zdrojového kódu použijte okno Team Explorer.
//   3. K zobrazení výstupu sestavení a dalších zpráv použijte okno Výstup.
//   4. K zobrazení chyb použijte okno Seznam chyb.
//   5. Pokud chcete vytvořit nové soubory kódu, přejděte na Projekt > Přidat novou položku. Pokud chcete přidat do projektu existující soubory kódu, přejděte na Projekt > Přidat existující položku.
//   6. Pokud budete chtít v budoucnu znovu otevřít tento projekt, přejděte na Soubor > Otevřít > Projekt a vyberte příslušný soubor .sln.
