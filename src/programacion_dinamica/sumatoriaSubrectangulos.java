package programacion_dinamica;

public class sumatoriaSubrectangulos {

	public static void main(String[] args) {

		int[][] matriz = { { -5, 3, 5, 8, 2, 1, -4 }, { 3, -5, -10, 2, -2, 5, 4 }, { 1, 8, 3, -6, 0, 9, 3 },
				{ 12, 7, 1, -4, -9, 5, -6 }, { -15, 8, -12, 6, 3, -10, 3 } };

		int[][] res = sumatoriaPD(matriz);

		System.out.println("MATRIZ ORIGINAL");
		imprimirMatriz(matriz);
		System.out.println("MATRIZ RESULTADO");
		imprimirMatriz(res);

		int j = 2, c = 5, i = 2, f = 3;
		int resultado = sumatoriaInterna(res, j, c, i, f);
		System.out.println("RESULTADO DE LA SUMATORIA ENTRE LA MATRIZ COMPRENDIDA DE 2 a 5 y 3 a 4: " + resultado);

		maximoSubrectangulo(res);

	}

	public static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] sumatoriaPD(int[][] matriz) {

		int[][] res = new int[matriz.length][matriz[0].length];

		res[0][0] = matriz[0][0];

		for (int j = 1; j < matriz[0].length; j++) {
			res[0][j] = res[0][j - 1] + matriz[0][j];
		}
		for (int i = 1; i < matriz.length; i++) {
			res[i][0] = res[i - 1][0] + matriz[i][0];
		}

		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz[0].length; j++) {
				res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + matriz[i][j]; // la resta es el // la
																								// submatriz anterior
			}
		}

		return res;
	}

	public static int sumatoriaInterna(int[][] res, int j, int c, int i, int f) {

		int resultado = res[f][c] - res[f][j - 1] - res[i - 1][c] + res[i - 1][j - 1];
		return resultado;
	}

	public static void maximoSubrectangulo(int[][] res) {

		int max = 0, resultado = 0;

		int coordJ=0, coordC=0, coordI=0, coordF=0;

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				for (int k = i - 1; k >= 0; k--) {
					for (int l = j - 1; l >= 0; l--) {

						resultado = sumatoriaInterna(res, j, l, i, k);
						if (resultado > max) {
							max = resultado;
							coordJ = j;
							coordC = l+j;
							coordI = i;
							coordF = k+i;
						}

					}
				}

			}
		}
		System.out.println("Las coordenadas de la submatriz maxima son: ");
		System.out.println("J: "+coordJ + " C: " + coordC +" i: " + coordI +" F: " +coordF);
	}

}
