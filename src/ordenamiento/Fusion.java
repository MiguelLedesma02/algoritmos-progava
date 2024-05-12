package ordenamiento;

public class Fusion {

	public static void main(String[] args) {

		int[] lista = { 7, 6, 3, 2, 5, 1, 4 };

		System.out.println("Lista antes de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");

		ordenarFusion(lista);

		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");

	}

	public static void ordenarPorSeleccion(int[] datos) {
		int n = datos.length;
		for (int i = 0; i < (n - 1); i++) {
			int menor = i;
			for (int j = i + 1; j < n; j++)
				if (datos[j] < datos[menor])
					menor = j;
			int swap = datos[i];
			datos[i] = datos[menor];
			datos[menor] = swap;
		}
	}

	public static void ordenarFusion(int[] vec) {

		int tam = vec.length;

		if (vec == null || tam <= 2) {
			return;
		}

		ordenarFusion(vec, 0, tam - 1);

	}

	public static void ordenarFusion(int[] vec, int izq, int der) {

		if (izq < der) {
			int medio = (izq + der) / 2;

			ordenarFusion(vec, izq, medio);
			ordenarFusion(vec, medio + 1, der);

			fusion(vec, izq, medio, der);

		}

	}

	public static void fusion(int[] vec, int izq, int medio, int der) {

		int n1 = medio - izq + 1;
		int n2 = der - medio;

		int[] vecAux1 = new int[n1]; // creo vectores del tamaño de cada sub array auxiliares
		int[] vecAux2 = new int[n2];

		// copio el contenido del vector original y sus sub array a los auxiliares

		for (int i = 0; i < n1; i++) {
			vecAux1[i] = vec[izq + i];
		}

		for (int i = 0; i < n2; i++) {
			vecAux2[i] = vec[medio + i + 1];
		}

		// ordeno los subarray

		ordenarPorSeleccion(vecAux1);
		ordenarPorSeleccion(vecAux2);

		int i = 0, j = 0; // indices arrayAux1 y 2

		// copio primer parte igual y la 2da al revez

		while (i < n1 && j < n2) {

			vec[izq + i] = vecAux1[i];
			vec[der - j] = vecAux2[i];
			i++;
			j++;
		}

		// ordeno por seleccion
		int n = der - izq + 1;
		for (i = 0; i < n - 1; i++) {
			int menor = i + izq;
			for (j = i + 1 + izq; j <= der; j++)
				if (vec[j] < vec[menor])
					menor = j;
			int swap = vec[i + izq];
			vec[i + izq] = vec[menor];
			vec[menor] = swap;
		}

	} // O(n) = n*log(n)

}
