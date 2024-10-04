/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prim;
import grafos.grafoPonderado.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 *
 * @author PCPUMA2
 */
public class ArbolExpansion {
    public static List<Edge> primAlgoritmo(Node nodoInicial) {
        PriorityQueue<Edge> colaPrioridad = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getWeight(), e2.getWeight())); //Con el comparator ordena las prioridades según el peso
        // Lista para el árbol de expansión
        List<Edge> arbolExpansion = new ArrayList<>();
        // Lista para rastrear nodos visitados
        List<Node> visitados = new ArrayList<>();
    
        visitados.add(nodoInicial); //Se marca como visitado
        colaPrioridad.addAll(nodoInicial.getEdges()); // Se añaden todas sus aristas del nodo
    
        // Mientras haya aristas en la cola de prioridad
        while (!colaPrioridad.isEmpty()) {
            Edge desencolada = colaPrioridad.poll(); //Se desencola la arista de menor peso...
            Node siguiente = desencolada.getNode();  //Se obtiene su nodo siguiente
    
            // Si el nodo conectado ya ha sido visitado, ignoramos esta arista
            if (visitados.contains(siguiente)) {
                continue; // Saltamos todo el proceso que resta y continuamos con la siguiente iteración
            }
            //De otro modo...
            // Agregamos la arista al árbol de expansión
            arbolExpansion.add(desencolada);
            visitados.add(siguiente); // Se marca como visitado
    
            // Añadimos las aristas del nuevo nodo visitado a la cola de prioridad
            siguiente.getEdges().forEach(arista -> {
                // Solo añadimos aristas que conectan a nodos no visitados
                if (!visitados.contains(arista.getNode())) {
                    colaPrioridad.add(arista); 
                }
            });
        }
        System.out.println(nodoInicial.getId() + " - " + arbolExpansion.get(0).getNode().getId() +" "+  arbolExpansion.get(0).getWeight());
        arbolExpansion.forEach(arista -> {
            Node destino = arista.getNode();
            destino.getEdges().forEach(origen -> {
                if (arbolExpansion.contains(origen)) {
                    System.out.println(destino.getId() + " - " + origen.getNode().getId() + " " + origen.getWeight());
                }
            });
        });
        // Devolvemos el árbol de expansión
        return arbolExpansion;
    }
    
    
}
