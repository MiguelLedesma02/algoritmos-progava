package ordenamiento;

public class QuickSort {

	public static void main(String[] args) {

		Integer[] v1 = { 25, 5, 43, 6,22, 10 };
		Integer[] v2 = { 3, 10, 2, 1,55 , -10, -1};

		System.out.println("ANTES:");
		for (int i = 0; i < v1.length; i++)
			System.out.print(v1[i] + " ");

		System.out.println("");

		//v1 = quickSort(v1);
		//v2 = quickSort(v2);
		quicksortGen(v1,0,v1.length-1);
		
		

		System.out.println("DESPUES:");
		for (int i = 0; i < v1.length; i++)
			System.out.print(v1[i] + " ");

	}

	public static Integer[] quickSort(Integer[] v1) {

		quicksortv2(0, v1.length - 1, v1);

		return v1;
	}

	public static void quicksortv2(int izq, int derecha, Integer[] v1) {
		int central, i, j;
		int pivote;
		central = (derecha + izq) / 2;
		pivote = v1[central];

		i = izq;
		j = derecha;
		do {
			
			while (v1[i] < pivote)
				i++;
			while (v1[j] > pivote)
				j--;
			if (i <= j) {
				int temp;
				temp = v1[i];
				v1[i] = v1[j];
				v1[j] = temp;
				i++;
				j--;
			} // O(n)
		} while (i <= j);

		if (izq < j)
			quicksortv2(izq, j, v1); // T(n/2)
		if (i < derecha)
			quicksortv2(i, derecha, v1);
	}
	
	//Método genérico
	  public static <T extends Comparable<T>> void quicksortGen(T[] vector, int primero, int ultimo) {
	        int central, i, j;
	        T pivote;
	        central = (primero + ultimo) / 2;
	        pivote = vector[central];
	        i = primero;
	        j = ultimo;

	        do {
	            while (vector[i].compareTo(pivote) < 0)
	                i++;
	            while (vector[j].compareTo(pivote) > 0)
	                j--;
	            if (i <= j) {
	                T temp = vector[i];
	                vector[i] = vector[j];
	                vector[j] = temp;
	                i++;
	                j--;
	            }
	        } while (i <= j);

	        if (primero < j)
	            quicksortGen(vector, primero, j);
	        if (i < ultimo)
	            quicksortGen(vector, i, ultimo);
	    }
	
}
