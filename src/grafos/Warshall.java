package grafos;

public class Warshall {

	public static void warshall(int[][] mat) {
		int tamMat = mat.length;

		for (int k = 0; k < tamMat; k++) { // debo recorrer mi matriz en su diagonal
			for (int i = 0; i < tamMat; i++) {
				for (int j = 0; j < tamMat; j++) {
					if (mat[i][k] == 1 && mat[k][j] == 1) {
						mat[i][j] = 1;

					}

				}
			}

		}
	}
}
