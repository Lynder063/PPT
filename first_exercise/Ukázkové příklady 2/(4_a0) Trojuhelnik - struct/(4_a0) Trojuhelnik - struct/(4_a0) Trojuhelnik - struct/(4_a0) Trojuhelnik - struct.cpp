// (4_a0) Trojuhelnik - struct.cpp : Tento soubor obsahuje funkci main. Provádění programu se tam zahajuje a ukončuje.
//

#include <iostream>
#include "TTrojuhelnik.h"
#include "TTrojuhelnik_IO.h"

void ukazka_varianta1_a_varianta2()
{
    TTrojuhelnik tr;   // varianta 1, varianta 2 
    double obvod, obsah;
    bool rovnoramenny, rovnostranny;

    // pořízení vstupních dat (načtení dat)    
    nacti_strany_trojuhelnika(&tr);  // varianta 1   
    //tr = nacti_strany_trojuhelnika_2();  // varianta 2

    if (test_trojuhelnik(tr))
    {
        // výpočet
        obvod = spocti_obvod(tr);
        obsah = spocti_obsah(tr);
        rovnoramenny = test_rovnoramenny(tr);
        rovnostranny = test_rovnostranny(tr);

        // zprostředkování výsledku
        tisk_trojuhelnik(tr, obvod, obsah, rovnoramenny, rovnostranny);
    }
    else
        printf("Chyba:Nektera ze stran trojuhelnika je chybne zadana.\n");    
}

void ukazka_varianta3()
{
    TTrojuhelnik* uk_tr;  // varianta 3
    double obvod, obsah;
    bool rovnoramenny, rovnostranny;

    // pořízení vstupních dat (načtení dat)
    uk_tr = nacti_strany_trojuhelnika_2uk();  // varianta 3

    if (test_trojuhelnik(*uk_tr))
    {
        // výpočet
        obvod = spocti_obvod(*uk_tr);
        obsah = spocti_obsah(*uk_tr);
        rovnoramenny = test_rovnoramenny(*uk_tr);
        rovnostranny = test_rovnostranny(*uk_tr);

        // zprostředkování výsledku
        tisk_trojuhelnik(*uk_tr, obvod, obsah, rovnoramenny, rovnostranny);
    }
    else
        printf("Chyba:Nektera ze stran trojuhelnika je chybne zadana.\n");
   
    free(uk_tr); // varianta 3    
}

int main()
{
    ukazka_varianta1_a_varianta2();
    ukazka_varianta3();

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
