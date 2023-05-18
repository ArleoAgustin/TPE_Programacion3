package TPE_Programacion3.servicios;

import TPE_Programacion3.Arco;
import TPE_Programacion3.Grafo;

import java.lang.reflect.Array;
import java.util.*;

public class ServicioCaminos {

    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;
    private HashMap<Integer, Boolean> vertices;   //vertice y la cantidad de veces

    // Servicio caminos
    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
        this.vertices = new HashMap<>();

        Iterator<Integer> iVertices = grafo.obtenerVertices();   //iterador de vertices
        while (iVertices.hasNext()) {
            int v = iVertices.next();
            this.vertices.put(v, false);
        }
    }

    // Método para obtener todos los posibles caminos desde inicio hasta fin
    public List<List<Integer>> caminos() {

        List<List<Integer>> caminos = new ArrayList<>();
        List<Integer> camino = new ArrayList<>();

        dfs(origen, 0, camino, caminos);
        return caminos;
    }


    // Método auxiliar para realizar la búsqueda en profundidad
    private void dfs(int v, int contArco, List<Integer> camino, List<List<Integer>> caminos) {

        vertices.put(v, true);
        camino.add(v);

        // Si se alcanzó el destino, se agrega el camino a la lista de caminos
        if (v == destino && contArco <= lim) {
            caminos.add(new ArrayList<>(camino));
            contArco = 0;
        } else {
            // Si no se ha alcanzado el destino, se continúa la búsqueda en los vecinos no visitados
            contArco = contArco+1;
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
            if (adyacentes != null) {
                while (adyacentes.hasNext()) {
                    int ady = adyacentes.next();

                    // Verificar si el arco (v, ady) ya ha sido visitado en el camino actual
                    boolean arcoVisitado = false;
                    for (int i = 0; i < camino.size() - 1; i++) {
                        if (camino.get(i) == v && camino.get(i + 1) == ady) {
                            arcoVisitado = true;
                            break;
                        }
                    }

                    if (!arcoVisitado && vertices.get(ady) == false) {
                        dfs(ady, contArco, camino, caminos);
                    }
                }
            }

        }

        // Se elimina el último nodo del camino para explorar otras opciones
        camino.remove(camino.size() - 1);
        vertices.put(v, false);
    }


}
