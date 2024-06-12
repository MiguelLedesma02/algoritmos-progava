package grafos;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Recorrido {

	public static void main(String[] args) {

		int[][] g = {{0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, 
				     {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				     {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				     {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0}, 
				     {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0},
				     {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				     {1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
				     {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
				     {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
				     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};

		Map<Integer, Integer> distancia;
		
		distancia = recorridaEnAnchura(0, g);

		System.out.println("BFS");
		System.out.println("Nodo - Distancia");
		for (int i = 0; i < g.length; i ++) {
			
			if(distancia.containsKey(i))
				System.out.println(i + " - " + distancia.get(i));
			else
				System.out.println(i + " - " + "INF");
			
		}
		
		boolean[] v;
		
		v = recorridaEnProfundidad(0, g);
		
		System.out.println("\n\n\n");
		System.out.println("DFS");
		System.out.println("Nodo - Visitado");
		for (int i = 0; i < g.length; i ++) {
			System.out.println(i + " - " + v[i]);
		}
		
	}

	public static Map<Integer, Integer> recorridaEnAnchura(int nIni, int[][] g) {

		Map<Integer, Integer> distancia = new HashMap<>();
		Queue<Integer> nodosPendientes = new LinkedList<>();

		distancia.put(nIni, 0);
		nodosPendientes.add(nIni);

		while (!nodosPendientes.isEmpty()) {
			
			int nAct = nodosPendientes.poll();
			
			// Recorro las columnas de la fila nAct
			for (int j = 0; j < g.length; j++) {

				// Si no hay una arista entre los nodos, sigo
				if (g[nAct][j] != 1)
					continue;

				// Verifico si el nodo ya se agrego a la cola
				if (!distancia.containsKey(j)) {

					int dist = distancia.get(nAct);
					distancia.put(j, dist + 1);
					nodosPendientes.add(j);
				}

			}
			
		}

		return distancia;
	}
	
	public static boolean[] recorridaEnProfundidad(int nIni, int[][] g) {
		
		boolean[] v = new boolean[g.length];
		Stack<Integer> nodosPendientes = new Stack<>();
		
		v[nIni] = true;
		nodosPendientes.push(nIni);
		
		while(!nodosPendientes.isEmpty()) {
			
			int nAct = nodosPendientes.pop();
			
			// Recorro las columnas de la fila nAct
			for(int j = 0; j < g.length; j ++) {
				
				// Si no hay una arista entre los nodos, sigo
				if (g[nAct][j] != 1)
					continue;
				
				if (v[j] == false) {
					
					v[j] = true;
					nodosPendientes.push(j);
				}
				
			}
			
		}
		
		return v;
	}
	
}
