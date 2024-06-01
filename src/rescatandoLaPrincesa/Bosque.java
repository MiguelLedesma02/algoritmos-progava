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

		this.bosque = bosque;
		this.dragones = dragones;
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

		int vecCostos[] = new int[bosque.length + 1];
		int vecPredecesores[] = new int[bosque.length];

		// Inicializamos costos y predecesores
		for (int i = 1; i <= bosque.length - 1; i++) {
			if (i != claroPrincipe) {
				vecPredecesores[i] = INF;
				vecCostos[i] = bosque[claroPrincipe][i] == 0 ? INF : bosque[claroPrincipe][i];
			}
		}

		// Buscamos el camino más corto desde la princesa
		

		return;
	}

}
