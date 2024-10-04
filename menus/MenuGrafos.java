package menus;

import busquedas.BFS;
import grafos.Grafo;
import grafos.GrafoDir;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuGrafos {
    public static void menuGrafoDir(Scanner sc, int numero_De_Nodos){
        GrafoDir grafo = new GrafoDir(numero_De_Nodos);
        System.out.println("Has creado un grafo dirigido, decide lo que haras a continacion");
        int opcion;
        do{
            System.out.println("1   --- Agregar un nodo");
            System.out.println("2   --- Conectar nodos");
            System.out.println("3   --- Mostrar grafo");
            System.out.println("4   --- Salir");
            opcion = Integer.parseInt(sc.nextLine());
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(opcion){
                case 1 -> {
                    grafo.addVertex();
                    System.out.println("Se ha agregado un nuevo nodo");
                }
                case 2 -> {
                    System.out.println("Ingresa el nodo origen, seguido del nodo destino");
                    grafo.addEdge(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
                }
                case 3 -> {
                    grafo.printGraph();
                }
                case 4 -> {
                    if(!Menu.mostrar_Advertencia(sc)) opcion = 5;
                }
            }
        }while(opcion != 4);
    }

    public static void menuGrafo(Scanner sc){
        List<List<Integer>> grafo = new ArrayList<>();
        System.out.println("Has creado un grafo no dirigido, decide lo que haras a continacion");
        int opcion;
        do{
            System.out.println("1   --- Agregar un nodo");
            System.out.println("2   --- Conectar nodos");
            System.out.println("3   --- Mostrar grafo");
            System.out.println("5   --- Busqueda por Expansión");
            System.out.println("6   --- Busqueda por Profundidad");
            System.out.println("7   --- Salir");
            opcion = Integer.parseInt(sc.nextLine());
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(opcion){
                case 1 -> {
                    Grafo.addVertex(grafo);
                    System.out.println("Se ha agregado un nuevo nodo");
                }
                case 2 -> {
                    System.out.println("Ingresa los nodos que deseas conectar");
                    System.out.println("Considera que los nodos inician desde 0");
                    Grafo.addEdge(grafo, Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
                }
                case 3 -> {
                    System.out.println("Vertices : " + Grafo.getVertices(grafo));
                    System.out.println("Aristas : " + Grafo.getEdges(grafo));
                }
                case 4 -> {
                    System.out.println("Has elegido buscar por BFS...");
                    System.out.println("Lista de visitados por BFS: " + BFS.busquedaExpansion(grafo, opcion));
                }
                case 7 -> {
                    if(!Menu.mostrar_Advertencia(sc)) opcion = 5;
                }
            }
        }while(opcion != 7);
    }
}
