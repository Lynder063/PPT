// (4_a) Trojuhelnik - struct.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#include <iostream>
#include "TTrojuhelnik.h"

int main()
{
    TTrojuhelnik tr;

    // pořízení vstupních dat (načtení dat)
    nacti_strany_trojuhelnika(&tr);   // ukazatel == adresa pameti

    if (test_trojuhelnik(tr))
    {
        // výpočet
        spocti_trojuhelnik(&tr);

        // zprostředkování výsledku
        tisk_trojuhelnik(tr);
    }
    else
        printf("Chyba:Nektera ze stran trojuhelnika je chybne zadana.\n");

    system("PAUSE");
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
