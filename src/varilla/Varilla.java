package varilla;

import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;

public class Varilla {

	public static void main(String[] args) {

		int varilla = 7; // va de 0 a 7
		int[] cortes = { 1, 3, 4, 5 };

		int costo = corteVarilla(varilla, cortes);

		System.out.println(costo);

	}

	public static int corteVarilla(int varilla, int[] cortes) {
		// restricciones
		int cantCortes = cortes.length;
		if (varilla < 2 || varilla >= 1000000 || cantCortes < 1 || cortes.length > 100) {
			return -1;
		}

		int[] cortesExt = new int[cortes.length + 2];
		cortesExt[0] = 0;
		cortesExt[cortesExt.length - 1] = varilla;

		System.arraycopy(cortes, 0, cortesExt, 1, cantCortes);

		// int[][] matrizCortes = new int[cortesExt.length][cortesExt.length];

		HashMap<SimpleEntry<Integer, Integer>, Integer> hash = new HashMap<>();

		return corteVarilla(cortesExt, 0, cortesExt.length - 1, hash);

	}

	private static int corteVarilla(int[] cortes, int izq, int der,
			HashMap<SimpleEntry<Integer, Integer>, Integer> mapaDeCortes) {

		SimpleEntry<Integer, Integer> key = new SimpleEntry<>(izq, der);

		if (der - izq <= 1) {
			return 0;
		}

		if (mapaDeCortes.containsKey(key)) {
			return mapaDeCortes.get(key);
		}

		int costoMin = Integer.MAX_VALUE;

		for (int i = izq + 1; i < der; i++) {
			int costo = cortes[der] - cortes[izq] + corteVarilla(cortes, izq, i, mapaDeCortes)
					+ corteVarilla(cortes, i, der, mapaDeCortes);

			costoMin = Math.min(costoMin, costo);
		}

		mapaDeCortes.put(key, costoMin);

		return costoMin;
	}

}
