# Histogram znaků v textu

Projekt pro analýzu a vizualizaci histogramů znaků v textech. Implementováno v Javě s využitím objektově orientovaného přístupu.

## 🚀 Funkce

Projekt implementuje tři typy histogramů:
- **Case-Insensitive** - počítá výskyty písmen bez rozlišení velkých a malých písmen
- **Case-Sensitive** - počítá výskyty písmen s rozlišením velkých a malých písmen
- **Case-Insensitive with Unrecognized** - počítá výskyty písmen bez rozlišení velikosti, se zvláštní kategorií pro nealfabetické znaky

## 📋 Požadavky

- Java 8 nebo novější
- JUnit 5 (pro spuštění testů)
- IntelliJ IDEA (doporučeno)

## 🏗️ Struktura projektu

```
src/
├── main/java/
│   ├── histogram/
│   │   ├── HistogramAnalyzer.java         // Rozhraní pro analyzátory histogramů
│   │   ├── HistogramResult.java           // Třída pro uchování výsledků
│   │   ├── CaseInsensitiveHistogram.java  // Implementace bez rozlišení velikosti
│   │   ├── CaseSensitiveHistogram.java    // Implementace s rozlišením velikosti
│   │   ├── CaseInsensitiveWithUnrecognizedHistogram.java  // Implementace s nerozpoznanými znaky
│   │   └── HistogramProvider.java         // Provider pro zpracování a zobrazení
│   └── Main.java                          // Hlavní třída pro demonstraci
└── test/java/
    └── histogram/
        └── HistogramTest.java             // Jednotkové testy
```

## 🛠️ Instalace a spuštění

### Klonování repozitáře
```bash
git clone https://github.com/vas-uzivatelske-jmeno/text-histogram.git
cd text-histogram
```

### Kompilace a spuštění
```bash
# Kompilace projektu
javac -d out src/main/java/*.java src/main/java/histogram/*.java

# Spuštění aplikace
java -cp out Main
```

### Spuštění v IntelliJ IDEA
1. Otevřete projekt v IntelliJ IDEA
2. Klikněte pravým tlačítkem na `Main.java`
3. Vyberte "Run 'Main.main()'"

## 🧪 Testování

```bash
# Spuštění testů
java -cp "out:lib/junit-platform-console-standalone-1.8.1.jar" org.junit.platform.console.ConsoleLauncher --scan-classpath
```

Nebo v IntelliJ IDEA:
1. Klikněte pravým tlačítkem na `HistogramTest.java`
2. Vyberte "Run 'HistogramTest'"

## 📝 Dokumentace

### Hlavní komponenty

#### HistogramAnalyzer
Rozhraní definující metody pro analýzu textu a vytvoření histogramu.

```java
public interface HistogramAnalyzer {
    HistogramResult analyze(String text);
    String getHistogramType();
}
```

#### HistogramResult
Třída uchovávající výsledky histogramu.

```java
public class HistogramResult {
    private Map<String, Integer> histogram;
    private String histogramType;
    private int totalCharacters;
    
    // Konstruktor a metody...
}
```

#### HistogramProvider
Provider pro zpracování a zobrazení výsledků.

```java
public class HistogramProvider {
    public HistogramResult process(String text, HistogramAnalyzer analyzer) {  }
    public void displayResults(HistogramResult result) { }
}
```

## 🔄 Proces refaktorizace

1. **Původní implementace:**
    - Jednoduchá metoda pro počítání znaků
    - Bez možnosti různých typů histogramů
    - Bez strukturovaného uchování výsledků

2. **Refaktorizace:**
    - Zavedení rozhraní `HistogramAnalyzer` pro různé implementace
    - Vytvoření třídy `HistogramResult` pro uchování a přenos výsledků
    - Implementace různých strategií analýzy
    - Oddělení zpracování a zobrazení do třídy `HistogramProvider`
    - Přidání jednotkových testů

## 📊 Příklad výstupu

```
Analyzuji text: Hello World! 123 This is a sample text for histogram analysis.

=== Case-Insensitive Histogram ===
Celkový počet zpracovaných znaků: 47
Histogram:
a: 5
d: 1
e: 3
...

=== Case-Sensitive Histogram ===
Celkový počet zpracovaných znaků: 47
Histogram:
H: 1
T: 1
...

=== Case-Insensitive with Unrecognized Histogram ===
Celkový počet zpracovaných znaků: 52
Histogram:
a: 5
...
unrecognized: 5
...
```