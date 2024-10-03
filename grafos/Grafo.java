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

        addVertex(graph); // vértice 0
        addVertex(graph); // vértice 1
        addVertex(graph); // vértice 2
        addVertex(graph); // vertice 3

       
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        BusquedaEnProfundidad.dfs(graph, 0, visitados);
        // Imprimir los vértices y las aristas
        for(Integer e : visitados){
            System.out.println(e);
        }
        System.out.println("Vértices: " + getVertices(graph));
        System.out.println("Aristas: " + getEdges(graph));
    }

    // Método para agregar un vértice al grafo
    public static void addVertex(List<List<Integer>> graph) {
        graph.add(new ArrayList<>());
    }

    // Método para agregar una arista al grafo
    public static void addEdge(List<List<Integer>> graph, int vertex1, int vertex2) {
        graph.get(vertex1).add(vertex2);
        graph.get(vertex2).add(vertex1);
    }

    // Método para obtener los vértices del grafo
    public static List<Integer> getVertices(List<List<Integer>> graph) {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            vertices.add(i);
        }
        return vertices;
    }

    // Método para obtener las aristas del grafo
    public static List<String> getEdges(List<List<Integer>> graph) {
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            for (int j : graph.get(i)) {
                if (!edges.contains(j + "-" + i)) {
                    edges.add(i + "-" + j);
                }
            }
        }
        return edges;
    }
}