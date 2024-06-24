package programacion_dinamica;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	private static int fibonacci = 0;
	private static int fiboDinaRecursivo = 0;
	private static int fiboDinaIterativo = 0;

	public static void main(String[] args) {
		
		int n = 10;
		
		System.out.println("Fibonacci" + "(" + n + ")" + " - Llamadas");
		System.out.println(fibonacci(10) + " - " + fibonacci);
		System.out.println(fiboDinamicoRecursivo(10) + " - " + fiboDinaRecursivo);
		System.out.println(fiboDinamicoIterativo(10) + " - " + fiboDinaIterativo);

	}

	public static int fibonacci(int n) {
		
		fibonacci ++;
		
		if(n <= 1)
			return n;
				
		int fibo = fibonacci(n-1) + fibonacci(n-2);
		
		return fibo;
	}
	
	public static int fiboDinamicoRecursivo(int n) {
		
		Map<Integer, Integer> memo = new HashMap<>();
		
		return fiboDinaRecursivoMask(n, memo);
	}
	
	public static int fiboDinaRecursivoMask(int n, Map<Integer, Integer> memo) {
		
		fiboDinaRecursivo ++;
		
		if(memo.containsKey(n))
			return memo.get(n);
		
		if(n <= 1)
			return n;
				
		int fibo = fiboDinaRecursivoMask(n-1, memo) + fiboDinaRecursivoMask(n-2, memo);
		memo.put(n, fibo);
		
		return fibo;
	}
	
	public static int fiboDinamicoIterativo(int n) {
		
		fiboDinaIterativo ++;
		
		Map<Integer, Integer> memo = new HashMap<>();
		
		memo.put(0, 0);
		memo.put(1, 1);
		
		int fibo = 0;
		for(int i = 2; i <= n; i ++) {
			fibo = memo.get(i-1) + memo.get(i-2);
			memo.put(i, fibo);
		}
		
		return memo.get(n);
	}
	
}
