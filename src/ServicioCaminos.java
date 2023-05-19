import java.util.*;

public class ServicioCaminos {

    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;
    private HashMap<Integer, Boolean> vertices;
    private List<List<Integer>> caminos;

    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
        this.vertices = new HashMap<>();
        this.caminos = new ArrayList<>();
        Iterator<Integer> iVertices = grafo.obtenerVertices();   //iterador de vertices
        while (iVertices.hasNext()) {
            this.vertices.put(iVertices.next(), false);
        }
    }

//retorna la lista de caminos
    public List<List<Integer>> caminos() {

        List<Integer> camino = new ArrayList<>();
        dfs(origen, 0, camino);
        return caminos;
    }


    private void dfs(int v, int contArco, List<Integer> camino) {

        vertices.put(v, true);
        camino.add(v);

        // si se alcanzo el destino, se agrega el camino a la lista de caminos
        if (v == destino && contArco <= lim) {
            caminos.add(new ArrayList<>(camino));
            contArco = 0;
        } else {
            // si no se ha alcanzado el destino, se continua la busqueda en los adyacentes
            contArco = contArco+1;
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
            if (adyacentes != null) {
                while (adyacentes.hasNext()) {
                    int ady = adyacentes.next();
                    boolean arcoVisitado = false;   // verifica si el arco ya ha sido visitado en el camino actual
                    for (int i = 0; i < camino.size() - 1; i++) {
                        if (camino.get(i) == v && camino.get(i + 1) == ady) {
                            arcoVisitado = true;
                            break;
                        }
                    }
                    if (!arcoVisitado && vertices.get(ady) == false) {
                        dfs(ady, contArco, camino);
                    }
                }
            }
        }

        // Se elimina el ultimo nodo del camino para visitar otros vertices otras opciones
        camino.remove(camino.size() - 1);
        vertices.put(v, false);
    }
}
