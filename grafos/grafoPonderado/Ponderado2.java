package grafos.grafoPonderado;
import java.util.ArrayList;
import java.util.List;

public class Ponderado2 {
    public static void main(String[] args) {
        
        List<Node> graph = new ArrayList<>();

        addVertex(graph, "A"); // vértice A
        addVertex(graph, "B"); // vértice B
        addVertex(graph, "C"); // vértice C

        addEdge(graph, "A", "B", 4);
        addEdge(graph, "B", "C", 6);

        System.out.println("Vértices: " + getVertices(graph));
        System.out.println("Aristas con peso: " + getEdges(graph));
    }

    private static void addVertex(List<Node> graph, String id) {
        graph.add(new Node(id));
    }

    private static void addEdge(List<Node> graph, String id1, String id2, int weight) {
        Node node1 = getNodeById(graph, id1);
        Node node2 = getNodeById(graph, id2);
        node1.addEdge(node2, weight);
        node2.addEdge(node1, weight);
    }

    private static List<String> getVertices(List<Node> graph) {
        List<String> vertices = new ArrayList<>();
        for (Node node : graph) {
            vertices.add(node.getId());
        }
        return vertices;
    }

    private static List<String> getEdges(List<Node> graph) {
        List<String> edges = new ArrayList<>();
        for (Node node : graph) {
            for (Edge edge : node.getEdges()) {
                Node neighbor = edge.getNode();
                int weight = edge.getWeight();
                if (!edges.contains(node.getId() + "-" + neighbor.getId() + "(" + weight + ")") && !edges.contains(neighbor.getId() + "-" + node.getId() + "(" + weight + ")")) {
                    edges.add(node.getId() + "-" + neighbor.getId() + "(" + weight + ")");
                }
            }
        }
        return edges;
    }

    private static Node getNodeById(List<Node> graph, String id) {
        for (Node node : graph) {
            if (node.getId().equals(id)) {
                return node;
            }
        }
        return null;
    }
}