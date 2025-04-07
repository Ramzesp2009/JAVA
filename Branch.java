public class Branch<T extends Comparable<? super T>> {
    private T value;
    private Branch<T> left = null;
    private Branch<T> right = null;

    public Branch(T value) {
        this.value = value;
    }

    public Branch(T value, Branch<T> left, Branch<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(Branch<T> left) {
        this.left = left;
    }

    public void setRight(Branch<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public Branch<T> getLeft() {
        return left;
    }

    public Branch<T> getRight() {
        return right;
    }

    public void print() {
        this.print(this, 0);
    }

    private void print(Branch<T> current, int indentation) {
        if (current.getRight() != null) {
            this.print(current.getRight(), indentation + 4);
        }

        for (int i = 0; i < indentation; i++) {
            System.out.print(" ");
        }
        System.out.println(current.getValue());
        if (current.getLeft() != null) {
            this.print(current.getLeft(), indentation + 4);
        }
    }
}
