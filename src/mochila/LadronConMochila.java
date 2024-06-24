package mochila;

	import java.util.HashMap;
	import java.util.AbstractMap.SimpleEntry;
	 
	public class LadronConMochila {
	 
		public static void main(String[] args) {
	 
			int[] pesoElementos = { 3, 3, 1 };
			int[] precioElementos = { 200, 300, 150 };
			int capacidad = 4;
			int total = 0;
	 
			total = robarCasas(pesoElementos, precioElementos, capacidad);
	 
			System.out.println(total);
	 
		}
	 //TOP DOWN
		public static int robarCasas(int[] pesoElementos, int[] precioElementos, int capacidad) {
	 
			int nivel = 0;
			int acum = 0;
			HashMap<SimpleEntry<Integer, Integer>, Integer> hash = new HashMap<>();
	 
			return robarCasas(nivel, hash, pesoElementos, precioElementos, capacidad, acum);
		}
	 
		private static int robarCasas(int nivel, HashMap<SimpleEntry<Integer, Integer>, Integer> capaNivel,
				int[] pesoElementos, int[] precioElementos, int capacidad, int acum) {
	 
			SimpleEntry<Integer, Integer> key = new SimpleEntry<>(capacidad, nivel);
	 
			if (capaNivel.containsKey(key))
				return capaNivel.get(key);
	 
			if (nivel == precioElementos.length || capacidad == 0) {
				capaNivel.put(key, 0);
			} else {
				// Si el peso del elemento actual es mayor que la capacidad restante, no se
				// puede robar
				if (pesoElementos[nivel] > capacidad) {
					acum = robarCasas(nivel + 1, capaNivel, pesoElementos, precioElementos, capacidad, acum);
				} else {
					acum = Integer.max(robarCasas(nivel + 1, capaNivel, pesoElementos, precioElementos, capacidad, acum),
							precioElementos[nivel] + robarCasas(nivel + 1, capaNivel, pesoElementos, precioElementos,
									capacidad - pesoElementos[nivel], acum));
				}
			}
	 
			capaNivel.put(key, acum);
	 
			return acum;
		}
		
		//BOTTOM UP
		
		private static int robarCasasBottomUp(int[] pesoElementos, int[] precioElementos, int capacidad) {
			int i = pesoElementos.length;			
			int[][] resultante= new int [i][capacidad];
			
			return 1;
		}
	}

