package rescatandoLaPrincesa;

import java.util.*;

public class Dijkstra {

	private static final int INF = 1000000;
	
	public void Dijkstra(int[][] mat, int nodoInicial) {
		
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
		
		return;
	}

}
