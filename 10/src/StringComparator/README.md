# Porovnání řetězců v Javě

## Cíl

Implementovat vlastní metodu pro lexikografické porovnání dvou řetězců bez použití vestavěných metod jako `equals()` nebo `compareTo()`.

## Soubor `StringUtils.java`

Obsahuje metodu `customCompare`, která:

- Porovnává dva řetězce znak po znaku.
- Vrací:
    - `0` pokud jsou řetězce stejné.
    - `-1` pokud je první řetězec lexikograficky menší.
    - `1` pokud je první řetězec lexikograficky větší.

## Testování

Soubor `StringUtilsTest.java` obsahuje metodu `main`, která testuje `customCompare` na různých dvojicích řetězců, včetně:

- `"ABCDEF"` vs `"ABCD"` → očekáváno `1`
- `"ABCD"` vs `"ABCDEF"` → očekáváno `-1`
- `"ABCD"` vs `"ABCD"` → očekáváno `0`
- `"ABCD"` vs `"ABCE"` → očekáváno `-1`
- `"ABCE"` vs `"ABCD"` → očekáváno `1`

