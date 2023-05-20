import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	private int cantArcos, cantVertices;

	public GrafoDirigido(){
		vertices = new HashMap<>();
		this.cantArcos = 0;
		this.cantVertices = 0;
	}

//agrega un vertice

	/**
	 * Complejidad:	O(1) ya que lo hace en tiempo de ejecucion constante. Y tanto
	 * el "contiene vertice()" como el "put()" del hashmap son O(1). Ya que no dependen
	 * del tamaño de la estructura.
	 */
	@Override
	public void agregarVertice(int verticeId) {

		if (!contieneVertice(verticeId)) {
			vertices.put(verticeId, new ArrayList<>());
			this.cantVertices++;
		}
	}

//borra un vertice

	/**
	 * Complejidad: O(n) donde n es el numero de vertices en el grafo debido a que se debe recorrer todos
	 * los vertices del grafo para borrar los arcos vinculados a el.
	 */
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

	/**
	 * Complejidad: O(n) donde n es el tamanio de arcos asociados al vertice. Ya que
	 * a que se debe recorrer todos los arcos del vertice dado para verificar si se
	 * encuentra en su lista de arcos y posteriormente elimiarlo
	 * */
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {

		for(int i = 0; i < vertices.get(verticeId1).size(); i++)

			if (vertices.get(verticeId1).get(i).getVerticeDestino() == verticeId2){
				vertices.get(verticeId1).remove(vertices.get(verticeId1).get(i));
				cantArcos--;
			}
	}


//agrega un arco

	/**
	 * Complejidad: O(1) ya que la complejidad es constante, debido a que se accede directamente al vertice
	 * si existe y se agrega un nuevo arco en su lista.
	 */
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {

		if (this.contieneVertice(verticeId1)) {
			vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
			this.cantArcos++;
		}
	}

//verifica si contiene un determinado vertice

	/**
	 * Complejidad: O(1) ya que el timepo de ejecucion es constante y accede directamente a verificar
	 * si ese vertice existe
	 */
	@Override
	public boolean contieneVertice(int verticeId) {

		return vertices.containsKey(verticeId);
	}

//verifica si existe un determinado arco

	/**
	 * Complejidad: O(n) donde n es la cantidad de arcos asociados a un vertice
	 * ya que tenemos que recorrer el value (ArrayList<Arco<<T>>) de la key(vertice)
	 * para verificar que exista el arco.
	 */
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {

		if (this.contieneVertice(verticeId1)) {

			for (Arco<T> input: vertices.get(verticeId1)){
				if (input.getVerticeDestino() == verticeId2)
					return true;
			}
		}

		return false;
	}


//obtiene un determinado arco

	/**
	 * Complejidad: O(n) donde n es la cantidad de arcos asociados a un vertice
	 * ya que tenemos que recorrer el value (ArrayList<Arco<<T>>) de la key(vertice)
	 * para retornar el arco.
	 */
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {

		if (this.contieneVertice(verticeId1)) {
			for (Arco<T> input: vertices.get(verticeId1)){
				if (input.getVerticeDestino() == verticeId2)
					return input;
			}
		}
		return null;
	}

//retorna la cantidad de vertices

	/**
	 * Complejidad: O(1) ya que es una operacion de acceso y retorno del valor
	 */
	@Override
	public int cantidadVertices() { return this.cantVertices; }

//retorna la cantidad de arcos

	/**
	 * Complejidad: O(1) ya que es una operacion de acceso y retorno del valor
	 */
	@Override
	public int cantidadArcos() { return this.cantArcos; }


	/////////////////////////////////////metodos iterator///////////////////////////////////////////////////////////////

//retorna un iterador de los vertices

	/**
	 * Complejidad: O(1) ya que Hashmap proporciona un iterator que se crea en tiempo constante,
	 * manteniendo una referencia interna a los vertices y asi poder retornar un iterador de
	 * vertices.
	 */
	@Override
	public Iterator<Integer> obtenerVertices() {

		return vertices.keySet().iterator();
	}

//retorna un iterador de los valores adyacentes a un vertice

	/**
	 * Complejidad: O(n) donde n es la cantidad de arcos asociados al vertice y debe
	 * recorrer todos los arcos del vertice para agregarlos a un arreglo y posteriormente
	 * retornalos.
	 */
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

	/**
	 * Complejidad: O(n*m) donde n es la cantidad de vertices y m la cantidad de arcos, debido
	 *  a que para obtener todos los arcos del grafo se debe recorrer todos los vertices del mismo
	 *  para asi poder ir obteniendo todos los arcos de cada vertice. y luego retornarlos en un iterator
	 */
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

	/**
	 * Complejidad: O(n) donde n es la cantidad de arcos asociados a el vertice, ya que
	 * para obtener los arcos de un vertice debemos recorrer su lista de arcos y agregarlos
	 * a una lista y retornalos como un iterator.
	 */
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
