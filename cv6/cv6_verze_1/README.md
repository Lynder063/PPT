# Popis programu

- Program implementuje třídu Faktura a další pomocné třídy, které spolu tvoří kompletní reprezentaci faktury. Využil jsem princip kompozice, kdy třída Faktura obsahuje reference na další objekty (`Prijemce`, `CastkyDokladu`, `Sazba`). Toto je správný objektově orientovaný přístup - každá třída má svou jasně definovanou zodpovědnost.

## Hlavní vlastnosti implementace

- Nemutovatelnost objektů - Všechny třídy jsou implementovány jako immutable (neměnitelné). Proto mají všechny atributy modifikátor final a nejsou k dispozici žádné settery, což zajišťuje, že údaje na faktuře nelze měnit po vytvoření, jak bylo požadováno v zadání.
- Zapouzdření - Všechny atributy jsou privátní a přístup k nim je umožněn pouze přes gettery.
- Kompozice - Třída Faktura obsahuje objekty jiných tříd (`Prijemce`, `CastkyDokladu`), což je příklad kompozice objektů.
- Automatický výpočet - Třída `CastkyDokladu` automaticky vypočítá cenu s DPH na základě ceny bez DPH a sazby.
- Formátování - Metoda `toString()` je přepsána ve všech třídách pro pěkný a přehledný výpis.

## Testovací případy
- V testovací třídě `FakturaTest` jsou implementovány tři základní testy:
  - Vytvoření standardní faktury - Testuje vytvoření a výpis faktury se základní sazbou DPH.
  - Faktura s nulovou hodnotou - Testuje, zda funguje korektně faktura s nulovou částkou.
  - Faktura se sníženou sazbou DPH - Testuje použití jiné sazby DPH.
  - Testy vypíšou výsledné faktury na standardní výstup, takže můžete zkontrolovat jejich správnost pohledem.