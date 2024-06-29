package ordenamiento;

public class MergeSort {

	public static void main(String[] args) {
	
		int[] v = {7,6,3,2,5,1,4};
		
		v = mergeSort(v);
		
		for(int i = 0; i < v.length; i ++) {
			System.out.print(v[i] + " ");
		}
		

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
		
		for(int i = 0; i <= mitad; i ++)
			aux[i] = v[i];
		
		for(int i = mitad + 1; i <= ultimaPos; i ++)
			aux[i] = v[i];
		
		int i = primerPos;
		int j = mitad + 1;
		int k = primerPos;
		
		while(i <= mitad && j <= ultimaPos) {
			
			if(aux[i] <= aux[j]) {
				
				v[k] = aux[i];
				k ++;
				i ++;
				
			}
			else {
				
				v[k] = aux[j];
				k ++;
				j ++;
				
			}
			
		}
		
		while(i <= mitad) {
		
			v[k] = aux[i];
			k ++;
			i ++;
			
		}
		
		while(j <= ultimaPos) {
			
			v[k] = aux[j];
			k ++;
			j ++;
			
		}
		
		return v;
	}
	

}
