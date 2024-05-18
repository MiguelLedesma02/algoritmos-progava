package grafos;

import java.util.*;

public class Dijkstra {

	private static final int INF = 1000000;

	public static void main(String[] args) {
		int mat[][] = {{0, 700, 300, INF},
					   {INF, 0, INF, 200},
					   {INF, 200, 0, 800},
					   {INF, INF, INF, 0}};

		Dijkstra(mat, mat[0][0]);
	}
	
	static void Dijkstra(int[][] mat, int nodoInicial) {
		
		int vecCostos[] = new int[mat.length];
		int vecPredecesores[] = new int[mat.length];
		List<Integer> v = new ArrayList(); 
		
		//Paso Inicial - Inicializar ambos vectores
		for(int i = 0; i < mat.length; i ++) {
			if(i != nodoInicial) {
				v.add(i);				
			}
		}	
		
		for(int nodo : v) {
			vecCostos[nodo] = mat[nodoInicial][nodo];
			vecPredecesores[nodo] = nodoInicial;
		}
		
		while(!v.isEmpty()) {
			int menorCosto = INF;
			int nodoMenorCosto = nodoInicial;
			
			//Paso 1 - Determinar el nodo siguiente
			for(int nodo : v) {
				if(vecCostos[nodo] < menorCosto) {
					menorCosto = vecCostos[nodo];
					nodoMenorCosto = nodo;
				}				
			}
			
			v.remove((Object)nodoMenorCosto);
			
			int costoActual = 0;
			int costoNuevo = 0;
			int nodoActual = nodoMenorCosto;
			
			//Paso 2 - Actualizar los costos
			for(int nodo : v) {
				costoActual = vecCostos[nodo];
				costoNuevo = vecCostos[nodoActual] + mat[nodoActual][nodo];
				if(costoNuevo < costoActual) {
					vecCostos[nodo] = costoNuevo;
					vecPredecesores[nodo] = nodoActual;					
				}
			}
		}
		
		//Mostrar costos
		System.out.println("COSTOS:");
		for(int i = 0; i < vecCostos.length; i ++) {
			if(i != nodoInicial) {
				System.out.print("[" + i + "] = " + vecCostos[i] + " ");				
			}
		}
		
		//Mostrar predecesores
		System.out.println("\nPREDECESORES:");
		for(int i = 0; i < vecPredecesores.length; i ++) {
			if(i != nodoInicial) {
				System.out.print("[" + i + "] = " + vecPredecesores[i] + "   ");				
			}
		}	
		
		return;
	}

}
