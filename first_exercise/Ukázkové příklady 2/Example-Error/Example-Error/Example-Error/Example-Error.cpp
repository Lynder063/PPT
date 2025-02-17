// Example-Error.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#include <iostream>
#include <stdlib.h>

int idError;

// --------------

double calc(char z, int n)
{
    if () // test na chybu (chybovy stav)
    {
        idError = 1; // id zjistene chyby
        return 0.0;  // neco musime vratit
    }

    idError = 0;   // neni chyba, OK
    // vypocet nad daty
    double vysledek;
    vysledek = ;
    return vysledek;
}

// ------


void calc_mediator()
{
    double vysledek;
    vysledek = calc('A', (int)'A');
    if (!idError)
        printf("Chyba ve zpracovani dat. Kod chyby: %d\n", idError);
    else
        printf("Vypocet probehl.\n");
}

// --------------

int calc2(char z1, char *z2)
{
    if (z2 == NULL)
        return 1;

    if (z1 >= 'A' && z1 <= 'Z')
    {
        *z2 = z1 + ('a' - 'A');
        return 0; // ok
    }

    return 2;  // chyba
}


void calc2_mediator1()
{
    char z;

    if (!calc2('A', &z))
        printf("OK.");
    else
    {
        printf("Error:");
    }        
}

void calc2_mediator2()
{
    char z;
    int idError;

    idError = !calc2('A', &z);

    switch (idError)
    {
    case 0:
        printf("OK");
        break;

    case 1:
        printf("Error:%d\n", idError, 
            "Vysledek odkazuje na NULL.\n");
        break;

    case 2:
        printf("Error:%d\n", idError, 
            "Chybny vstupni argument.\n");
        break;
    }
}

// spatne reseni
void calc2_mediator3()
{
    char z;
    !calc2('A', &z);
    printf("OK");
}

// --------------

int main()
{
    std::cout << "Hello World!\n";
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
