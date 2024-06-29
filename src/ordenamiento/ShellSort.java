package ordenamiento;

public class ShellSort {

	public static void main(String[] args) {

		int[] lista = {17, 4, 29, 8, 12, 6, 23, 10,
			       	   32, 5, 19, 14, 2, 30, 25, 16,
			           1, 21, 7, 3, 11, 28, 20, 13, 
			           9, 18, 31, 24, 27, 15, 22, 26};

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

		System.out.println("ShellSort");
		
		int h = 13;

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
