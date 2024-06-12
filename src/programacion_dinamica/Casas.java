package programacion_dinamica;

public class Casas {

	public static void main(String[] args) {

		int c[] = {2, 10, 3, 6, 8, 1, 7};
		
		System.out.println(robarCasas(c));

	}
	
	public static int robarCasas(int[] c) {
		
		//Como minimo deben haber tres casas
		if(c.length < 3)
			return -1;
		
		int totalAnteriorDelAnterior = c[0];
		int totalAnterior = c[1];
		
		for(int i = 2; i < c.length; i ++) {
			
			if(totalAnteriorDelAnterior + c[i] > totalAnterior)	
				totalAnterior = totalAnteriorDelAnterior + c[i];
			else 
				totalAnteriorDelAnterior = totalAnterior;
			
		}
		
		return totalAnterior;
	}

}
