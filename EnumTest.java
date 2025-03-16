public class EnumTest {
    public static void main(String[] args) {
        for (FineDirection dir:FineDirection.values()) {
            System.out.printf(
                "%s has %d degrees.\n", dir, dir.getDegrees()
            );
        }
    }
}
