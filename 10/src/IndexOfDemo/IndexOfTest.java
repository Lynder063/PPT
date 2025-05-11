package IndexOfDemo;

import java.util.ArrayList;

public class IndexOfTest {
    public static void main(String[] args) {
        // Test 1: První výskyt prvku
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("B");
        System.out.println("Index of 'B' in list1: " + list1.indexOf("B")); // Očekáváno: 1

        // Test 2: Prvek neexistuje
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("X");
        list2.add("Y");
        list2.add("Z");
        System.out.println("Index of 'A' in list2: " + list2.indexOf("A")); // Očekáváno: -1

        // Test 3: Prázdný seznam
        ArrayList<String> list3 = new ArrayList<>();
        System.out.println("Index of 'A' in list3: " + list3.indexOf("A")); // Očekáváno: -1

        // Test 4: Prvek je null
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("A");
        list4.add(null);
        list4.add("B");
        System.out.println("Index of null in list4: " + list4.indexOf(null)); // Očekáváno: 1

        // Test 5: Více výskytů prvku
        ArrayList<String> list5 = new ArrayList<>();
        list5.add("D");
        list5.add("E");
        list5.add("D");
        list5.add("F");
        System.out.println("Index of 'D' in list5: " + list5.indexOf("D")); // Očekáváno: 0
    }
}
