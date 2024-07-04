package ordenamiento;

public class MergeSort {

	public static void main(String[] args) {

		Integer[] lista = {17, 4, 29, 8, 12, 6, 23, 10,
				       32, 5, 19, 14, 2, 30, 25, 16,
				       1, 21, 7, 3, 11, 28, 20, 13, 
				       9, 18, 31, 24, 27, 15, 22, 26};

		System.out.println("Lista antes de ordenar:");
		mostrarGen(lista);

		//lista = mergeSort(lista);
		lista=mergeSortGen(lista);

		System.out.println("Lista despues de ordenar:");
		mostrarGen(lista);

	}

	public static void mostrar(Integer[] v) {

		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");

		System.out.println("\n");

	}
	
	public static Integer[] mergeSort(Integer[] v) {
		
		System.out.println("MergeSort\n");
		
		v = mergeSort(v, 0, v.length-1);		
		
		return v;
	}
	
	public static Integer[] mergeSort(Integer[] v, int primerPos, int ultimaPos) {
		
		if(primerPos >= ultimaPos)	
			return v;
		
		int mitad = (primerPos + ultimaPos) / 2;
		
	    v = mergeSort(v, primerPos, mitad);
		v = mergeSort(v, mitad + 1, ultimaPos);
		
		v = merge(v, primerPos, mitad, ultimaPos);
		
		return v;
	}
	
	public static Integer[] merge(Integer[] v, int primerPos, int mitad, int ultimaPos) {
		
		
		int[] aux = new int[v.length];
		
		for(int i = primerPos; i <= mitad; i ++)
			aux[i] = v[i];
		
		for(int j = ultimaPos; j >= mitad + 1; j --)
			aux[mitad + 1 + ultimaPos - j] = v[j];
		
		
		int i = primerPos;
		int j = ultimaPos;
		int k = primerPos;
		
		while(i < j) {
			
			if(aux[i] <= aux[j]) {
				
				v[k] = aux[i];
				k ++;
				i ++;
				
			}
			else {
				
				v[k] = aux[j];
				k ++;
				j --;
				
			}
			
		}
		
		while(i <= mitad) {
		
			v[k] = aux[i];
			k ++;
			i ++;
			
		}
		
		return v;
	}
	
	//MergeSort genérico
	
	  public static <T extends Comparable<T>> void mostrarGen(T[] v) {
	        for (T element : v) {
	            System.out.print(element + " ");
	        }
	        System.out.println("\n");
	    }

	    public static <T extends Comparable<T>> T[] mergeSortGen(T[] v) {
	        System.out.println("MergeSort\n");
	        return mergeSortGen(v, 0, v.length - 1);
	    }

	    private static <T extends Comparable<T>> T[] mergeSortGen(T[] v, int primerPos, int ultimaPos) {
	        if (primerPos >= ultimaPos) {
	            return v;
	        }

	        int mitad = (primerPos + ultimaPos) / 2;
	        mergeSortGen(v, primerPos, mitad);
	        mergeSortGen(v, mitad + 1, ultimaPos);
	        mergeGen(v, primerPos, mitad, ultimaPos);

	        return v;
	    }

	    private static <T extends Comparable<T>> void mergeGen(T[] v, int primerPos, int mitad, int ultimaPos) {
	        @SuppressWarnings("unchecked")
			T[] aux = (T[]) new Comparable[v.length];

	        for (int i = primerPos; i <= mitad; i++) {
	            aux[i] = v[i];
	        }

	        for (int j = ultimaPos; j >= mitad + 1; j--) {
	            aux[mitad + 1 + ultimaPos - j] = v[j];
	        }

	        int i = primerPos;
	        int j = ultimaPos;
	        int k = primerPos;

	        while (i <= mitad && j >= mitad + 1) {
	            if (aux[i].compareTo(aux[j]) <= 0) {
	                v[k] = aux[i];
	                k++;
	                i++;
	            } else {
	                v[k] = aux[j];
	                k++;
	                j--;
	            }
	        }

	        while (i <= mitad) {
	            v[k] = aux[i];
	            k++;
	            i++;
	        }

	        while (j >= mitad + 1) {
	            v[k] = aux[j];
	            k++;
	            j--;
	        }
	    }
	
}
