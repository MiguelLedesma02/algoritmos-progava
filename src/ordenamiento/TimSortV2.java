package ordenamiento;

public class TimSortV2 {

	public static void main(String[] args) {

		int[] lista = {23,9,16,5,32,18,7,29,14,2,11,30,25,1,20,8,17,3,28,10,19,6,21,13,15,4,27,26,12,31,24,22};

		System.out.println("Lista antes de ordenar:");
		mostrar(lista);

		lista = timSort(lista);

		System.out.println("Lista despues de ordenar:");
		mostrar(lista);

	}

	public static void mostrar(int[] v) {

		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");

		System.out.println("\n");

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
	
	public static int[] timSort(int[] v) {
		
		System.out.println("TimSort\n");
		
		v = timSort(v, 0, v.length-1);
		
		return v;
	}
	
	public static int[] timSort(int[] v, int primerPos, int ultimaPos) {
		
		//Determino un maximo de 4 elementos por grupo
		if(ultimaPos - primerPos <= 4) {
			
			for(int i = primerPos + 1; i <= ultimaPos; i ++) {
				
				int act = v[i];
				int j = i - 1;
				
				while(j >= primerPos && v[j] > act) {
					
					v[j + 1] = v[j];
					j --;
					
				}
				
				v[j + 1] = act;
			}
			
			return v;
		}
		
		int mitad = (primerPos + ultimaPos) / 2;
		
		v = timSort(v, primerPos, mitad);
		v = timSort(v, mitad + 1, ultimaPos);
		
		v = merge(v, primerPos, mitad, ultimaPos);
		
		return v;
	}

}
