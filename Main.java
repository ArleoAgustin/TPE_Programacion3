package TPE_Programacion3;

import TPE_Programacion3.servicios.ServicioBFS;
import TPE_Programacion3.servicios.ServicioCaminos;
import TPE_Programacion3.servicios.ServicioDFS;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GrafoDirigido gDirigidoDFS = new GrafoDirigido();  //instancia el grafo dirigido
//carga los vertices

        gDirigidoDFS.agregarVertice(23);
        gDirigidoDFS.agregarVertice(6);
        gDirigidoDFS.agregarVertice(66);
        gDirigidoDFS.agregarVertice(87);
        gDirigidoDFS.agregarVertice(52);
        gDirigidoDFS.agregarVertice(46);
        gDirigidoDFS.agregarVertice(32);
        gDirigidoDFS.agregarVertice(18);

//carga los arcos

        gDirigidoDFS.agregarArco(23, 6, 1);
        gDirigidoDFS.agregarArco(6, 66, 1);
        gDirigidoDFS.agregarArco(66, 23, 4);
        gDirigidoDFS.agregarArco(6, 52, 5);
        gDirigidoDFS.agregarArco(23, 52, 3);
        gDirigidoDFS.agregarArco(52, 66, 10);
        gDirigidoDFS.agregarArco(23, 87, 11);
        gDirigidoDFS.agregarArco(87, 52, 88);
        gDirigidoDFS.agregarArco(87, 46, 10);
        gDirigidoDFS.agregarArco(32, 87, 10);
        gDirigidoDFS.agregarArco(32, 46, 10);
        gDirigidoDFS.agregarArco(46, 52, 10);
        gDirigidoDFS.agregarArco(32, 18, 10);
        gDirigidoDFS.agregarArco(18, 52, 10);
        //   System.out.println(gDirigido.contieneVertice(1)); //verifica si contien el vertice
        //   System.out.println(gDirigido.existeArco(4,3));    //verifica si existe el arco
        //  System.out.println(gDirigido.obtenerArco(1,4));    //obtiene el arco

        //gDirigido.borrarVertice(1);    //elimona un vertice

        System.out.println(" ");
        System.out.println("cantidad de vertices " + gDirigidoDFS.cantidadVertices());  //cantidad de vertices

        System.out.println("cantidad de arcos: " + gDirigidoDFS.cantidadArcos());       //cantidad de arcos

        System.out.println(" ");

////////////////////////////////////////////////////////iteradores/////////////////////////////////////////////////////

        Iterator<Integer> vertices = gDirigidoDFS.obtenerVertices();   //iterador de vertices

        if (vertices != null) {
            System.out.println("vertices: ");
            while (vertices.hasNext()) {
                System.out.print(vertices.next() + " ");
            }
        }
