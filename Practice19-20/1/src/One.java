import java.util.ArrayList;
import java.util.Arrays;

public class One {
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
    }
}