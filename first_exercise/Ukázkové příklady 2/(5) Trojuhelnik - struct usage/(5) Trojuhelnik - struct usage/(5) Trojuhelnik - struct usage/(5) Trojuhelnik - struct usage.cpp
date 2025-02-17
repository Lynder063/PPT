// (5) Trojuhelnik - struct usage.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#include <iostream>
#include "TTrojuhelnik.h"
#include "TTrojuhelnik_IO.h"

// program pracuje s 2 trojuhelniky

void reseni_1()
{
	// 1. trojuhelnik
	double a1, b1, c1;
	double obvod1;
	// 2. trojuhelnik
	double a2, b2, c2;
	double obvod2;

	printf("Zadej strany 1. trojuhelnika:\n");
	scanf("%lf", &a1);
	scanf("%lf", &b1);
	scanf("%lf", &c1);

	obvod1 = a1 + b1 + c1;

	// ---

	printf("Zadej strany 2. trojuhelnika:\n");
	scanf("%lf", &a2);
	scanf("%lf", &b2);
	scanf("%lf", &c2);

	obvod2 = a2 + b2 + c2;

	// ---
	printf("1. trojuhelnik:\n");
	printf("a:%.2f;b:%.2f;c:%.2f\n", a1, b1, c1);
	printf("obvod:%.2f\n", obvod1);
	printf("\n\n");

	printf("2. trojuhelnik:\n");
	printf("a:%.2f;b:%.2f;c:%.2f\n", a2, b2, c2);
	printf("obvod:%.2f\n", obvod1);
}

// -----

void nacti_strany_trojuhelnika_r2(int id, double* a, double* b, double* c)
{
	printf("Zadej strany %d. trojuhelnika:\n", id);
	scanf("%lf", a);
	scanf("%lf", b);
	scanf("%lf", c);
}

double spocti_obvod_r2(double a, double b, double c)
{
	return a + b + c;
}

void tisk_trojuhelnik_r2(double id, double a, double b, double c, double obvod)
{
	printf("%d. trojuhelnik:\n", id);
	printf("a:%.2f;b:%.2f;c:%.2f\n", a, b, c);
	printf("obvod:%.2f\n", obvod);
}

void reseni_2()
{
	// 1. trojuhelnik
	double a1, b1, c1;
	double obvod1;
	// 2. trojuhelnik
	double a2, b2, c2;
	double obvod2;

	nacti_strany_trojuhelnika_r2(1, &a1, &b1, &c1);
	nacti_strany_trojuhelnika_r2(2, &a2, &b2, &c2);

	obvod1 = spocti_obvod_r2(a1, b1, c1);
	obvod2 = spocti_obvod_r2(a2, b2, c2);

	tisk_trojuhelnik_r2(1, a1, b1, c1, obvod1);
	tisk_trojuhelnik_r2(2, a2, b2, c2, obvod2);
}

// -----

void reseni_3()
{
	TTrojuhelnik tr1, tr2;

	nacti_strany_trojuhelnika(1, &tr1);
	nacti_strany_trojuhelnika(2, &tr2);

	spocti_trojuhelnik(&tr1);
	spocti_trojuhelnik(&tr2);

	tisk_trojuhelnik(1, tr1);
	tisk_trojuhelnik(2, tr2);
}

// -----

int main()
{
	reseni_1();
	reseni_2();
	reseni_3();   
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
