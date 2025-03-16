import java.util.Map;
import java.util.HashMap;


public class WesterosTest {
    public static void main(String[] args) {
        Map<String, Direction> locations = new HashMap<>();
        locations.put("The Wall", Direction.NORTH);
        locations.put("Vale of Arrum", Direction.EAST);
        locations.put("Dorne", Direction.SOUTH);
        locations.put("Iron Islands", Direction.WEST);
        for (Map.Entry<String, Direction> entry:locations.entrySet()) {
            System.out.printf(
                "%s is in the %s.\n",
                entry.getKey(),
                entry.getValue()
            );
        // System.out.println(locations);
        }
    }
}
