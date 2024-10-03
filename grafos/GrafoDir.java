package grafos;
import java.util.ArrayList;

public class GrafoDir {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> adjList;

    public GrafoDir(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<ArrayList<Integer>>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            this.adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int src, int dest) {
        this.adjList.get(src).add(dest);
    }

    public void addVertex(){
        this.adjList.add(new ArrayList<Integer>());
        this.numVertices++;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoDir g = new GrafoDir(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);


        g.printGraph();
    }
}