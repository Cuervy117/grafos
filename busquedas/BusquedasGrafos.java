package busquedas;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BusquedasGrafos{
    
    public static void dfs(List<List<Integer>> graph, int node, ArrayList<Integer> visitados){
        visitados.add(node); // Marcamos como visitado
        for(Integer adyacentes : graph.get(node)){
            if(!visitados.contains(adyacentes)){ // identificamos si ya existe en la lista de visitados
                BusquedasGrafos.dfs(graph, adyacentes, visitados); // En caso que no, se aplica recursividad sobre ese nodo
            }
        }
    }
    public static List<Integer> busquedaExpansion(List<List<Integer>> grafo, int verticeInicial){
        // Se inicializan las listas que utilizaremos
        Queue<List<Integer>> queue = new LinkedList<>();
        
        List<Integer> visitados = new ArrayList<>(); //Para guardar nodos adyacentes

        List <Integer> nodo = grafo.get(verticeInicial);
        System.out.println();
        queue.add(nodo); // Se agrega el nodo inicial
        visitados.add(verticeInicial); //Se marca ese nodo como visitado
        while (!queue.isEmpty()) {
            List <Integer> v = queue.poll(); // Se almacena el nodo y se desencola
            for(Integer w : v){
                if(!visitados.contains(w)){ // Si w no está marcado como visitado...
                    queue.add(grafo.get(w));
                    visitados.add(w);
                } 
            }
        }
        return visitados;
    }

}