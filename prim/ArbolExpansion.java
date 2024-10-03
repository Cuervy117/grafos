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
        arbolExpansion.add(desencolada); // Se añade al M.S.T. la arista del nodo inicial que tenga menor peso para continuar con toda la ejecución del algoritmo
        // Se analiza si el nodo ha sido marcado como visitado y de ser así, la arista desencolada se ignora
        Node siguiente = desencolada.getNode();
        while(!colaPrioridad.isEmpty()){
            siguiente = desencolada.getNode();

            if(!visitados.contains(siguiente)){ // Si el nodo siguiente no está marcado como visitado
                siguiente.getEdges().forEach(arista ->{
                    if(!visitados.contains(arista.getNode())){ //Si no está marcado como visitado, entonces se agrega
                        colaPrioridad.add(arista);
                    }
                }); //Sus aristas se encolan
                visitados.add(siguiente); // Se marca como visitado

                desencolada = colaPrioridad.poll();
                if(!visitados.contains(desencolada.getNode())){
                    arbolExpansion.add(desencolada);
                }
                                
            }else{
                colaPrioridad.poll();
            }
            
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
        return arbolExpansion;   
    }
    
}
