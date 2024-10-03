package grafos.grafoPonderado;

import java.util.List;
import java.util.ArrayList;

public class Node {
    private String id;
    private List<Edge> edges;

    public Node(String id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public void addEdge(Node node, int weight) {
        edges.add(new Edge(node, weight));
    }
}
