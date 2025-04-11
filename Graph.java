import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<Integer, T> vertices;

    private List<Edge> edges;

    private int maxIndex = 0;

    public Graph() {
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public Map<Integer, T> getVertices() {
        return this.vertices;
    }

    public T getVertex(int index) {
        if (this.vertices.containsKey(index)) {
            return this.vertices.get(index);
        }
        return null;
    }

    public int addVertex(T vertex) {
        if (!this.vertices.containsValue(vertex)) {
            int index = this.maxIndex;
            this.vertices.put(this.maxIndex++, vertex);
            return index;
        }
        return -1;
    }

    public void addEdge(int from, int to) {
        Edge fromEdge = new Edge(from, to);
        Edge toEdge = new Edge(to, from);
        if (!this.edges.contains(fromEdge)) {
            this.edges.add(fromEdge);
        }
        if (!this.edges.contains(toEdge)) {
            this.edges.add(toEdge);
        }
    }

    public void addEdgeByVertices(T fromVertex, T toVertex) {
        int from = this.getIndexForVertex(fromVertex);
        if (from == -1) {
            from = this.addVertex(fromVertex);
        }
        int to = this.getIndexForVertex(toVertex);
        if (to == -1) {
            to = this.addVertex(toVertex);
        }
        this.addEdge(from, to);
    }

    public int getIndexForVertex(T vertex) {
        if (!this.vertices.containsValue(vertex)) {
            return -1;
        }
        for (Map.Entry<Integer, T> entry:this.vertices.entrySet()) {
            if (entry.getValue().equals(vertex)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public List<Edge> getEdgesFromVertex(T vertex) {
        List<Edge> result = new ArrayList<>();
        int index = this.getIndexForVertex(vertex);
        if (index > -1) {
            for (Edge edge:this.edges) {
                if (edge.getFrom() == index) {
                    result.add(edge);
                }
            }
        }
        return result;
    }

    public List<T> getNeighbours(T vertex) {
        List<T> result = new ArrayList<>();
        for (Edge edge:this.getEdgesFromVertex(vertex)) {
            result.add(this.vertices.get(edge.getTo()));
        }
        return result;
    }

    public void removeEdge(Edge edge) {
        Edge reverse = new Edge(edge.getTo(), edge.getFrom());
        this.edges.remove(edge);
        this.edges.remove(reverse);
    }

    public void removeVertex(T vertex) {
        int index = this.getIndexForVertex(vertex);
        if (index > -1) {
            List<Edge> edges = this.getEdgesFromVertex(vertex);
            for (Edge edge:edges) {
                this.removeEdge(edge);
            }
            this.vertices.remove(index);
        }
    }
}
