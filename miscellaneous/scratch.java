import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Scratch {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("\\d+$");
    Matcher m1 = p.matcher("asdvm");
    System.out.println(m1.find());
    System.out.println(m1.group());
  }
}