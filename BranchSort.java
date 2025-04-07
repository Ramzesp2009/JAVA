// import java.util.List;
import java.util.ArrayList;

public class BranchSort<T extends Comparable<? super T>> {
    private Branch<T> root = null;

    public Branch<T> getRoot() {
        return root;
    }

    public void addValue(T value) {
        if (root == null) {
            root = new Branch<>(value);
        } else {
            recursiveInsert(root, value);
        }
    }

    private void recursiveInsert(Branch<T> branch, T value) {
        if (value.compareTo(branch.getValue()) <= 0) {
            if (branch.getLeft() != null) {
                recursiveInsert(branch.getLeft(), value);
                return;
            }

            Branch<T> newBranch = new Branch<>(value);
            branch.setLeft(newBranch);
            return;
        } else {
            if (branch.getRight() != null) {
                recursiveInsert(branch.getRight(), value);
                return;
            }
            Branch<T> newBranch = new Branch<>(value);
            branch.setRight(newBranch);
            return;
        }
    }

    public ArrayList<T> getSorted() {
        ArrayList<T> sorted = new ArrayList<>();
        recursiveRead(root, sorted);
        return sorted;
    }

    private void recursiveRead(Branch<T> branch, ArrayList<T> list) {
        if (branch.getLeft() != null) {
            recursiveRead(branch.getRight(), list);
        }
    }
}
