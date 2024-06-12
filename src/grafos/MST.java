package grafos;

import java.util.*;

public class MST {

	public static void main(String[] args) {
		
		int INF = Integer.MAX_VALUE;
		
		int[][] grafo = { { INF, 2, INF, 4, INF, 5, INF }, 
				  		  { 2, INF, 7, 1, 3, 8, 4 }, 
				  		  { INF, 7, INF, INF, 10, INF, 6 },
				  		  { 4, 1, INF, INF, 2, INF, INF }, 
				  		  { INF, 3, 10, 2, INF, INF, INF }, 
				  		  { 5, 8, INF, INF, INF, INF, 1 },
				  		  { INF, 4, 6, INF, INF, 1, INF } };

		prim(grafo, 0);
		
	}
	
	public static void prim(int[][] g, int nIni) {
		
		int nAct = nIni;
		int costo = 0;
		boolean[] visitados = new boolean[g.length];
		PriorityQueue<Arista> aristas = new PriorityQueue<>(); 
	
		int infinito = Integer.MAX_VALUE;
		
		visitados[nAct] = true;
		for(int j = 0; j < g.length; j ++) {
			if(g[nAct][j] != infinito) {
				Arista a = new Arista(nAct, j, g[nAct][j]);
				aristas.add(a);
			}
		}
		
		int[][] arbol = new int[g.length][g.length];
		
		while(!aristas.isEmpty()) {
			
			Arista a = aristas.poll();
			
			//Si ambos nodos se encuentran en el arbol, descarto la arista
			if(visitados[a.getNodo1()] && visitados[a.getNodo2()])
				continue;
			
			arbol[a.getNodo1()][a.getNodo2()] = a.getCosto();
			arbol[a.getNodo2()][a.getNodo1()] = a.getCosto();
			
			nAct = a.getNodo2();
			costo += a.getCosto();
			
			visitados[nAct] = true;
			for(int j = 0; j < g.length; j ++) {
				if(g[nAct][j] != infinito && visitados[j] == false) {
					Arista aux = new Arista(nAct, j, g[nAct][j]);
					aristas.add(aux);
				}
			}
			
		}
		
		System.out.println("Costo: " + costo);
		
		for(int i = 0; i < arbol.length; i ++) {
			System.out.print((char)(i+65) + " - ");
			for(int j = 0; j < arbol.length; j ++) {
				if(arbol[i][j] != 0)
					System.out.print((char)(j+65) + " ");
			}
			System.out.println();
		}
		
	}

}
