//package grafos;
//
//import java.util.*;
//
//public class Coloreo {
//
//	public static void main(String[] args) {
//		//			  A, B, C, D, E, F, G, H, I, J
//		int g[][] = {{0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
//					 {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//					 {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//					 {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
//					 {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
//					 {1, 0, 1, 0, 0, 0, 1, 0, 1, 1},
//					 {0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
//					 {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
//					 {0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
//					 {0, 0, 0, 0, 0, 1, 1, 0, 1, 0}};
//		
//		System.out.println(transformarMatrizEnLista(g));
//		//System.out.println(welshPowell(g));
//		
//	}
	
//	public static List<List<Nodo>> transformarMatrizEnLista(int[][] g) {
//		
//		int vectorListas[]=new int [g.length]; 
//		
//		List<List<Nodo>> listaAdyacencia = new ArrayList<>();
//		
//		for(int i = 0; i < g.length; i ++) {
//			
//			Nodo n = new Nodo(i+1);
//			List<Nodo> l = new ArrayList<>();
//			
//			for(int j = 0; j < g.length; j ++) {
//				
//				if(g[i][j] == 1) {
//					n.incrementarGrado();
//					l.add(n);
//				}
//				
//			}
//			
//			listaAdyacencia.add(l);
//			
//		}
//		return listaAdyacencia;
//	}
//
//	public static int welshPowell(int[][] g) {
//		
//		List<List<Nodo>> listaAdyacencia = new ArrayList<>();
//		PriorityQueue<Nodo> nodosPendientes = new PriorityQueue<>();
//		
//		listaAdyacencia = transformarMatrizEnLista(g);
//		
//		int i = 1;
//		for(List<Nodo> l : listaAdyacencia) {
//			
//			Nodo n = new Nodo(i);
//			int grado = l.size();
//			n.setGrado(grado);
//			n.setAdyacentes(l);
//			nodosPendientes.add(n);
//			i++;
//		}
//		
//		int[] colores = new int[g.length+1];
//		
//		while(!nodosPendientes.isEmpty()) {
//			
//			Nodo actual = nodosPendientes.poll();
//			List<Nodo> adyacentes = actual.getAdyacentes();
//			int[] coloresAux = new int[g.length+1];
//			
//			for(Nodo n : adyacentes)
//				coloresAux[n.getColor()] ++;
//				
//			for(int j = 1; j < coloresAux.length; j ++) {
//				if(coloresAux[j] == 0) {
//					actual.setColor(j);
//					listaAdyacencia;
//					colores[j] ++;
//					break;
//				}
//			}
//			
//		}
//		
//		int numCromatico = 0;
//		
//		for(int j = 1; j < colores.length; j ++) {
//			if(colores[j] > 0) {
//				numCromatico ++;
//			}
//		}
//		
//		return numCromatico; 
//	}
//	
//}


    

