package menus;

import java.util.Scanner;
import grafos.GrafoDir;
import grafos.Grafo;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("4   --- Salir");
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
                    Grafo.addEdge(grafo, Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
                }
                case 3 -> {
                    System.out.println("Vertices : " + Grafo.getVertices(grafo));
                    System.out.println("Aristas : " + Grafo.getEdges(grafo));
                }
                case 4 -> {
                    if(!Menu.mostrar_Advertencia(sc)) opcion = 5;
                }
            }
        }while(opcion != 4);
    }
}
