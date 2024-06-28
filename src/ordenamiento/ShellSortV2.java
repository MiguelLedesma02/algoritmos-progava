package ordenamiento;

public class ShellSortV2 {

	public static void main(String[] args) {

		int[] lista = { 7, 6, 3, 2, 5, 1, 4 };

		System.out.println("Lista antes de ordenar:");
		mostrar(lista);

		lista = shellSort(lista);

		System.out.println("Lista despues de ordenar:");
		mostrar(lista);

	}

	public static void mostrar(int[] v) {

		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");

		System.out.println("\n");

	}

	public static int[] shellSort(int[] v) {

		int h = 40;

		// Mientras h sea menor a la cantidad de elementos, lo incremento
		while (h < v.length)
			h = h * 3 + 1;

		// Mientras h sea mayor a la cantidad de elementos, lo decremento
		while (h > v.length)
			h = (h - 1) / 3;

		while (h > 0) {

			for (int i = h; i < v.length; i ++) {

				int act = v[i];
				int j = i - h;

				while (j >= 0 && v[j] > act) {

					v[j + h] = v[j];
					j -= h;

				}

				v[j + h] = act;

			}

			h = (h - 1) / 3;

		}

		return v;
	}
	
}
