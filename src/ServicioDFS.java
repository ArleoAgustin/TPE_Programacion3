import java.util.*;

public class ServicioDFS {

    private HashMap<Integer, String> vertices;
    private Grafo<?> grafo;

    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.vertices = new HashMap<>();
        Iterator<Integer> iteradorVertices = grafo.obtenerVertices();   //iterador de vertices

        while (iteradorVertices.hasNext()) {
            this.vertices.put(iteradorVertices.next(), "Blanco");   //se agregan los vertices en "blanco"
        }
    }

    public List<Integer> dfsForest() {

        List<Integer> recorrido = new ArrayList<>();
        if (!vertices.isEmpty()){
            for (Map.Entry<Integer, String> input : vertices.entrySet()) {
                if (input.getValue().equals("Blanco"))
                    recorrido = dfsForest(input.getKey(), recorrido);
            }
        }
        return recorrido;
    }

    private List<Integer> dfsForest(int v, List<Integer> r){

        vertices.put(v,"Amarillo"); //lo marca como visitado
        r.add(v);
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);  // Obtiene los adyacentes del vértice

        if (adyacentes!= null){
            while (adyacentes.hasNext()) {
                int ady = adyacentes.next();
                if (vertices.get(ady).equals("Blanco")) //si no fue visitado
                    this.dfsForest(ady, r);
            }
        }
        return r;
    }

}
