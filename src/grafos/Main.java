package grafos;

public class Main {
	public static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int mat1[][] = { { 0, 7, 3, INF }, { INF, INF, INF, 2 }, { INF, 2, INF, 8 }, { INF, INF, INF, INF } };

		int nodoInicial = 0;
		int nodoDestino = 3;

		DijkstraV2.Dijkstra(mat1, nodoInicial, nodoDestino);

		int mat2[][] = { { 0, 2, 3, 6 }, { 2, 0, INF, 4 }, { 3, INF, 0, 9 }, { 6, 4, 9, 0 } };
		int[][] recorrido = Floyd.Floyd(mat2);
		System.out.print("RECORRIDO FLOYD");
		imprimirMatriz(recorrido);

		int mat3[][] = { { 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 } };

		Warshall.warshall(mat3);
		System.out.print("RECORRIDO WARSHALL");
		imprimirMatriz(mat3);

	}

	public static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
