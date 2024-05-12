package ordenamiento;

public class TimSort {

	public static void main(String[] args) {

		int[] lista = { 7, 6, 3, 2, 5, 1, 4 };

		System.out.println("Lista antes de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");

		ordenarTimSort(lista, 2);

		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");

	}

	public static void insercion(int[] vec) {

		int n = vec.length;

		for (int i = 0; i < n; i++) {
			int j = i;
			while (j > 0 && vec[j - 1] > vec[j]) {
				int aux = vec[j];
				vec[j] = vec[j - 1];
				vec[j - 1] = aux;
				j--;
			}
		}

	}

	public static void ordenarTimSort(int[] vec, int cantElemXGrupo) {

		int tam = vec.length;

		if (vec == null) {
			return;
		}

		ordenarTimSort(vec, 0, tam - 1, cantElemXGrupo);

	}

	public static void ordenarTimSort(int[] vec, int izq, int der, int cantElemXGrupo) {

		if (izq < der && (der - izq) >= cantElemXGrupo) {

			int medio = (izq + der) / 2;

			ordenarTimSort(vec, izq, medio, cantElemXGrupo);
			ordenarTimSort(vec, medio + 1, der, cantElemXGrupo);

			timsort(vec, izq, medio, der);

		}

	}

	public static void timsort(int[] vec, int izq, int medio, int der) {

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

		insercion(vecAux1);
		insercion(vecAux2);

		int i = 0, j = 0, k = izq; // indices arrayAux1 y 2

		// copio primer parte igual y la 2da al revez

		while (i < n1 && j < n2) {
			if (vecAux1[i] <= vecAux2[j]) {
				vec[k] = vecAux1[i];
				i++;
			} else {
				vec[k] = vecAux2[j];
				j++;
			}
			k++;
		}

		// Copia los elementos restantes de vecAux1, si los hay
		while (i < n1) {
			vec[k] = vecAux1[i];
			i++;
			k++;
		}

		// Copia los elementos restantes de vecAux2, si los hay
		while (j < n2) {
			vec[k] = vecAux2[j];
			j++;
			k++;
		}

	} // O(n) = n*log(n)
}
