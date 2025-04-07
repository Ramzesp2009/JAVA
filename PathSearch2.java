import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PathSearch2 {
    public static <T> Node<T> bfs(T start, PathSearchable<T> searchable) {
        Deque<Node<T>> frontier = new LinkedList<>();
        frontier.addLast(new Node<T>(start));
        Set<T> visited = new HashSet<>();
        visited.add(start);

        while (frontier.size() > 0) {
            Node<T> node = frontier.removeFirst();
            if (searchable.isGoal(node.getState())) {
                return node;
            }
            for (T child: searchable.successors(node.getState())) {
                if (visited.contains(child)) {
                    continue;
                }
                visited.add(child);
                frontier.addLast(new Node<T>(child, node));
            }
        }
        return null;
    }
}
