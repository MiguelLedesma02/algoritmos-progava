package rescatandoLaPrincesa;

import java.util.*;

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

		int vecCostos[] = new int[bosque.length];
		int vecPredecesores[] = new int[bosque.length];
		List<Integer> claros = new ArrayList<Integer>(bosque.length);

		// Inicializamos costos
		for (int i = 1; i < bosque.length; i++) {
			vecCostos[i] = i != claroPrincesa ? INF : 0;
			if (i != claroPrincesa)
				claros.add(i);
		}

		int claroActual = claroPrincesa;
		while (!claros.isEmpty()) {

			for (int claroAdyacente = 1; claroAdyacente < bosque.length; claroAdyacente++) {
				// Compruebo si de verdad es adyacente
				if (bosque[claroActual][claroAdyacente] != 0) {
					int distanciaCalculada = vecCostos[claroActual] + bosque[claroActual][claroAdyacente];

					if (vecCostos[claroAdyacente] > distanciaCalculada) {
						vecCostos[claroAdyacente] = distanciaCalculada;
						vecPredecesores[claroAdyacente] = claroActual;
					}
				}
			}

			if (claroActual != claroPrincesa)
				claros.remove(claros.indexOf(claroActual));
			
			claroActual = getPosCostoMenorDeClaro(vecCostos, claros);
		}

		// Conseguir costo de camino de princesa a principe
		int costoDePrincipe = vecCostos[claroPrincipe];

		if (costoDePrincipe == INF) {
			System.out.println("NO HAY CAMINO");
			return;
		}

		// Conseguir el menor costo de dragones
		int costoDeDragonMasRapido = INF;
		for (int dragon : dragones) {
			int costoDragon = vecCostos[dragon];
			if (costoDeDragonMasRapido > costoDragon)
				costoDeDragonMasRapido = costoDragon;
		}

		if (costoDeDragonMasRapido < costoDePrincipe) {
			System.out.println("INTERCEPTADO");
			return;
		}

		imprimirCaminoPrincipe(vecPredecesores);
		return;
	}

	private void imprimirCaminoPrincipe(int[] vecPredecesores) {
		int claroActual = claroPrincipe;
		LinkedList<Integer> caminoPrincipeHaciaPrincesa = new LinkedList<Integer>();
		caminoPrincipeHaciaPrincesa.add(claroPrincipe);

		while (caminoPrincipeHaciaPrincesa.getLast() != claroPrincesa) {
			claroActual = vecPredecesores[claroActual];
			caminoPrincipeHaciaPrincesa.addLast(claroActual);
		}

		System.out.println(caminoPrincipeHaciaPrincesa);

	}

	private int getPosCostoMenorDeClaro(int[] vecCostos, List<Integer> claros) {
		if(claros.size() == 0)
			return 0;
		
		int posMenor = claros.get(0);

		for (int i = 1; i < bosque.length; i++) {
			if (claros.contains(i) && vecCostos[i] < vecCostos[posMenor])
				posMenor = i;
		}

		return posMenor;
	}

}
