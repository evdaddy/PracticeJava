import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
        String csv = "D:\\develop\\IdeaProjects\\JavaAllExercices\\src\\ru\\mirea\\exercies23and24\\1\\src\\main\\resources\\list.csv";
        String[] line;
        int sumBegin = 0;
        int sumOut = 0;
        Map<String, Integer> map = new HashMap<>();
        String csvSplit = ", ";

        CSVReader reader = new CSVReader(new FileReader(csv));
        while((line = reader.readNext()) != null)
        {
            if(line != null)
            {
                String[] str = Arrays.toString(line).split(csvSplit);
                String bank = str[0].replace("[", "");
                String out = str[2].replace("]", "");
                String in = str[1];
                int a = Integer.parseInt(in.trim());
                int b = Integer.parseInt(out.trim());
                sumBegin = sumBegin + a;
                sumOut = sumOut + b;
                if(map.containsKey(bank)) {
                    map.put(bank, map.get(bank) + b);
                }
                else{
                    map.put(bank, b);
                }
            }
        }

        System.out.println("Сумма расходов: = " + sumOut);
        System.out.println("Сумма доходов: = " + sumBegin);
        System.out.println("Сумма расходов по организациям");
        System.out.println(map);
    }
}