package TPE_Programacion3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Arco<T>>> vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
	private int cantArcos, cantVertices;

	public GrafoDirigido(){

		this.cantArcos = 0;
		this.cantVertices = 0;
	}

	@Override
	public void agregarVertice(int verticeId) {

		if (!contieneVertice(verticeId)) {
			vertices.put(verticeId, new ArrayList<>());
			this.cantVertices++;
		}
	}
/*
	@Override
	public void borrarVertice(int verticeId) {

		for (Map.Entry<Integer, ArrayList<Arco<T>>> input: vertices.entrySet()) {

			ArrayList<Arco<T>> aux = input.getValue();
			//	System.out.println(aux);
			for (int i = 0; i < aux.size(); i++) {
				//	System.out.println(i);


				if ((aux.get(i).getVerticeOrigen() == verticeId) || (aux.get(i).getVerticeDestino() == verticeId)) {
					System.out.println("el arco es : " + aux.get(i).getVerticeOrigen() + " --> " + aux.get(i).getVerticeDestino());
					borrarArco(aux.get(i).getVerticeOrigen(), aux.get(i).getVerticeDestino());
					System.out.println(" ");
				}
			}

		}


       // vertices.remove(verticeId); //elimina el vertice
        this.cantVertices--;

	}
*/

	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId);
		for (ArrayList<Arco<T>> listaAdyacencia : vertices.values()) {
			listaAdyacencia.removeIf(arco -> arco.getVerticeDestino() == verticeId);
		}
	}


	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {

		if (this.contieneVertice(verticeId1)) {
			vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
			this.cantArcos++;
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {

		System.out.println(verticeId2);
		if (this.contieneVertice(verticeId1) || this.contieneVertice(verticeId2)) {

			for (int i = 0; i <vertices.get(verticeId1).size() ; i++) {

		//			System.out.println("paso " +vertices.get(verticeId1).get(i).getVerticeOrigen() + "-->"+ vertices.get(verticeId1).get(i).getVerticeDestino());

				if (vertices.get(verticeId1).get(i).getVerticeDestino() == verticeId2){

						System.out.println(vertices.get(verticeId1).get(i).getVerticeOrigen() + "-->"+ vertices.get(verticeId1).get(i).getVerticeDestino());
					this.cantArcos--;
					vertices.get(verticeId1).remove(vertices.get(verticeId1).get(i));////revisar aca
				}
			}

            /*
			for (Map.Entry<Integer, ArrayList<Arco<T>>> input: vertices.entrySet()) {

				for (int i = 0; i < input.getValue().size(); i++) {
					if ((input.getValue().get(i).getVerticeOrigen() == verticeId1) && (input.getValue().get(i).getVerticeDestino() == verticeId2)) {
						this.cantArcos--;
						System.out.println("Eliminado " + input.getValue().get(i) + " " + input.getValue().get(i).getVerticeOrigen() + " --> " + input.getValue().get(i).getVerticeDestino());
						input.getValue().remove(input.getValue().get(i));

					}
				}
			}
*/

        /*	for (int i = 0; i < vertices.get(verticeId1).size(); i++) {

				if (vertices.get(verticeId1).get(i).getVerticeDestino() == verticeId2) {
					vertices.get(verticeId1).remove(vertices.get(verticeId1).get(i));
					System.out.println("gola");
					this.cantArcos--;
					return;
				}
			}

		}*/
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {

		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {

		if (vertices.get(verticeId1) != null) {

			for (int i = 0; i < vertices.get(verticeId1).size(); i++) {
				if (vertices.get(verticeId1).get(i).getVerticeOrigen() == verticeId1 && vertices.get(verticeId1).get(i).getVerticeDestino() == verticeId2)
					return true;
			}

		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {

		if (vertices.get(verticeId1) != null) {
			for (int i = 0; i < vertices.get(verticeId1).size(); i++) {
				if ((vertices.get(verticeId1).get(i).getVerticeOrigen() == verticeId1) && (vertices.get(verticeId1).get(i).getVerticeDestino() == verticeId2)) {
					return vertices.get(verticeId1).get(i);
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() { return this.cantVertices; }

	@Override
	public int cantidadArcos() { return this.cantArcos; }


	public void  obtenerArcoss() {

		vertices.forEach((vertice, arcos) -> {

			arcos.forEach(input -> {

				System.out.println(input +"  "+ input.getVerticeOrigen() + " --> "+ input.getVerticeDestino());
			});

		});

	}

	/////////////////////////////////////metodos iterator///////////////////////////////////////////////////////////////

	@Override
	public Iterator<Integer> obtenerVertices() {

		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}


}
