package ordenamiento;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] v1 = {3, 4, 5, 1, 6, 2};
		int[] v2 = {3, 10, 2, 1};
		
		System.out.println("ANTES:");
		for(int i = 0; i < v1.length; i ++)
			System.out.print(v1[i] + " ");

		System.out.println("");

		for(int i = 0; i < v2.length; i ++)
			System.out.print(v2[i] + " ");

		System.out.println("");
		
		v1 = quickSort(v1);
		v2 = quickSort(v2);
		
		System.out.println("DESPUES:");
		for(int i = 0; i < v1.length; i ++)
			System.out.print(v1[i] + " ");
		
		System.out.println("");

		for(int i = 0; i < v2.length; i ++)
			System.out.print(v2[i] + " ");
		
	}

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
	}
}
