package busquedas;
import java.util.ArrayList;
import java.util.List;

public class BusquedaEnProfundidad{
    
    public static void dfs(List<List<Integer>> graph, int node, ArrayList<Integer> visitados){
        visitados.add(node); // Marcamos como visitado
        for(Integer adyacentes : graph.get(node)){
            if(!visitados.contains(adyacentes)){ // identificamos si ya existe en la lista de visitados
                BusquedaEnProfundidad.dfs(graph, adyacentes, visitados); // En caso que no, se aplica recursividad sobre ese nodo
            }
        }
    }

}