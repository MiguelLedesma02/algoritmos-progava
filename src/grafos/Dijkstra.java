package grafos;

import java.util.*;

public class Dijkstra {

	private static final int INF = 1000000;

	public static void main(String[] args) {
		
		int nodos[] = {0, 1, 2, 3};
		int mat[][] = {{0, 700, 300, INF},
					   {INF, 0, INF, 200},
					   {INF, 200, 0, 800},
					   {INF, INF, INF, 0}};
		int matMinima[][];
		
		matMinima = Dijkstra(mat, nodos, mat[0][0]);
		
		for(int j = 0; j < 2; j ++) {
			for(int i = 0; i < nodos.length; i ++) {
				System.out.print(matMinima[j][i] + " ");
			}
			
			System.out.println();
		}

	}
	
	static int[][] Dijkstra(int[][] mat, int[] nodos, int nodoInicial){
	
		int matFinal[][] = new int[2][nodos.length];
		List<Integer> s = new ArrayList();  
		List<Integer> v = new ArrayList();  
		
		//Agrego el nodo inicial al Conjunto S 
		s.add(nodoInicial);
		
		//Agrego los demas nodos al Conjunto V-S
		for(int j = 0; j < nodos.length; j ++) {
			
			//No se agrega el nodo inicial
			if(j == nodoInicial) {
				continue;
			}
			
			//Coloca el costo desde el nodo inicial al resto
			matFinal[0][j] = INF+1;
		
			v.add(nodos[j]);
		}
		
		int costoActual = 0;
		int costoNuevo = 0; 
		int nodoActual = nodoInicial;
		
		while (!v.isEmpty()) {
			for(int j = 0; j < nodos.length; j ++) {
				
				//No se considera el costo de llegar al nodo inicial
				if(j == nodoInicial) {
					continue;
				}
				
				costoActual = matFinal[0][j];
				costoNuevo = mat[nodoInicial][nodoActual] + mat[nodoActual][j]; 
				
				if(costoNuevo < costoActual) {
					//La primera fila (i = 0) es la de costos
					matFinal[0][j] = costoNuevo;
					
					//La segunda fila (i = 1) es la de predecesores
					matFinal[1][j] = nodoActual;
				}
			}
			
			int menorCosto = INF;
			int nodoMenorCosto = nodoInicial;
			for(int nodo : v) {
				if(matFinal[0][nodo] < menorCosto) {
					menorCosto = matFinal[0][nodo];
					nodoMenorCosto = nodo;
				}
			}
		
			menorCosto = INF;
			nodoActual = nodoMenorCosto;
			s.add(nodoMenorCosto);
			Integer nodoMenor = nodoMenorCosto;
			v.remove(nodoMenor);
		}
		
		return matFinal;
	}

}
