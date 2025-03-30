import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;


public class PathSearch {
    public static <T> Node<T> dfs(T start, PathSearchable<T> searchable) {
        Deque<Node<T>> frontier = new LinkedList<>();
        frontier.addFirst(new Node<T>(start));
        Set<T> visited = new HashSet<>();
        visited.add(start);
        while (frontier.size() > 0) {
            Node<T> node = frontier.removeFirst();
            if (searchable.isGoal(node.getState())) {
                return node;
            }
            for (T child:searchable.successors(node.getState())) {
                if (visited.contains(child)) {
                    continue;
                }
                visited.add(child);
                frontier.addFirst(new Node<T>(child, node));
            }
        }
        return null;
    }
}
