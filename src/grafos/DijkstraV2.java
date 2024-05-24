package grafos;

import java.util.Arrays;

public class DijkstraV2 {

	public static int INF = Integer.MAX_VALUE;

	static void Dijkstra(int[][] mat, int nodoInicial, int nodoDestino) {
		int tamMat = mat.length;
		int[] costos = new int[tamMat];
		int[] predecesores = new int[tamMat];
		boolean[] visitados = new boolean[tamMat];

		// inicio vectores
		for (int i = 0; i < tamMat; i++) {
			if (mat[nodoInicial][i] != INF) {
				costos[i] = mat[nodoInicial][i];
			} else {
				costos[i] = INF;
			}
			predecesores[i] = -1;
		}

		costos[nodoInicial] = 0;

		for (int visita = 0; visita < tamMat; visita++) { // debo recorrer mi vector y tomar mi primer menor costo
			int menorCosto = INF;
			int nodoMenorCosto = -1;

			for (int i = 0; i < tamMat; i++) {
				if (!visitados[i] && costos[i] < menorCosto) {
					menorCosto = costos[i];
					nodoMenorCosto = i;
				}
			}

			if (nodoMenorCosto == -1) {
				break;
			}

			visitados[nodoMenorCosto] = true;

			for (int i = 0; i < tamMat; i++) {
				if (!visitados[i] && (costos[nodoMenorCosto] + mat[nodoMenorCosto][i]) < costos[i]) {
					costos[i] = (costos[nodoMenorCosto] + mat[nodoMenorCosto][i]);
					predecesores[i] = nodoMenorCosto;
				}
			}

			System.out.println("Iteración " + (visita + 1) + ":");
			imprimirEstado(costos, predecesores);
		}

		// imprimo el camino y el costo total
		if (costos[nodoDestino] == INF) {
			System.out.println("No se puede llegar del nodo " + nodoInicial + " al nodo " + nodoDestino);
		} else {
			System.out.println("Camino desde el nodo " + nodoInicial + " hasta el nodo " + nodoDestino + ":");
			imprimirCamino(predecesores, nodoDestino);
			System.out.println("\nCosto total: " + costos[nodoDestino]);
		}
	}

	private static void imprimirEstado(int[] costos, int[] predecesores) {
		System.out.println("Costos: " + Arrays.toString(costos));
		System.out.println("Predecesores: " + Arrays.toString(predecesores));
		System.out.println();
	}

	private static void imprimirCamino(int[] predecesores, int nodoDestino) {
		if (predecesores[nodoDestino] == -1) {
			System.out.print(nodoDestino);
		} else {
			imprimirCamino(predecesores, predecesores[nodoDestino]);
			System.out.print(" -> " + nodoDestino);
		}

	}
}
