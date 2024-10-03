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
    public static List <Edge> algoritmoPrim(Node nodoInicial){
        PriorityQueue <Edge> colaPrioridad = new PriorityQueue<>((e1, e2)-> Integer.compare(e1.getWeight(), e2.getWeight())); //Utiliza el comparator para ordenar según costos de arista ops
        List <Edge> arbolExpansion = new ArrayList<>(); // El arbol de expansión es una lista de aristas
        List <Node> visitados = new ArrayList<>(); // El arbol de expansión es una lista de aristas
        
        // Con el nodo inicial, se obtienen sus aristas y se encolan en la colaPrioridad
        nodoInicial.getEdges().forEach(arista -> colaPrioridad.add(arista));
        visitados.add(nodoInicial); // Se marca como visitado el nodo inicial

        // Esas aristas se desencolan y se almacenan en el arbol de Expansion
        Edge desencolada = colaPrioridad.poll();
        arbolExpansion.add(desencolada); // Se añade al M.S.T. para continuar con toda la ejecución del algoritmo
        
        // Se analiza si el nodo ha sido marcado como visitado y de ser así, la arista desencolada se ignora
        
        while(!colaPrioridad.isEmpty()){
            Node siguiente = desencolada.getNode();
            siguiente.getEdges().forEach(arista -> colaPrioridad.add(arista));
            if(!visitados.contains(siguiente)){ // Si el nodo no está marcado como visitado
                siguiente.getEdges().forEach(arista -> colaPrioridad.add(arista));
            }else{
                
            }
            
        }
        
        return arbolExpansion;
                
   }
    
}
