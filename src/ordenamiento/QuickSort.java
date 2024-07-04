package ordenamiento;

public class QuickSort {

	public static void main(String[] args) {

		Integer[] v1 = { 25, 5, 43, 6,22, 10 };
		int[] v2 = { 3, 10, 2, 1,55 , -10, -1};

		System.out.println("ANTES:");
		for (int i = 0; i < v2.length; i++)
			System.out.print(v2[i] + " ");

		System.out.println("");

		//v1 = quickSort(v1);
		//v2 = quickSort(v2);	
		
		quickSort(v2);

		System.out.println("DESPUES:");
		for (int i = 0; i < v2.length; i++)
			System.out.print(v2[i] + " ");

	}

	public static void quickSort(int[] v) {
		
		System.out.println("QuickSort\n");
		
		quickSort(v, 0, v.length-1);
	}
	
	public static void quickSort(int[] v, int primerPos, int ultimaPos) {
		
		if(primerPos >= ultimaPos)
			return;
		
		int pivot = v[(primerPos + ultimaPos) / 2]; //Elemento del medio
		
		//Intercambio el pivot con el ultimo elemento
		v[(primerPos + ultimaPos) / 2] = v[ultimaPos];
		v[ultimaPos] = pivot;
		
		int i = primerPos;
		int j = ultimaPos-1;
		
		while(i <= j) {
			
			while(v[i] < pivot)
				i ++;
				
			while(v[j] > pivot)
				j --;
			
			if(i < j) {
				
				int aux = v[i];
				v[i] = v[j];
				v[j] = aux;
								
				i ++;
				j --;
			}
						
		}
		
		//Acomodar pivot en su posicion final
		int aux = v[i];
		v[i] = pivot;
		v[ultimaPos] = aux;
		
		if(primerPos < i - 1)	
			quickSort(v, primerPos, i - 1);
		
		if(i + 1 < ultimaPos)
			quickSort(v, i + 1, ultimaPos);
		
		return;
	}
	

	
		public static void quickSortGen(Integer[] v) {
			
			System.out.println("QuickSort\n");
			
			quickSortGen(v, 0, v.length-1);
		}
		
		public static <T extends Comparable<T>> void quickSortGen(T[] v, int primerPos, int ultimaPos) {
			
			if(primerPos >= ultimaPos)
				return;
			
			T pivot = v[(primerPos + ultimaPos) / 2]; //Elemento del medio
			
			//Intercambio el pivot con el ultimo elemento
			v[(primerPos + ultimaPos) / 2] = v[ultimaPos];
			v[ultimaPos] = pivot;
			
			int i = primerPos;
			int j = ultimaPos-1;
			
			while(i <= j) {
				
				while(v[i].compareTo(pivot) < 0)
					i ++;
					
				while(v[j].compareTo(pivot) > 0)
					j --;
				
				if(i < j) {
					
					T aux = v[i];
					v[i] = v[j];
					v[j] = aux;
									
					i ++;
					j --;
				}
							
			}
			
			//Acomodar pivot en su posicion final
			T aux = v[i];
			v[i] = pivot;
			v[ultimaPos] = aux;
			
			if(primerPos < i - 1)	
				quickSortGen(v, primerPos, i - 1);
			
			if(i + 1 < ultimaPos)
				quickSortGen(v, i + 1, ultimaPos);
			
			return;
		}
	  
}
