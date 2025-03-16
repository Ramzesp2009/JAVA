public class Pair<T> {
    private T value1;
    private T value2;

    public Pair(T _value1, T _value2) {
        value1 = _value1;
        value2 = _value2;
    }

    public boolean areValuesEqual() {
        return value1.equals(value2);
    }
}
