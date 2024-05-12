package ordenamiento;

public class QuickSort {

	public static void main(String[] args) {

		int[] lista = { 7, 6, 3, 2, 5, 1, 4 };

		System.out.println("Lista antes de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");

		quicksortv2(lista, 0, lista.length);

		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");

	}

	public static void quicksortv2(int arreglo[], int primero, int ultimo) {
		int central, i, j;
		int pivote;
		central = (primero + ultimo) / 2;
		pivote = arreglo[central];
		i = primero;
		j = ultimo;
		do {
			while (arreglo[i] < pivote)
				i++;
			while (arreglo[j] > pivote)
				j--;
			if (i <= j) {
				int temp;
				temp = arreglo[i];
				arreglo[i] = arreglo[j];
				arreglo[j] = temp;
				i++;
				j--;
			} // O(n)
		} while (i <= j);

		if (primero < j)
			quicksortv2(arreglo, primero, j); // T(n/2)
		if (i < ultimo)
			quicksortv2(arreglo, i, ultimo);
	}
}
