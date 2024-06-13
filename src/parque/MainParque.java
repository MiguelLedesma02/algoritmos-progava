package parque;

import java.util.*;

import grafos.Arista;

public class MainParque {

	public static void main(String[] args) {

		List<int[]> faroles = new ArrayList<>();

		int[] f1 = { 1, 1, 3 };
		int[] f2 = { 2, 3, 1 };
		int[] f3 = { 3, 2, 2 };
		int[] f4 = { 4, 3, 5 };
		int[] f5 = { 5, 1, 7 };
		int[] f6 = { 6, 8, 6 };
		int[] f7 = { 7, 5, 7 };
		int[] f8 = { 8, 5, 3 };
		int[] f9 = { 9, 8, 1 };
		int[] f10 = { 10, 8, 4 };
		int[] f11 = { 11, 10, 3 };
		int[] f12 = { 12, 12, 1 };
		int[] f13 = { 13, 13, 3 };
		int[] f14 = { 14, 12, 5 };
		int[] f15 = { 15, 12, 7 };

		faroles.add(f1);
		faroles.add(f2);
		faroles.add(f3);
		faroles.add(f4);
		faroles.add(f5);
		faroles.add(f6);
		faroles.add(f7);
		faroles.add(f8);
		faroles.add(f9);
		faroles.add(f10);
		faroles.add(f11);
		faroles.add(f12);
		faroles.add(f13);
		faroles.add(f14);
		faroles.add(f15);

		int[][] g = crearGrafo(faroles);

		MST.prim(g, 0);
		//MST.kruskal(g);
	}

	public static int[][] crearGrafo(List<int[]> faroles) {

		int[] tablero = { 0, 0, 0 };
		int[][] g = new int[faroles.size() + 1][faroles.size() + 1];
		boolean[] visitados = new boolean[faroles.size() + 1];

		faroles.add(0, tablero);

		int index = 0;
		while (index < 15) {

			visitados[index] = true;

			int[] nodoActual = faroles.get(index);
			index++;

			int[] distancias = new int[faroles.size() + 1];

			distancias = calcularPesos(nodoActual, faroles, visitados);

			for (int i = 0; i < distancias.length; i++)
				g[nodoActual[0]][i] = distancias[i];

		}

		return g;
	}

	public static int[] calcularPesos(int[] farolActual, List<int[]> faroles, boolean[] visitados) {

		int[] distancias = new int[faroles.size()];

		int[] coordenadasActual = new int[2];

		coordenadasActual[0] = farolActual[1];
		coordenadasActual[1] = farolActual[2];

		// Calcular distancias de los faroles con el tablero
		for (int[] f : faroles) {

			int[] coordenadas = new int[2];

			coordenadas[0] = f[1];
			coordenadas[1] = f[2];

			distancias[f[0]] = calcularDistancia(coordenadasActual, coordenadas) + 1;

		}

		return distancias;
	}

	public static int calcularDistancia(int[] n1, int[] n2) {

		int dist = 0;

		int difCuadradoX = (n2[0] - n1[0]) * (n2[0] - n1[0]);
		int difCuadradoY = (n2[1] - n1[1]) * (n2[1] - n1[1]);
		double raizCuadrada = Math.sqrt((difCuadradoX + difCuadradoY));

		dist = (int) Math.ceil(raizCuadrada);

		return dist;
	}

	public static void Prim(int[][] grafo) {

		int costoTotal = 0;
		Set<Integer> vg = new HashSet<>();
		List<Arista> aristas = new ArrayList<Arista>();
		PriorityQueue<Arista> cp = new PriorityQueue<>();

		// Cargo el conjunto de vértices del grafo
		for (int i = 1; i <= grafo.length; i++)
			vg.add(i);

		// Selecciono un elemento al azar
		int verticeActual = 1;

		while (vg.size() > 1) {

			// Eliminar dicho elemento de VG
			vg.remove((Integer) verticeActual);

			// Agregar en CP todas las aristas de dicho vértice, cuyos extremos no estén en
			// VG
			for (int i = 0; i < grafo.length; i++) {
				if (grafo[verticeActual - 1][i] != Integer.MAX_VALUE && vg.contains((Integer) (i + 1))) {
					Arista a = new Arista(verticeActual, i + 1, grafo[verticeActual - 1][i]);
					cp.offer(a);
				}
			}

			Arista a = cp.poll();

			// Si esta arista conecta dos vértices que ya están en el árbol, se la descarta
			while (!vg.contains((Integer) a.getNodo2())) {
				a = cp.poll();
			}

			// Se guardan las aristas del arbol.
			aristas.add(a);

			// Se suma el costo de agregar la arista.
			costoTotal += a.getCosto();

			verticeActual = a.getNodo2();
		}

		System.out.println("El costo total es: " + costoTotal);

	}

}
