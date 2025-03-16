import java.util.Set;
import java.util.HashSet;


public class SetTest {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Hallo");
        stringSet.add("Welt");
        stringSet.add("Welt");
        for (String str:stringSet) {
            System.out.println(str);
        }
    }
}
