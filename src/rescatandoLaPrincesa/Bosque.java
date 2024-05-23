package rescatandoLaPrincesa;

import java.util.ArrayList;
import java.util.List;

public class Bosque {
	
	private int[] dragones;
	private int[][] bosque;
	private int claroPrincipe;
	private int claroPrincesa;
	
	private static final int INF = 1000000;
	private static final int DRAGON = 1000000;
	
	public Bosque(int[] dragones, int[][] bosque, int claroPrincipe, int claroPrincesa) {
		
		this.dragones = new int[dragones.length];
		this.dragones = dragones;
		
		this.bosque = new int[bosque.length][bosque.length];
		this.bosque = bosque;
		
		this.claroPrincipe = claroPrincipe;
		this.claroPrincesa = claroPrincesa;
	}

	public int[] getDragones() {
		return dragones;
	}

	public int[][] getBosque() {
		return bosque;
	}
	
	public void getCamino() {
		
		int vecCostos[] = new int[bosque.length];
		int vecPredecesores[] = new int[bosque.length];
		List<Integer> v = new ArrayList(); 
		List<Integer> d = new ArrayList();
		boolean dragon = false;
		
		//Agrego los dragones a una lista
		for(int i = 1; i < this.dragones.length; i ++) {
			d.add(dragones[i]);
		}
		
		//Paso Inicial - Inicializar ambos vectores
		for(int i = 1; i <= bosque.length; i ++) {
			if(i != claroPrincipe) {
				v.add(i);				
			}
		}	
		
		for(int nodo : v) {
			vecCostos[nodo] = bosque[claroPrincipe][nodo];
			vecPredecesores[nodo] = claroPrincipe;
		}
		
		while(!v.isEmpty()) {
			int menorCosto = INF;
			int nodoMenorCosto = claroPrincipe;
			
			//Paso 1 - Determinar el nodo siguiente
			for(int nodo : v) {
				if(vecCostos[nodo] < menorCosto && vecCostos[nodo] != 0) {
					menorCosto = vecCostos[nodo];
					nodoMenorCosto = nodo;
				}				
			}
			
			v.remove((Object)nodoMenorCosto);
			
			int costoActual = 0;
			int costoNuevo = 0;
			int nodoActual = nodoMenorCosto;
			
			dragon = false;
			
			//Paso 2 - Actualizar los costos
			for(int nodo : v) {
				
				if(d.contains((Integer)nodo)) {
					vecCostos[nodo] = DRAGON;
					dragon = true;
				}
				
				costoActual = vecCostos[nodo];
				costoNuevo = vecCostos[nodoActual] + bosque[nodoActual][nodo];
				if(costoNuevo < costoActual && costoActual != 0) {
					vecCostos[nodo] = costoNuevo;
					vecPredecesores[nodo] = nodoActual;					
				}
			}
			
		}
		
		//Si el costo es cero, no hay camino.
		if(bosque[claroPrincipe][claroPrincesa] == 0) {
			System.out.println("No hay camino");
		}
		
		//Si DRAGON es true, hay caminos pero están interceptado por dragones.
		if(dragon == true) {
			System.out.println("Interceptado");
		}
		
		//Si el costo es un numero distinto de cero y DRAGON, hay camino.
		if(bosque[claroPrincipe][claroPrincesa] > 0 && dragon == false) {
			System.out.println("Hay camino");
		}
		
		return;
	}
}
