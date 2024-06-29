package ordenamiento;

public class TimSort {

	public static void main(String[] args) {

		int[] lista = {17, 4, 29, 8, 12, 6, 23, 10,
			       	   32, 5, 19, 14, 2, 30, 25, 16,
			           1, 21, 7, 3, 11, 28, 20, 13, 
			           9, 18, 31, 24, 27, 15, 22, 26};

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
