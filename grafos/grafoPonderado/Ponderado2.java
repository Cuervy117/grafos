package grafos.grafoPonderado;
import java.util.ArrayList;
import java.util.List;
import prim.ArbolExpansion;

public class Ponderado2 {
    public static void main(String[] args) {
        
        List<Node> graph = new ArrayList<>();

        addVertex(graph, "A"); // vértice A
        addVertex(graph, "B"); // vértice B
        addVertex(graph, "C"); // vértice C
        addVertex(graph, "D");
        addVertex(graph, "F");
        addVertex(graph, "E");
        addVertex(graph, "G");
        addVertex(graph, "H");

        addEdge(graph, "A", "B", 4);
        addEdge(graph, "A", "F", 2);

        addEdge(graph, "B", "D", 3);
        addEdge(graph, "B", "E", 3);

        addEdge(graph, "F", "C", 3);

        addEdge(graph, "D", "H", 3);
        addEdge(graph, "H", "G", 3);

        addEdge(graph, "C", "D", 2);

        addEdge(graph, "C", "G", 4);

        System.out.println("Vértices: " + getVertices(graph));
        System.out.println("Aristas con peso: " + getEdges(graph));

        List<Edge> arbolExpansion = ArbolExpansion.algoritmoPrim(getNodeById(graph, "A"));
        int mst = 0;
       
        for (Edge arbolExpansion2 : arbolExpansion) {
            mst += arbolExpansion2.getWeight();
        }
        System.out.println("MST " + mst);

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