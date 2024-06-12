package programacion_dinamica;

public class Mina {

	public static void main(String[] args) {
		
		int[][] m = {{3, 2, 12, 15, 10},
				     {6, 19, 7, 11, 17},
				     {8, 5, 12, 32, 21},
				     {3, 20, 2, 9, 7}};
		
		System.out.println(robarMina(m));

	}

	public static int robarMina(int[][] m) {
		
		int[][] memo = m;
		int f = m.length;
		int c = m[0].length;
		
		//La primera fila es fija
		for(int i = 1; i < f; i ++) {
			
			for(int j = 0; j < c; j ++) {
				
				//Estoy en la izq
				if(j == 0)
					memo[i][j] = m[i][j] + Math.max(memo[i-1][j], memo[i-1][j+1]);
				
				//Estoy por el medio
				if(j > 0 && j < c-1) 
					memo[i][j] = m[i][j] + Math.max(memo[i-1][j], 
							     	       Math.max(memo[i-1][j-1], memo[i-1][j+1]));
				
				//Estoy en la der
				if(j == c-1)
					memo[i][j] = m[i][j] + Math.max(memo[i-1][j-1], memo[i-1][j]);
			}
		}
		
		int botin = 0;
		
		//Obtengo el maximo de la ultima fila
		for(int j = 0; j < c; j ++) {
			if(memo[f-1][j] > botin)
				botin = memo[f-1][j];
		}
		
		return botin;
	}
	
}
