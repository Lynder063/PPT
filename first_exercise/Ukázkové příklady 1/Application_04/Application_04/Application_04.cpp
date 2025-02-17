// Application_04.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#include "pch.h"
#include <iostream>

void obdelniky()
{
	double a1, b1, o1, S1;
	double a2, b2, o2, S2;

	printf("Zadej strany obdelnika:\n");
	scanf("%lf", &a1);
	scanf("%lf", &b1);

	o1 = 2 * (a1 + b1);
	S1 = a1 * b1;

	printf("\nObdelnik o stranach %.2f a %.2f ma obvod %.2f a obsah %.2f.\n", a1, b1, o1, S1);

	// ---
	printf("\n\n");
	printf("Zadej strany obdelnika:\n");
	scanf("%lf", &a2);
	scanf("%lf", &b2);

	o2 = 2 * (a2 + b2);
	S2 = a2 * b2;

	printf("\nObdelnik o stranach %.2f a %.2f ma obvod %.2f a obsah %.2f.\n", a2, b2, o2, S2);
}

int main()
{
	obdelniky();    
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
