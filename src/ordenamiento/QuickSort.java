package ordenamiento;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] v1 = {3, 4, 5, 1, 6, 2};
		int[] v2 = {3, 10, 2, 1};
		
		System.out.println("ANTES:");
		for(int i = 0; i < v1.length; i ++)
			System.out.print(v1[i] + " ");

<<<<<<< HEAD
		System.out.println("");
=======
		int[] lista = { 25, 5, 43, 6, 22, 10};
>>>>>>> 6f1760fde574535f7a2ccbc51b52d9dd04b42880

		for(int i = 0; i < v2.length; i ++)
			System.out.print(v2[i] + " ");

<<<<<<< HEAD
		System.out.println("");
		
		v1 = quickSort(v1);
		v2 = quickSort(v2);
		
		System.out.println("DESPUES:");
		for(int i = 0; i < v1.length; i ++)
			System.out.print(v1[i] + " ");
		
		System.out.println("");
=======
		quicksortv2(lista, 0, lista.length-1);

		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");
>>>>>>> 6f1760fde574535f7a2ccbc51b52d9dd04b42880

		for(int i = 0; i < v2.length; i ++)
			System.out.print(v2[i] + " ");
		
	}

<<<<<<< HEAD
	public static int[] quickSort(int[] v) {
		
		quickSortMask(0, v.length-1, v);
		
		return v;
	}
	
	public static int[] quickSortMask(int indexIzq, int indexDer, int[] v) {
		
		
		if(indexIzq >= indexDer)
			return v;
		
		int pivote = v[indexDer];
		int posPivote = indexDer;
		int ultMenor = indexIzq - 1;
		int aux = 0;
		
		for(int i = indexIzq; i < indexDer; i ++) {
			
			if(v[i] < pivote) {
				
				ultMenor ++;
				
				aux = v[i];
				v[i] = v[ultMenor];
				v[ultMenor] = aux; 
				
			}
			
		}
		
		ultMenor ++;
		
		aux = pivote;
		v[posPivote] = v[ultMenor];
		v[ultMenor] = aux; 
		
		posPivote = ultMenor;
		
		v = quickSortMask(indexIzq, posPivote-1, v);
		v = quickSortMask(posPivote+1, indexDer, v);
		
		return v;
=======
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
>>>>>>> 6f1760fde574535f7a2ccbc51b52d9dd04b42880
	}
}
