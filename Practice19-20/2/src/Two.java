import java.util.*;

public class Two {
    public static void main(String[] args) {
        String[] letter = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        Arrays.sort(letter);
        ArrayList<String> arrNumber = new ArrayList<>();
        //одинаковые буквы
        for (String a123 : letter) {
            for (int reg = 1; reg <= 199; reg++) {
                for (int j = 1; j <= 999; j++) {
                    String format = String.format("%s%03d%s%s%d", a123, j, a123, a123, reg);
                    arrNumber.add(format);
                    System.out.println(format);
                }
            }
        }
        //одинаковые цифры
        for (int i = 111; i <= 999; i += 111) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            String format = String.format("%s%03d%s%s%d", a1, i, a2, a3, reg);
                            arrNumber.add(format);
                            System.out.println(format);
                        }
                    }
                }
            }
        }

        System.out.println("----------");

        // Поиски

        // При помощи contains:
        long startTime = System.nanoTime();
        if(arrNumber.contains("Y999YY199")) {
            long finalTime = System.nanoTime() - startTime;
            System.out.println("Found Y999YY199 in ArrayList in " + finalTime + "ns");
        }
        // Бинарный поиск по сортированному листу
        Collections.sort(arrNumber);
        startTime = System.nanoTime();
        int binaryPos = Collections.binarySearch(arrNumber, "Y999YY199");
        long finalTime = System.nanoTime() - startTime;
        System.out.println("Binary search has completed in " + finalTime + "ns");

        // Поиск по Hashset
        Set<String> hasSet = new HashSet<>(arrNumber);
        startTime = System.nanoTime();
        if(hasSet.contains("Y999YY199")) {
            finalTime = System.nanoTime() - startTime;
            System.out.println("Found Y999YY199 in HashSet in " + finalTime + "ns");
        }

        //Поиск по TreeSet
        TreeSet<String> treeSet = new TreeSet<>(arrNumber);
        startTime = System.nanoTime();
        if(treeSet.contains("Y999YY199")) {
            finalTime = System.nanoTime() - startTime;
            System.out.println("Found Y999YY199 in Tree Set in " + finalTime + "ns");
        }
    }
}