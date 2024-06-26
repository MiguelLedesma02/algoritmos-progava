package CadenaDeRegalos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Welsh_Powell {
	private int V; // Número de vértices
	private int[][] grafo; // Matriz de adyacencia

	public Welsh_Powell(int[][] grafoOriginal) {
		this.grafo = grafoOriginal;
		this.V = grafoOriginal.length;
	}

	// Función para ejecutar el algoritmo de Welsh-Powell
	public int[] colorGraph() {
		int[] resultado = new int[V]; // Resultado del coloreado
		boolean[] disponible = new boolean[V]; // Colores disponibles

		// Inicializa todos los vértices como no coloreados
		for (int i = 0; i < V; i++) {
			resultado[i] = -1;
		}

		// Inicializa todos los colores como disponibles
		for (int i = 0; i < V; i++) {
			disponible[i] = true;
		}

		// Crea una lista de nodos con sus grados
		List<Nodo> nodos = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			int grado = 0;
			for (int j = 0; j < V; j++) {
				if (grafo[i][j] != 0) {
					grado++;
				}
			}
			nodos.add(new Nodo(i, grado));
		}

		// Ordena los nodos en orden descendente de sus grados
		Collections.sort(nodos, new Comparator<Nodo>() {

			@Override
			public int compare(Nodo o1, Nodo o2) {

				return o2.getGrado() - o1.getGrado();
			}

		});
		//resultado[0]=0;
		// Asigna colores a los nodos
		for (Nodo nodo : nodos) {
			int u = nodo.getNumero();

			// Marca los colores de los vértices adyacentes como no disponibles
			for (int v = 0; v < V; v++) {
				if (grafo[u][v] != 0 && resultado[v] != -1) {
					disponible[resultado[v]] = false;
				}
			}

			// Encuentra el primer color disponible
			int color;
			for (color = 0; color < V; color++) {
				if (disponible[color]) {
					break;
				}
			}

			// Asigna el color encontrado al vértice u
			resultado[u] = color;

			// Restablece los valores de disponible
			for (int v = 0; v < V; v++) {
				if (grafo[u][v] != 0 && resultado[v] != -1) {
					disponible[resultado[v]] = true;
				}
			}
		}

		return resultado;
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1, 0, 1, 0 } };

		Welsh_Powell wp = new Welsh_Powell(graph);
		int[] result = wp.colorGraph();

		System.out.println("Los colores asignados en Welsh-Powell a los vértices son:");
		for (int i = 0; i < result.length; i++) {
			System.out.println("Vértice " + i + " ---> Color " + result[i]);
		}
	}

}
