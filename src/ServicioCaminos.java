import java.util.*;

public class ServicioCaminos {

    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;

    private List<List<Integer>> caminos;


    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
        this.caminos = new ArrayList<>();
    }

    public List<List<Integer>> caminos() {

        List<Integer> caminoActual = new ArrayList<>();
        HashMap<Arco<?>, Boolean> arcosVisitados = new HashMap<>();
        dfs(origen, lim, caminoActual, arcosVisitados);
        return caminos;
    }

    private void dfs(int v, int lim, List<Integer> caminoActual, HashMap<Arco<?>, Boolean> arcosVisitados) {

        caminoActual.add(v);

        if (v == destino && arcosVisitados.size() <= lim)       //si se llega a destino o se alcanza el limite de arcos
            caminos.add(new ArrayList<>(caminoActual));

        else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
            if (adyacentes != null) {
                while (adyacentes.hasNext()) {
                    int ady = adyacentes.next();
                    Iterator<? extends Arco<?>> arcos = grafo.obtenerArcos(v);

                    if (arcos!= null) {
                        while (arcos.hasNext()) {
                            Arco<?> arco = arcos.next();
                            if (arco.getVerticeDestino() == ady) {              //si el destino del arco es = al ady
                                if (!arcosVisitados.containsKey(arco)) {    //si el arco no fue visitado
                                    arcosVisitados.put(arco, true);
                                    dfs(ady, lim, caminoActual, arcosVisitados);
                                    arcosVisitados.remove(arco);
                                }
                            }
                        }
                    }
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);      //se elimina el vertice actual para poder ir por otras opciones
    }
}
