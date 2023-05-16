package TPE_Programacion3;

import TPE_Programacion3.servicios.ServicioBFS;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        GrafoDirigido gDirigido = new GrafoDirigido();  //instancia el grafo dirigido
//carga los vertices

        gDirigido.agregarVertice(1);
        gDirigido.agregarVertice(99);
        gDirigido.agregarVertice(45);
        gDirigido.agregarVertice(61);
        gDirigido.agregarVertice(8);
        gDirigido.agregarVertice(20);
        gDirigido.agregarVertice(50);

//carga los arcos

        gDirigido.agregarArco(1, 99, 1);
        gDirigido.agregarArco(1, 45, 1);
        gDirigido.agregarArco(8, 1, 4);
        gDirigido.agregarArco(99, 8, 5);
        gDirigido.agregarArco(45, 61, 3);
        gDirigido.agregarArco(61, 8, 11);
        gDirigido.agregarArco(8, 20, 88);
        gDirigido.agregarArco(8, 50, 10);
        //   System.out.println(gDirigido.contieneVertice(1)); //verifica si contien el vertice
        //   System.out.println(gDirigido.existeArco(4,3));    //verifica si existe el arco
        //  System.out.println(gDirigido.obtenerArco(1,4));    //obtiene el arco

        //gDirigido.borrarVertice(1);    //elimona un vertice

        System.out.println(" ");
        System.out.println("cantidad de vertices " + gDirigido.cantidadVertices());  //cantidad de vertices

        System.out.println("cantidad de arcos: " + gDirigido.cantidadArcos());       //cantidad de arcos

        System.out.println(" ");

////////////////////////////////////////////////////////iteradores/////////////////////////////////////////////////////

        Iterator<Integer> vertices = gDirigido.obtenerVertices();   //iterador de vertices

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



        ///////////////////////////////////////SERVICIO BFS////////////////////////////////////////////////////////////////

        ServicioBFS BFS = new ServicioBFS(gDirigido);
        Iterator<Integer> it = BFS.bfsForest().iterator();
        System.out.println(" ");
        System.out.println(" ");
        if (it != null) {
            System.out.println("BFS");
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
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
