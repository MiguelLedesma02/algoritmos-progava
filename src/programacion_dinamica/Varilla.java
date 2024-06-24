package programacion_dinamica;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Varilla {

	private static int sinPD = 0;
	private static int conPD = 0;
	
	public static void main(String[] args) {
		
		int n1 = 7;
		int n2 = 9;
		int c1[] = {1, 3, 4, 5};
		int c2[] = {5, 6, 1, 4, 2};

		System.out.println("Costo - Llamadas");
		System.out.println(cortarVarillaSinPD(n1, c1) + " - " + sinPD);
		System.out.println(cortarVarillaSinPD(n2, c2) + " - " + sinPD);
		System.out.println(cortarVarillaConPD(n1, c1) + " - " + conPD);
		System.out.println(cortarVarillaConPD(n2, c2) + " - " + conPD);
		
	}

	public static int cortarVarillaSinPD(int n, int[] v) {
		
		List<Integer> c = new ArrayList<>();
		for(int i = 0; i < v.length; i ++)
			c.add(v[i]);		
		
		return cortarVarillaMaskSinPD(n, c);
	}
	
	public static int cortarVarillaConPD(int n, int[] v) {
		
		List<Integer> c = new ArrayList<>();
		for(int i = 0; i < v.length; i ++)
			c.add(v[i]);
		
		Map<Integer, Map<List<Integer>, Integer>> memo = new HashMap<>();		
		
		return cortarVarillaMaskConPD(n, c, memo);
	}
	
	public static int cortarVarillaMaskSinPD(int n, List<Integer> cortes) {
		
		sinPD ++;
	
		//Si no hay cortes por aplicar, el costo es cero
		if(cortes.isEmpty())
			return 0;
		
		int min = Integer.MAX_VALUE;
		int coste = 0;
		for(Integer c : cortes) {
			
			int nIzq = c;
			int nDer = n - c;
			List<Integer> cortesIzq = new ArrayList<>();
			List<Integer> cortesDer = new ArrayList<>();
			
			cortesIzq = recalcularCortes(n, nIzq, cortes, c, true);
			cortesDer = recalcularCortes(n, nDer, cortes, c, false);
			
			coste = cortarVarillaMaskSinPD(nIzq, cortesIzq) + cortarVarillaMaskSinPD(nDer, cortesDer);
			if(coste < min)
				min = coste;
			
		}
		
		return n + min;
	}
	
	public static int cortarVarillaMaskConPD(int n, List<Integer> cortes, Map<Integer, Map<List<Integer>, Integer>> memo) {
		
		conPD ++;
		
		//Si no hay cortes por aplicar, el costo es cero
		if(cortes.isEmpty())
			return 0;
		
		if(memo.containsKey(n) && memo.get(n).containsKey(cortes))
			return memo.get(n).get(cortes);
		
		int min = Integer.MAX_VALUE;
		int coste = 0;
		for(Integer c : cortes) {
			
			int nIzq = c;
			int nDer = n - c;
			List<Integer> cortesIzq = new ArrayList<>();
			List<Integer> cortesDer = new ArrayList<>();
			
			cortesIzq = recalcularCortes(n, nIzq, cortes, c, true);
			cortesDer = recalcularCortes(n, nDer, cortes, c, false);
			
			coste = cortarVarillaMaskConPD(nIzq, cortesIzq, memo) + cortarVarillaMaskConPD(nDer, cortesDer, memo);
			if(coste < min)
				min = coste;
			
		}
		
		if(!memo.containsKey(n)) {
			Map<List<Integer>, Integer> aux = new HashMap<>();
			memo.put(n, aux);			
		}
		
		memo.get(n).put(cortes, n + min);
		
		return n + min;
	}
	
	public static List<Integer> recalcularCortes(int nIni, int nAct, List<Integer> cortes, int c, boolean esIzq) {
		
		int dif = nIni - nAct;
		List<Integer> aux = new ArrayList<>();
		
		for(Integer cAux : cortes) {
			
			//No recalculo el corte ya realizado
			if(cAux == c)
				continue;
			
			if(esIzq && cAux < c)
				aux.add(cAux);
			if(!esIzq && cAux > c)
				aux.add(cAux-dif);
			
		}
		
		return aux;
	}
	
}
