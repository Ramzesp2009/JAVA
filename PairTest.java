public class PairTest {
    public static <T> void printEqual(Pair<T> pair, String title) {
        if (pair.areValuesEqual()) {
            System.out.println("Gleiches Paar in " + title);
        } else {
            System.out.println("Ungleiches Paar in " + title);
        }
    }

    public static void main(String[] args) {
        Pair<Integer> pair1 = new Pair<>(5,5);
        PairTest.printEqual(pair1, "pair1");
        Pair<String> pair2 = new Pair<>("Hallo", "Hallo");
        PairTest.printEqual(pair2, "pair2");
    }
}
