package grafos;

import java.util.*;

import parque.Arista;

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
		//kruskal(grafo);
		
//		int[] nodos = {1, 2, 1, 3, 1, 2};
//		
//		System.out.println("NODO - GRUPO");
//		for(int i = 0; i < nodos.length; i ++)
//			System.out.println( (i+1) + " - " + find(i+1, nodos));
//		
//		union(1, 2, nodos);
//		
//		System.out.println("Se unieron 1 y 2");
//		
//		System.out.println("NODO - GRUPO");
//		for(int i = 0; i < nodos.length; i ++)
//			System.out.println( (i+1) + " - " + find(i+1, nodos));
				
	}
	
public static void kruskal(int[][] g) {
		
		int INF = Integer.MAX_VALUE;
		PriorityQueue<Arista> aristas = new PriorityQueue<>();
		int[] nodos = new int[g.length];
		
		for(int i = 0; i < g.length; i ++) {
			
			nodos[i] = i+1;
			
			for(int j = 0; j < g.length; j ++) 
				if(g[i][j] != INF) {
					Arista a = new Arista(i, j, g[i][j]);			
					aristas.add(a);
				}
			
		}
		
		int costo = 0;
		List<Arista> mst= new ArrayList<>();
		while(!aristas.isEmpty()) {
			
			Arista a = aristas.poll();

			if(find(a.getNodo1()+1, nodos) == find(a.getNodo2()+1, nodos))
				continue;
			
			union(a.getNodo1()+1, a.getNodo2()+1, nodos);
			mst.add(a);
			costo += a.getCosto();
			
		}
		
		System.out.println("Costo " + costo);
		 System.out.println("Aristas en el MST:");
	        for (Arista a : mst) {
	            System.out.println(a.getNodo1() + " - " + a.getNodo2() + " : " + a.getCosto());
	        }
		
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
	
	private static int find(int n, int[] nodos) {
		
		while(n != nodos[n-1])
			n = nodos[n-1];
		
		return n;
	}
	
	private static void union(int n1, int n2, int[] nodos) {
		
		while(n1 != nodos[n1-1])
			n1 = nodos[n1-1];
		
		while(n2 != nodos[n2-1])
			n2 = nodos[n2-1];
		
		nodos[n2-1] = n1;
		
	}

}
