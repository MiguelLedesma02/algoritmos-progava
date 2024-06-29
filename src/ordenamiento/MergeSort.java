package ordenamiento;

public class MergeSort {

	public static void main(String[] args) {

		int[] lista = {17, 4, 29, 8, 12, 6, 23, 10,
				       32, 5, 19, 14, 2, 30, 25, 16,
				       1, 21, 7, 3, 11, 28, 20, 13, 
				       9, 18, 31, 24, 27, 15, 22, 26};

		System.out.println("Lista antes de ordenar:");
		mostrar(lista);

		lista = mergeSort(lista);

		System.out.println("Lista despues de ordenar:");
		mostrar(lista);

	}

	public static void mostrar(int[] v) {

		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");

		System.out.println("\n");

	}
	
	public static int[] mergeSort(int[] v) {
		
		System.out.println("MergeSort\n");
		
		v = mergeSort(v, 0, v.length-1);		
		
		return v;
	}
	
	public static int[] mergeSort(int[] v, int primerPos, int ultimaPos) {
		
		if(primerPos >= ultimaPos)	
			return v;
		
		int mitad = (primerPos + ultimaPos) / 2;
		
	    v = mergeSort(v, primerPos, mitad);
		v = mergeSort(v, mitad + 1, ultimaPos);
		
		v = merge(v, primerPos, mitad, ultimaPos);
		
		return v;
	}
	
	public static int[] merge(int[] v, int primerPos, int mitad, int ultimaPos) {
		
		
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
	
}
