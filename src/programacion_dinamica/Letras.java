package programacion_dinamica;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class Letras {

	private static int sinPD = 0;
	private static int conPD = 0;
	
	public static void main(String[] args) {
		
		String w1 = "inside";
		String w2 = "index";
		String w3 = "Miguel";
		String w4 = "Independiente";
		HashMap<SimpleEntry<String, String>, Integer> memo = new HashMap<>();
		
		System.out.println("SIN PD - " + lev(w3, w4) + " - " + sinPD);
		System.out.println("CON PD - " + lev(w3, w4, memo) + " - " + conPD);

		
	}
	
	public static int lev(String w1, String w2) {
		
		sinPD ++;
		
		int lev = Integer.MAX_VALUE;
		
		if(w2.length() == 0)
			return w1.length();
		
		if(w1.length() == 0)
			return w2.length();
		
		char head1 = w1.charAt(0);
		char head2 = w2.charAt(0);
		String tail1 = w1.substring(1);
		String tail2 = w2.substring(1);
		
		if(head1 == head2)
			return lev(tail1, tail2);
		
		int aux = 0;
		
		aux = lev(w1, tail2);
		if(aux < lev)
			lev = aux;
		
		aux = lev(tail1, w2);
		if(aux < lev)
			lev = aux;
		
		aux = lev(tail1, tail2);
		if(aux < lev)
			lev = aux;		
		
		return 1 + lev;
	}
	
	public static int lev(String w1, String w2, HashMap<SimpleEntry<String, String>, Integer> memo) {
		
		conPD ++;
		
		int lev = Integer.MAX_VALUE;
		
		SimpleEntry<String, String> key = new SimpleEntry<>(w1, w2);
		if(memo.containsKey(key))
			return memo.get(key);
		
		if(w2.length() == 0) {
			memo.put(key, w1.length());
			return memo.get(key);
		}
		
		if(w1.length() == 0) {
			memo.put(key, w2.length());		
			return memo.get(key);			
		}
		
		char head1 = w1.charAt(0);
		char head2 = w2.charAt(0);
		String tail1 = w1.substring(1);
		String tail2 = w2.substring(1);
		
		if(head1 == head2) {
			memo.put(key, lev(tail1, tail2, memo));
			return memo.get(key);
		}
		
		int aux = 0;
		
		aux = lev(w1, tail2, memo);
		if(aux < lev)
			lev = aux;
		
		aux = lev(tail1, w2, memo);
		if(aux < lev)
			lev = aux;
		
		aux = lev(tail1, tail2, memo);
		if(aux < lev)
			lev = aux;		
		
		memo.put(key, 1 + lev);
		
		return memo.get(key);
	}
	
	
}
