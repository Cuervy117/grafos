package busquedas;
import java.util.ArrayList;
import java.util.List;

public class BusquedaEnProfundidad{
    
    public static void dfs(List<List<Integer>> graph, int node, ArrayList<Integer> visitados){
        visitados.add(node); // Marcamos como visitado
        List<Integer> adyacentesAux =  graph.get(node - 1);
        adyacentesAux.sort(null);
        for(Integer adyacentes : adyacentesAux){
            if(!visitados.contains(adyacentes + 1)){ // identificamos si ya existe en la lista de visitados
                BusquedaEnProfundidad.dfs(graph, (adyacentes + 1), visitados); // En caso que no, se aplica recursividad sobre ese nodo
            }
        }
    }
}