/*
        Iterator<Arco> arcos = gDirigido.obtenerArcos();    //iterador de arcos

        System.out.println(" ");
        System.out.println(" ");
        if (arcos != null) {
            System.out.println("Arcos:");
            while (arcos.hasNext()) {
                Arco arco = arcos.next();
                System.out.println(arco.getVerticeOrigen() + " --> " + arco.getVerticeDestino());
            }
        }

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


        ServicioDFS DFS = new ServicioDFS(gDirigidoDFS);
        Iterator<Integer> iDfs = DFS.dfsForest().iterator();
        System.out.println(" ");
        System.out.println(" ");
        if (iDfs != null) {
            System.out.println("DFS");
            while (iDfs.hasNext()) {
                System.out.print(iDfs.next() + " ");
            }
        }


        ////////////////////////////////////////////SERVICIO BFS ///////////////////////////////////////////////

        GrafoDirigido gDirigidoBFS = new GrafoDirigido();  //instancia el grafo dirigido

        gDirigidoBFS.agregarVertice(1);
        gDirigidoBFS.agregarVertice(99);
        gDirigidoBFS.agregarVertice(45);
        gDirigidoBFS.agregarVertice(61);
        gDirigidoBFS.agregarVertice(8);
        gDirigidoBFS.agregarVertice(20);
        gDirigidoBFS.agregarVertice(50);


        gDirigidoBFS.agregarArco(1, 99, 10);
        gDirigidoBFS.agregarArco(1, 45, 10);
        gDirigidoBFS.agregarArco(99, 8, 10);
        gDirigidoBFS.agregarArco(8, 1, 10);
        gDirigidoBFS.agregarArco(45, 61, 10);
        gDirigidoBFS.agregarArco(61, 8, 10);
        gDirigidoBFS.agregarArco(8, 20, 10);
        gDirigidoBFS.agregarArco(8, 50, 10);

        ServicioBFS BFS = new ServicioBFS(gDirigidoBFS);
        Iterator<Integer> iBfs = BFS.bfsForest().iterator();
        System.out.println(" ");
        System.out.println(" ");
        if (iBfs != null) {
            System.out.println("BFS");
            while (iBfs.hasNext()) {
                System.out.print(iBfs.next() + " ");
            }
        }



        ///////////////////////////////////////SERVICIO CAMINOS////////////////////////////////////////////////////////////////

        ServicioCaminos ServicioCaminos = new ServicioCaminos(gDirigidoDFS, 23, 66, 3);
        Iterator<List<Integer>> iCaminos = ServicioCaminos.caminos().iterator();
        System.out.println(" ");
        System.out.println(" ");
        if (iCaminos != null) {
            System.out.println("Caminos");
            while (iCaminos.hasNext()) {
                System.out.print(iCaminos.next() + " ");
            }
        }



















        /////////////////////////////////////////GRAFO NO DIRIGIDO/////////////////////////////////////////////////////////////////

/*

        GrafoNoDirigido gNoDirigido = new GrafoNoDirigido();   //instancia el grafo no dirigido

        gNoDirigido.agregarVertice(1);
        gNoDirigido.agregarVertice(2);
        gNoDirigido.agregarVertice(3);
        gNoDirigido.agregarVertice(4);

        gNoDirigido.agregarArco(1,2, 10);
        gNoDirigido.agregarArco(1,4,15);
        gNoDirigido.agregarArco(1,3,12);
        gNoDirigido.agregarArco(4,3,55);
        gNoDirigido.agregarArco(2,4,22);
        gNoDirigido.agregarArco(4,1,445);

        Iterator<Arco> arcos = gNoDirigido.obtenerArcos();    //iterador de arcos

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        if (arcos != null) {
            System.out.println("Arcos:");
            while (arcos.hasNext()) {
                Arco arco = arcos.next();
                System.out.println(arco.getVerticeOrigen() + " --> " + arco.getVerticeDestino());
            }
        }

        System.out.println("cantidad de arcos: "+gNoDirigido.cantidadArcos());
        System.out.println("cantidad de vertices: "+gNoDirigido.cantidadVertices());

       // gNoDirigido.borrarVertice(4);

        Iterator<Arco> arcos2 = gNoDirigido.obtenerArcos();    //iterador de arcos
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        if (arcos2 != null) {
            System.out.println("Arcos:");
            while (arcos2.hasNext()) {
                Arco arco = arcos2.next();
                System.out.println(arco.getVerticeOrigen() + " --> " + arco.getVerticeDestino());
            }
        }
        System.out.println("cantidad de arcos: "+gNoDirigido.cantidadArcos());
        System.out.println("cantidad de vertices: "+gNoDirigido.cantidadVertices());



        Iterator<Arco> arcosPorVertice = gNoDirigido.obtenerArcos(4); //iterador de arcos de un determinado vertice

        System.out.println(" ");
        if (arcosPorVertice != null) {
            System.out.println("Arcos por vertice:");
            while (arcosPorVertice.hasNext()) {
                Arco arco = arcosPorVertice.next();
                System.out.println(arco.getVerticeOrigen() + " --> " + arco.getVerticeDestino());
            }
        }
        
 */
    }
}
