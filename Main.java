package TPE_Programacion3;

public class Main {

    public static void main(String[] args) {

        Arco<Integer> a1 = new Arco<>(1,2,1);
        Arco<Integer> a2 = new Arco<>(2,1,1);
        Arco<Integer> a3 = new Arco<>(1,4,4);
        Arco<Integer> a4 = new Arco<>(4,2,5);
        Arco<Integer> a5 = new Arco<>(1,3,3);
        Arco<Integer> a6 = new Arco<>(4,3,11);
        Arco<Integer> a7 = new Arco<>(4,1,10);

        GrafoDirigido gDirigido = new GrafoDirigido();

        gDirigido.agregarVertice(1);
        gDirigido.agregarVertice(2);
        gDirigido.agregarVertice(3);
        gDirigido.agregarVertice(4);

        gDirigido.agregarArco(1,2,1);
        gDirigido.agregarArco(2,1,1);
        gDirigido.agregarArco(1,4,4);
        gDirigido.agregarArco(4,2,5);
        gDirigido.agregarArco(1,3,3);
        gDirigido.agregarArco(4,3,11);
        gDirigido.agregarArco(4,1,10);

     //   System.out.println(gDirigido.contieneVertice(1));
     //   System.out.println(gDirigido.existeArco(4,3));
     //   System.out.println(gDirigido.obtenerArco(1,4));

        System.out.println("cantidad de arcos: "+ gDirigido.cantidadArcos());

        gDirigido.obtenerArcoss();

        System.out.println(" ");

        System.out.println("cantidad de vertices "+ gDirigido.cantidadVertices());

        gDirigido.borrarVertice(1);

        System.out.println(" ");
        System.out.println("cantidad de vertices "+ gDirigido.cantidadVertices());

        System.out.println("cantidad de arcos: "+ gDirigido.cantidadArcos());

        gDirigido.obtenerArcoss();


        System.out.println(" ");

    /*    System.out.println(gDirigido.obtenerVertices());

        Iterator<Integer> aux = gDirigido.obtenerVertices();
        while (aux.hasNext()){

            System.out.println(aux.next());
        //    aux.next();
        }*/



    }
}
