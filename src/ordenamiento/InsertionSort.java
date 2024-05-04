package ordenamiento;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] lista = {7,6,3,2,5,1,4};

		System.out.println("Lista antes de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");

		lista = insertionSort(lista);
		
		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");

	}
	
	static int[] insertionSort(int[] lista) {
		int i, j;
		int actual;
		
		for(i = 1;i < lista.length;i ++) {
			j = i-1;
			actual = lista[i];
			
			while(j >= 0 && actual < lista[j]) {
				lista[j+1] = lista[j];
				j --;
			}
			
			lista[j+1] = actual; 
		}
		
		return lista;
	}
}
