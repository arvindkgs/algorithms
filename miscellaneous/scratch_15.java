import java.util.LinkedHashMap;
import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("a", ""+1);
        map.put("c", ""+3);
        map.put("b", ""+2);
        map.values().forEach(System.out::println);
    }
}