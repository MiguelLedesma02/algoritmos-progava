package grafos;

public class Floyd {

	public static int INF = Integer.MAX_VALUE;

	public static int[][] Floyd(int[][] mat) {
		int tamMat = mat.length;
		int[][] recorrido = new int[tamMat][tamMat];

		// inicio matriz recorrido
		for (int i = 0; i < tamMat; i++) {
			for (int j = 0; j < tamMat; j++) {
				recorrido[i][j] = j;
			}
		}

		for (int k = 0; k < tamMat; k++) { // debo recorrer mi matriz en su diagonal
			for (int i = 0; i < tamMat; i++) {
				for (int j = 0; j < tamMat; j++) {
					if (mat[i][k] + mat[k][j] < mat[i][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
						recorrido[i][j] = k;
					}

				}
			}

		}

		return recorrido;
	}

}
