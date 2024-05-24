package criaderoDeTruchas;

import java.util.*;

public class Criadero {

	private List<Estanque> estanques = new ArrayList();
	private Vertedero vertedero;
	private int capacidad; // En m3

	public Criadero(List<Estanque> estanques, Vertedero vertedero) {

		this.estanques = estanques;
		this.vertedero = vertedero;
		this.capacidad = this.calcularCapacidadCriadero();

		// Completar la profundidad de la cañeriaIzq de cada estanque
		this.calcularCañeriaIzqEstanque();

		// Completar estanques adyacentes
		this.completarEstanquesAdyacentes();

	}

	private int calcularCapacidadCriadero() {

		int capacidad = 0;

		for (Estanque estanque : this.estanques)
			capacidad += estanque.getVolumen();

		return capacidad;

	}

	private void calcularCañeriaIzqEstanque() {

		int proCañeriaIzq = 0;

		// El primer estanque no tiene cañeriaIzq, por lo que es lo mismo que este a 0m
		for (Estanque estanque : this.estanques) {
			estanque.setProCañeriaIzq(proCañeriaIzq);

			// La cañeriaDer de este estanque es la cañeriaIzq del siguiente
			proCañeriaIzq = estanque.getProCañeriaDer();
		}

	}

	private void completarEstanquesAdyacentes() {

		Estanque estanqueIzq = null;
		Estanque estanqueDer = null;

		// El primer estanque no tiene estanqueIzq, por lo que es null
		for (Estanque estanque : this.estanques) {

			estanque.setEstanqueIzq(estanqueIzq);

			// Este estanque es el estanqueIzq del siguiente
			estanqueIzq = estanque;

			// Este estanque es el estanqueDer del anterior
			estanqueDer = estanque;

			if (estanque.getEstanqueIzq() != null)
				estanque.getEstanqueIzq().setEstanqueDer(estanqueDer);
		}

	}

	public void llenarCriadero() {

		int diferencia = this.capacidad - this.vertedero.getVolAgua();

		if (diferencia < 0) {
			System.out.println("Hay desborde. El excedente es: " + (diferencia*-1));
			return;
		}

		// El criadero puede llenarse sin desbordar

		// Determinamos el agua a cargar
		int volAgua = this.vertedero.getVolAgua();
		int volCargado = 0;

		int numEstVertedero = this.vertedero.getNumEstanque();
		Estanque estanque = estanques.get(numEstVertedero-1);

		while (volAgua > 0) {

			// Cargar estanque hasta cañeria mas profunda
			volCargado = estanque.llenarEstanque(volAgua);

			// Restamos el agua ya cargada del vertedero
			this.vertedero.setVolAgua(volAgua - volCargado);

			Estanque estIzq = estanque.getEstanqueIzq();
			Estanque estDer = estanque.getEstanqueDer();
			
			if(estanque.getProAgua() == estanque.getProCañeriaIzq())
				estanque = estIzq;
			else if(estanque.getProAgua() == estanque.getProCañeriaDer())
				estanque = estDer;

		}
		
		for(Estanque est : this.estanques) {
			System.out.println("Estanque [" + est.getNumero() + "] = " + est.getProAgua());
		}
	}
}
