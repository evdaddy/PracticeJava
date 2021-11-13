import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Two {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("([a-f]+[A-F]+:){3}+([0-9]{2}+:){2}+[0-9]{2}");

        String str  = "aE:dC:cA:56:76:54";
        System.out.println(str + ": " + p1.matcher(str).matches());

        str  = "01:23:45:67:89:Az";
        System.out.println(str + ": " + p1.matcher(str).matches());
    }
}