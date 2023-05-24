
import java.util.*;

public class ServicioBFS {

    private LinkedHashMap<Integer, Boolean> vertices;
    private Grafo<?> grafo;

    public ServicioBFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.vertices = new LinkedHashMap<>();
        Iterator<Integer> iteradorVertices = grafo.obtenerVertices();   //iterador de vertices

        while (iteradorVertices.hasNext()) {
            this.vertices.put(iteradorVertices.next(), false);
        }
    }

    public List<Integer> bfsForest() {

        ArrayList<Integer> res = new ArrayList<>();

        for (Integer v : vertices.keySet()) {
            if (!vertices.get(v))    //si el vertice no fue visitado
                res.addAll(this.bfsForest(v));      //agrega todos los visitados
        }

        return res;
    }

    private ArrayList<Integer> bfsForest(int vertice){

        Queue<Integer> fila = new LinkedList<>();
        ArrayList<Integer> visitados = new ArrayList<>();

        vertices.put(vertice, true);                //cambia a "visitado"
        fila.add(vertice);                          //se agrega el vertice a la fila
        while (!fila.isEmpty()) {                   // Mientras la fila no esté vacia
            int primerVertice = fila.poll();        // Obtiene el primer vertice de la fila y lo remueve
            visitados.add(primerVertice);
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(primerVertice);  // Obtiene los adyacentes del vértice

            if (adyacentes != null) {
                while (adyacentes.hasNext()) {          // Recorre los adyacentes
                    int ady = adyacentes.next();    // Obtiene el adyacente actual

                    if (!vertices.get(ady)) {        // Si no ha sido visitado
                        vertices.put(ady, true);        // Marca el adyacente como visitado
                        fila.add(ady);                  // Agrega el adyacente a la fila
                    }
                }
            }
        }
        return visitados;
    }

}