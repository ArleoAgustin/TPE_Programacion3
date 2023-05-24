import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        /*
        * Todos los ejercicios solicitados fueron basados en la figura de ejemplo en "ejemplo.png".
        * Se utilizo linkedHashmap para mantener un orden a la hora de cargar los vertices, y
        * asi compararlo con la figura de ejemplo
        */



        GrafoDirigido<Integer> gDirigido = new GrafoDirigido<>();  //instancia el grafo dirigido

//carga los vertices
        gDirigido.agregarVertice(23);
        gDirigido.agregarVertice(87);
        gDirigido.agregarVertice(32);
        gDirigido.agregarVertice(46);
        gDirigido.agregarVertice(18);
        gDirigido.agregarVertice(52);
        gDirigido.agregarVertice(66);
        gDirigido.agregarVertice(6);

//carga los arcos
        gDirigido.agregarArco(32, 18, 1);
        gDirigido.agregarArco(32, 87, 1);
        gDirigido.agregarArco(32, 46, 1);
        gDirigido.agregarArco(18, 52, 1);
        gDirigido.agregarArco(87, 46, 1);
        gDirigido.agregarArco(87, 52, 1);
        gDirigido.agregarArco(46, 52, 1);
        gDirigido.agregarArco(52, 66, 1);
        gDirigido.agregarArco(66, 23, 1);
        gDirigido.agregarArco(6, 66, 1);
        gDirigido.agregarArco(6, 52, 1);
        gDirigido.agregarArco(23, 52, 1);
        gDirigido.agregarArco(23, 6, 1);
        gDirigido.agregarArco(23, 87, 1);


        System.out.println(" ");
        System.out.println("cantidad de vertices " + gDirigido.cantidadVertices());  //cantidad de vertices
        System.out.println("cantidad de arcos: " + gDirigido.cantidadArcos());       //cantidad de arcos

        System.out.println(" ");
        //    gDirigido.borrarVertice(52);                          //elimina un vertice
        //    System.out.println(gDirigido.contieneVertice(1));     //verifica si contien el vertice
        //    System.out.println(gDirigido.existeArco(4,3));        //verifica si existe el arco
        //    System.out.println(gDirigido.obtenerArco(1,4));       //obtiene el arco

        System.out.println(" ");

////////////////////////////////////////////////////////iteradores/////////////////////////////////////////////////////

        Iterator<Integer> vertices = gDirigido.obtenerVertices();   //iterador de vertices

        if (vertices != null) {
            System.out.println("vertices: ");
            while (vertices.hasNext()) {
                System.out.print(vertices.next() + " ");
            }
        }

        Iterator<Arco<Integer>> arcos = gDirigido.obtenerArcos();    //iterador de arcos

        System.out.println(" ");
        System.out.println(" ");
        if (arcos != null) {
            System.out.println("Arcos del grafo:");
            while (arcos.hasNext()) {
                Arco<Integer> arco = arcos.next();
                System.out.println(arco.getVerticeOrigen() + " --> " + arco.getVerticeDestino());
            }
        }

//muestra todos los arcos de un determinado vertice
/*
        Iterator<Arco> arcosPorVertice = gDirigido.obtenerArcos(4); //iterador de arcos de un determinado vertice

        System.out.println(" ");
        if (arcosPorVertice != null) {
            System.out.println("Arcos por vertice:");
            while (arcosPorVertice.hasNext()) {
                Arco arco = arcosPorVertice.next();
                System.out.println(arco.getVerticeOrigen() + " --> " + arco.getVerticeDestino());
            }
        }*/


///////////////////////////////////////SERVICIO DFS////////////////////////////////////////////////////////////////

//muestra el camino del DFS

        System.out.println(" ");
        System.out.println(" ");

        ServicioDFS DFS = new ServicioDFS(gDirigido);
        Iterator<Integer> iDfs = DFS.dfsForest().iterator();

        System.out.println("DFS: ");

        while (iDfs.hasNext()) {
            System.out.print(iDfs.next() + " ");
        }


////////////////////////////////////////////SERVICIO BFS ///////////////////////////////////////////////
        System.out.println(" ");


//muestra el camino del BFS

        System.out.println(" ");
        System.out.println(" ");

        ServicioBFS BFS = new ServicioBFS(gDirigido);
        Iterator<Integer> iBfs = BFS.bfsForest().iterator();

        System.out.println("BFS: ");
        while (iBfs.hasNext()) {
            System.out.print(iBfs.next() + " ");
        }



///////////////////////////////////////SERVICIO CAMINOS////////////////////////////////////////////////////////////////

//muestra el servicio de caminos

        System.out.println(" ");
        System.out.println(" ");

        ServicioCaminos ServicioCaminos = new ServicioCaminos(gDirigido, 23, 6, 5);    //Servcaminos

        Iterator<List<Integer>> iCaminos = ServicioCaminos.caminos().iterator();

        System.out.println("Caminos: ");
        while (iCaminos.hasNext()) {
            System.out.print(iCaminos.next() + " ");
        }

    }
}