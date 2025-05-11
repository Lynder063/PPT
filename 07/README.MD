# Třídní Informační Systém

Tento program umožňuje zpracování a správu seznamů studentů ve třídách a jejich známek, včetně výpočtu průměrů a generování přehledů.

## Popis projektu

Program řeší následující úkoly:
1. Načítání seznamů studentů z textových souborů v různých formátech
2. Načítání známek studentů z textových souborů
3. Generování seznamů studentů každé třídy do samostatných souborů
4. Výpočet prospěchu studentů a tříd
5. Export přehledů s výsledky

## Vstupní formáty

Program podporuje tři různé formáty vstupních souborů:

### FORMAT1
```
TRIDA_A
Jan;Novak
Petr;Svoboda
Marie;Novotna

TRIDA_B
Jiri;Marek
Eva;Kralova
```

### FORMAT2
```
TRIDA_A
3
Jan;Novak
Petr;Svoboda
Marie;Novotna

TRIDA_B
2
Jiri;Marek
Eva;Kralova
```

### FORMAT3
```
TRIDA_A
3
Jan
Novak
Petr
Svoboda
Marie
Novotna

TRIDA_B
2
Jiri
Marek
Eva
Kralova
```

## Vstupní formáty známek

Známky jsou zadávány v souboru s pevným pořadím předmětů (MAT, FYZ, IT, CJ, TV). Formát závisí na zvoleném formátu vstupního souboru:

### FORMAT1 a FORMAT2
```
TRIDA_A
1;2;1;3;1
2;3;1;2;1
1;1;1;1;1

TRIDA_B
2;2;3;2;1
1;1;2;2;1
```

### FORMAT3
```
TRIDA_A
3
1
2
1
3
1
2
3
1
2
1
1
1
1
1
1

TRIDA_B
2
2
2
3
2
1
1
1
2
2
1
```

## Použití

Program se spouští z příkazové řádky. Po spuštění budete vyzváni k zadání:
1. Cesty k souboru se seznamy studentů
2. Formátu vstupního souboru (FORMAT1, FORMAT2 nebo FORMAT3)
3. Cesty k souboru se známkami
4. Adresáře pro výstupní soubory se studenty
5. Cesty k výstupnímu souboru s prospěchem

```
java -jar TridniSystem.jar
```

## Architektura projektu

Program je implementován pomocí několika návrhových vzorů:
- **Factory**: Vytváření správných čteček podle formátu vstupního souboru
- **Builder**: Konstrukce třídního systému s kompletní konfigurací
- **Provider/Strategy**: Abstrakce pro různé formáty čtení a zápisu dat

### Hlavní třídy

- `TridniSystem`: Hlavní třída reprezentující systém
- `TridniSystemBuilder`: Builder pro konstrukci třídního systému
- `DataReader`: Rozhraní pro čtení dat
- `DataWriter`: Rozhraní pro zápis dat
- `Trida`: Reprezentace třídy studentů
- `Student`: Reprezentace studenta a jeho známek

## Výstupy

Program generuje dva typy výstupů:
1. Seznam studentů pro každou třídu v samostatném souboru
2. Souhrnný přehled prospěchu studentů a tříd

### Formát seznamu studentů
```
TRIDA_A
3
Jan;Novak
Petr;Svoboda
Marie;Novotna
```

### Formát přehledu prospěchu
```
PROSPĚCH STUDENTŮ A TŘÍD

Třída: TRIDA_A
-----------------------------
Průměry předmětů:
MAT: 1.33
FYZ: 2.00
IT: 1.00
CJ: 2.00
TV: 1.00
Celkový průměr třídy: 1.47

Průměry studentů:
1. Jan Novak: 1.60
2. Petr Svoboda: 1.80
3. Marie Novotna: 1.00

=============================
```

## Ošetření chybových stavů

Program ošetřuje následující chybové stavy:
- Neexistující vstupní soubor
- Nesprávný formát vstupního souboru
- Nekonzistence v počtu studentů a známek
- Neplatné známky

## Rozšiřitelnost

Systém je navržen tak, aby bylo snadné přidat podporu pro další vstupní formáty:
1. Vytvořit novou implementaci rozhraní `DataReader`
2. Přidat nový formát do `DataReaderFactory`