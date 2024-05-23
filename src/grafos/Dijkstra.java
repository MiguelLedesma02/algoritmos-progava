package grafos;

import java.util.*;

public class Dijkstra {

	private static final int INFINITO = 10000;

	public static void main(String[] args) {
		int mat[][] = {{INFINITO,10 ,INFINITO, 30, 100},
					   {INFINITO, INFINITO, 50, INFINITO,INFINITO},
					   {INFINITO, INFINITO, INFINITO,INFINITO, 10},
					   {INFINITO, INFINITO, 20,INFINITO,60},
					   {INFINITO,INFINITO,INFINITO,INFINITO,INFINITO}};

		Dijkstra(mat, 0);
	}
	
	static void Dijkstra(int[][] mat, int nodoInicial) {
		
		int longitud= mat[0].length;
		int vecCostos[] = new int[longitud];
		int vecPredecesores[] = new int[longitud];
		List<Integer> v_menos_s = new ArrayList(); 
		
		//Paso Inicial - Inicializar ambos vectores
		for(int i = 0; i <longitud; i ++) {
			if(i != nodoInicial) {
				v_menos_s.add(i);	//inicialmente van a estar todos los elementos menos con el que arranco 			
			}
		}	
		vecPredecesores[nodoInicial]=1;
		//tengo vector de costos y predecesores y los voy complejtando los valores de donde quiero arrancar
		for(int nodo : v_menos_s) {
			vecCostos[nodo] = mat[nodoInicial][nodo];
			vecPredecesores[nodo] = nodoInicial+1;
		}
		
		while(!v_menos_s.isEmpty()) { // me fijo que (V-S) siga teniendo elementos
			int menorCosto = INFINITO;
			int nodoMenorCosto = nodoInicial;
			
			//Paso 1 - Determinar el nodo siguiente que pertenezca a v-s y sea el menor
			for(int nodo : v_menos_s) {
				if(vecCostos[nodo] < menorCosto) {
					menorCosto = vecCostos[nodo];
					nodoMenorCosto = nodo;
				}				
			}
			// saco del vector el de menor costo para poder utilzarlo
			v_menos_s.remove((Object)nodoMenorCosto);
			
			int costoActual = 0;
			int costoNuevo = 0;
			int nodoActual = nodoMenorCosto;
			
			//Paso 2 - Actualizar los costos
			for(int nodo : v_menos_s) {
				costoActual = vecCostos[nodo];
				costoNuevo = vecCostos[nodoActual] + mat[nodoActual][nodo];
				if(costoNuevo < costoActual) {
					vecCostos[nodo] = costoNuevo;
					vecPredecesores[nodo] = nodoActual+1;					
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
			System.out.print("[" + (i+1) + "] = " + vecPredecesores[i] + "   ");				
		}	
		
		return;
	}

}
