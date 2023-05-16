package TPE_Programacion3.servicios;

import TPE_Programacion3.Grafo;

import java.util.*;

public class ServicioBFS {

    HashMap<Integer, Boolean> vertices = new HashMap<>();

    private Grafo<?> grafo;

    public ServicioBFS(Grafo<?> grafo) {
        this.grafo = grafo;

        Iterator<Integer> vertices = grafo.obtenerVertices();   //iterador de vertices
        while (vertices.hasNext()) {
            this.vertices.put(vertices.next(), false);
        }
    }

    public List<Integer> bfsForest() {

        ArrayList<Integer> res = new ArrayList<>();

        for (Integer v : vertices.keySet()) {

            if (vertices.get(v).booleanValue() == false)    //si el vertice no fue visitado
                res.addAll(this.bfsForest(v));      //agrega todos los visitados
        }

        return res;
    }

    private ArrayList<Integer> bfsForest(int vertice){
        
        Queue<Integer> fila = new LinkedList<>();
        ArrayList<Integer> visitados = new ArrayList<>();

        vertices.put(vertice, true);                //cambia a "visitado"
        fila.add(vertice);                          //se agrega el vertice a la fila
        while (!fila.isEmpty()) {                   // Mientras la fila no esté vacía
            int primerVertice = fila.poll();        // Obtiene el primer vértice de la fila y lo remueve
            visitados.add(primerVertice);
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(primerVertice);  // Obtiene los adyacentes del vértice

            while (adyacentes.hasNext()) {          // Recorre los adyacentes
                Integer ady = adyacentes.next();    // Obtiene el adyacente actual

                if (vertices.get(ady).booleanValue() == false) {        // Si no ha sido visitado
                    vertices.put(ady, true);        // Marca el adyacente como visitado
                    fila.add(ady);                  // Agrega el adyacente a la fila
                }
            }
        }
        return visitados;
    }

}