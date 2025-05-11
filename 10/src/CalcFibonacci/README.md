
## O co jde

Tento projekt ukazuje **tři způsoby výpočtu n-tého prvku Fibonacciho posloupnosti**, indexované od 0:

1. `calcNerek(int n)` – **nerekurzivní přístup** (iterativní řešení).
2. `calcRek(int n)` – **rekurzivní přístup** (pomalejší, ukazuje princip).
3. `calcRekTable(int n)` – **dynamické programování** s použitím **tabulky (memoizace)**.

##  Proč tři různé metody?

### 1. Iterativní (`calcNerek`)
- Efektivní a rychlý způsob bez rekurze.
- Paměťově úsporný – používá jen dvě proměnné.

### 2. Rekurzivní (`calcRek`)
- Ukazuje princip, ale je **neefektivní pro větší n** (exponenciální časová složitost).
- Nepoužívá mezipaměť, dochází k opakovanému výpočtu stejných hodnot.

### 3. Dynamické programování (`calcRekTable`)
- **Efektivní kombinace rekurze a mezipaměti (tabulky)**.
- Tabulka ukládá mezivýsledky – **zabraňuje zbytečným výpočtům**.
- Výstup ukazuje stav tabulky v jednotlivých krocích, což usnadňuje sledování výpočtu.

## Co dělá `init()`?
Metoda `init(int n)` inicializuje pole `table`, které slouží jako paměť pro již vypočítané hodnoty Fibonacciho čísel.
- Pole má velikost `n + 1`.
- Hodnoty jsou na začátku nastaveny na `-1`, což značí, že ještě nebyly vypočítány.

## Výhody použití tabulky

- Zrychlení výpočtu – místo exponenciálního času (`O(2^n)`) se dostáváme na **lineární čas** `O(n)`.
- Zabránění opakovaným výpočtům.
- Přehledný záznam průběhu výpočtu.

## 🔍 Ukázka výstupu pro `calcRekTable(5)`

