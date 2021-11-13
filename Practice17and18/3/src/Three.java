import java.util.regex.*;
import javax.swing.JOptionPane;


public class Three {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("(((\\d\\d)(.\\d\\d))|(\\d\\d))( )((USD)|(RUB)|(EU))");

        String str  = "22 UDD, 0.002 USD";
        System.out.println(str + ": " + p1.matcher(str).matches());

        str = "23.78 USD";
        System.out.println(str + ": " + p1.matcher(str).matches());
    }
}