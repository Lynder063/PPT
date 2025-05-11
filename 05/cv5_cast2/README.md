# Vysvětlení implementace
## Program je rozdělen do několika vrstev podle zadání
### Datová vrstva

- `NacteniDat_DataKvadratickeRovnice` - abstraktní třída pro načítání dat
- `NacteniDatCSV_DataKvadratickeRovnice` - konkrétní implementace načítání dat z CSV
- `VystupData_DataKvadratickeRovnice` - abstraktní třída pro výstup dat
- `VystupDataCSV_DataKvadratickeRovnice` - konkrétní implementace výstupu dat do CSV

### Logická vrstva:
- `KvR` - třída reprezentující kvadratickou rovnici
- `SpoctiYKvR` - třída pro výpočet hodnot
- `Provider` - třída zpracovávající data, koordinuje načítání, výpočet a výstup

### Builder:

- `Builder` - třída poskytující metodu pro vytvoření Provider objektu

### Hlavní třída:

- `Main` - obsahuje metodu main, která spouští program

### Popis funkčnosti programu

- Program načte jméno vstupního souboru z parametrů nebo od uživatele
- Vytvoří `Provider` pomocí `Builder` třídy
- Provider načte data ze vstupního souboru
- Pokud vstupní soubor neexistuje, požádá uživatele o zadání nového jména souboru

### Provede výpočty pro každý řádek dat:

- Parsuje koeficienty `a`, `b`, `c`
- Vytvoří objekt `KvR`
- Pro každé x spočítá y pomocí `SpoctiYKvR`
- Sestaví výstupní řádek ve formátu `a;b;c;x1;x2;...`


- Zapíše výsledky do výstupního souboru

Ošetření chybových stavů
Program ošetřuje následující chybové stavy:

Špatný formát dat ve vstupním souboru
Neexistující vstupní soubor (program se zeptá na nový název)
Chyby při zápisu do výstupního souboru

### Jak program spustit

Zkompilujte všechny Java soubory:
```java
javac *.java
```
#### Spusťte program:
```java
java Main
```

nebo s názvem vstupního souboru jako parametrem:
```java
java Main vstup.csv
```

Program zpracuje vstupní soubor a vytvoří výstupní soubor s výsledky

Formát vstupního souboru
Vstupní soubor by měl být ve formátu CSV s oddělovačem ;:
a1;b1;c1;x1
a2;b2;c2;x1;x2;x3
...
Kde:

a, b, c jsou koeficienty kvadratické rovnice y = ax² + bx + c
x1, x2, ... jsou hodnoty x, pro které se mají vypočítat hodnoty y

Formát výstupního souboru
Výstupní soubor bude ve formátu:
a1;b1;c1;x1:y1
a2;b2;c2;x1:y1;x2:y2;x3:y3
...
Kde:

a, b, c jsou koeficienty kvadratické rovnice
x jsou dvojice hodnot x a k nim vypočtených hodnot y

Program je navržen tak, aby byl snadno rozšiřitelný - můžete jednoduše přidat nové implementace načítání a výstupu dat (např. pro XML, JSON nebo databázi) bez nutnosti měnit logickou vrstvu.2 / 2RetryClaude does not have the ability to run the code it generates yet.Claude can make mistakes. Please double-check responses.