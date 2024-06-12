package programacion_dinamica;

public class Matriz {

	public static void main(String[] args) {
		
		int[][] m = {{-5, 3, 5},
				     {3, -8, -10}};

		/*
		 *  1*1 = -5, 3, 5, 3, -8, -10
		 *  1*2 = (-5, 3), (3, 5), (3, -8), (-8, -10) 
		 *  1*3 = (-5, 3, 5), (3, -8, -10)
		 *  2*1 = (-5, 3), (3, -8), (-5, 10)
		 *  2*2 = (-5, 3, 3, -8), (3, 5, -8, -10)
		 *  2*3 = (-5, 3, 5, 3, -8, -10)
		*/
		
		//SIN TERMINAR
		System.out.println(calcularSumaMatrizMax(m));
		
	}
	
	public static int calcularSumaMatrizMax(int[][] m) {
		
		int f = m.length;
		int c = m[0].length;
		int[][] aux = calcularMatPD(m);
		
		int max = 0;
	
		return max;
	}
	
	public static int[][] calcularMatPD(int[][] m){
		
		int f = m.length;
		int c = m[0].length;
		int[][] pd = m;
		
		int sumaFilaAnt = 0; 
		int sumaColumnaAnt = 0;
		int sumaDiagonalAnt = 0;
		
		//Armar matriz auxiliar
		for(int i = 0; i < f; i ++) {
			
			for(int j = 0; j < c; j ++) {
								
				if(i-1 >= 0)
					sumaFilaAnt = pd[i-1][j];
				if(j-1 >= 0)
					sumaColumnaAnt = pd[i][j-1];
				if(i-1 >= 0 && j-1 >= 0)
					sumaDiagonalAnt = pd[i-1][j-1];
				
				pd[i][j] = sumaFilaAnt + sumaColumnaAnt - sumaDiagonalAnt + m[i][j];
				
				//Resetear variables
				sumaFilaAnt = 0; 
				sumaColumnaAnt = 0;
				sumaDiagonalAnt = 0;
			}
		}
		
		return pd;
	}

}
