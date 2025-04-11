// import java.util.Deque;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Set;
// import java.util.HashSet;
import java.util.Map;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;


public class PathSearch {
    public static <T> WeightedNode<T> astar(T start, PathSearchable<T> searchable) {
        PriorityQueue<WeightedNode<T>> frontier = new PriorityQueue<>();

        frontier.offer(
            new WeightedNode<T>(start, null, 0.0, searchable.heuristic(start))
            );

        Map<T, Double> visited = new HashMap<>();
        visited.put(start, 0.0);

        while (frontier.size() > 0) {
            WeightedNode<T> node = frontier.poll();

            if (searchable.isGoal(node.getState())) {
                return node;
            }

            for (T child:searchable.successors(node.getState())) {
                double childCost = node.getCost() + 1;

                if (visited.containsKey(child) && 
                    visited.get(child) <= childCost) {
                    continue;
                }

                visited.put(child, childCost);
                frontier.offer(
                    new WeightedNode<T>(
                        child, node, childCost, searchable.heuristic(child)
                    )
                );
            }
        }
        return null;
    }

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
            for (T child: searchable.successors(node.getState())) {
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
