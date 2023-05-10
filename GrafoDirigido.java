package TPE_Programacion3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	private int cantArcos, cantVertices;

	public GrafoDirigido(){
		vertices = new HashMap<>();
		this.cantArcos = 0;
		this.cantVertices = 0;
	}

//agrega un vertice

	@Override
	public void agregarVertice(int verticeId) {

		if (!contieneVertice(verticeId)) {
			vertices.put(verticeId, new ArrayList<>());
			this.cantVertices++;
		}
	}

//borra un vertice

	@Override
	public void borrarVertice(int verticeId){

		if (contieneVertice(verticeId)) {
			cantArcos -= vertices.get(verticeId).size();
			vertices.remove(verticeId);
			cantVertices--;
			for (Integer v : vertices.keySet())
				borrarArco(v, verticeId);
		}
	}

//borra un arco

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {

		vertices.forEach((vertice, arco)->{
			for (int i = 0; i < arco.size(); i++) {
				if (arco.get(i).getVerticeOrigen() == verticeId1 && arco.get(i).getVerticeDestino() == verticeId2){
					arco.remove(arco.get(i));
					cantArcos--;
				}
			}

		});
	}

//agrega un arco

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {

		if (this.contieneVertice(verticeId1)) {
			vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
			this.cantArcos++;
		}
	}

//verifica si contiene un determinado vertice

	@Override
	public boolean contieneVertice(int verticeId) {

		return vertices.containsKey(verticeId);
	}

//verifica si existe un determinado arco

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {

		if (this.contieneVertice(verticeId1)) {

			for (Arco<T> input: vertices.get(verticeId1)){
				if (input.getVerticeOrigen() == verticeId1 && input.getVerticeDestino() == verticeId2)
					return true;
			}
		}

		return false;
	}

//obtiene un determinado arco

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {

		if (this.contieneVertice(verticeId1)) {
			for (Arco<T> input: vertices.get(verticeId1)){
				if (input.getVerticeOrigen() == verticeId1 && input.getVerticeDestino() == verticeId2)
					return input;
			}
		}
		return null;
	}

//retorna la cantidad de vertices

	@Override
	public int cantidadVertices() { return this.cantVertices; }

//retorna la cantidad de arcos

	@Override
	public int cantidadArcos() { return this.cantArcos; }


	/////////////////////////////////////metodos iterator///////////////////////////////////////////////////////////////

//retorna un iterador de los vertices

	@Override
	public Iterator<Integer> obtenerVertices() {

		return vertices.keySet().iterator();
	}

//retorna un iterador de los valores adyacentes a un vertice

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {

		ArrayList<Integer> adyacentes = new ArrayList<>();

		if (contieneVertice(verticeId)) {

			for (Arco<T> arco : vertices.get(verticeId)) {
				adyacentes.add(arco.getVerticeDestino());
			}
			return adyacentes.iterator();
		}
		return null;
	}


//retorna un iterador de arcos

	@Override
	public Iterator<Arco<T>> obtenerArcos() {

		ArrayList<Arco<T>> res = new ArrayList<>();
		vertices.forEach((vertice, arcos) -> {
			arcos.forEach(input -> { res.add(input); });
		});

		if (!res.isEmpty())
			return res.iterator();

		return null;
	}

//devuelve un iterador de los arcos de que parten de un vertice

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {

		ArrayList<Arco<T>> res = new ArrayList<>();

		if (this.contieneVertice(verticeId)) {
			vertices.get(verticeId).forEach(arco -> {

				res.add(arco);
			});
			if (!res.isEmpty())
				return res.iterator();
		}
		return null;
	}
}
