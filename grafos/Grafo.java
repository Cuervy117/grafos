package grafos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import busquedas.*;

public class Grafo {
    public static void main(String[] args) {
       
        List<List<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> visitados = new ArrayList<>();

        addVertex(graph); // vértice 1
        addVertex(graph); // vértice 2
        addVertex(graph); // vértice 3
        addVertex(graph); // vertice 3
        addVertex(graph); // vertice 4
        addVertex(graph); // vertice 5
        addVertex(graph); // vertice 6
        addVertex(graph); // vertice 7
        addVertex(graph); // vertice 8
        addVertex(graph); // vertice 9
        addVertex(graph); // vertice 10
        

       
        addEdge(graph, 1, 10);
        addEdge(graph, 1, 3);
        addEdge(graph, 10, 4);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 6);
        addEdge(graph, 10, 9);
        addEdge(graph, 2, 10);
        addEdge(graph, 2, 9);
        addEdge(graph, 9, 6);
        addEdge(graph, 5, 4);
        addEdge(graph, 5, 6);
        addEdge(graph, 5, 7);
        addEdge(graph, 7, 8);
        addEdge(graph, 7, 6);
        System.out.println("Vértices: " + getVertices(graph));
        System.out.println("Aristas: " + getEdges(graph));
        BusquedaEnProfundidad.dfs(graph, 2, visitados);
        // Imprimir los vértices y las aristas
        System.out.println("Visitados: " + visitados.toString());
    }

    // Método para agregar un vértice al grafo
    public static void addVertex(List<List<Integer>> graph) {
        graph.add(new ArrayList<>());
    }

    // Método para agregar una arista al grafo
    public static void addEdge(List<List<Integer>> graph, int vertex1, int vertex2) {
        graph.get(vertex1 - 1).add(vertex2 - 1);
        graph.get(vertex2 - 1).add(vertex1 - 1);
    }

    // Método para obtener los vértices del grafo
    public static List<Integer> getVertices(List<List<Integer>> graph) {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            vertices.add(i + 1);
        }
        return vertices;
    }

    // Método para obtener las aristas del grafo
    public static List<String> getEdges(List<List<Integer>> graph) {
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            for (int j : graph.get(i)) {
                if (!edges.contains((j+1) + "-" + (i+1))) {
                    edges.add((i+1) + "-" + (j+1));
                }
            }
        }
        return edges;
    }
}