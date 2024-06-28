package criaderoDeTruchas;

import java.util.*;

public class Criadero {

	private List<Estanque> estanques = new ArrayList<Estanque>();
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

	private void imprimirEstanquesCargados() {
		for (Estanque est : this.estanques)
			if (est.getProAgua() != est.getProfundidad())
				System.out.println("Estanque [" + est.getNumero() + "] = " + est.getNivel());
	}

	public int llenar() {
		
		int diferencia = this.capacidad - this.vertedero.getVolAgua();
		
		if (diferencia < 0)
			return diferencia*-1;

		int volCargado = 0;
		int volAgua = this.vertedero.getVolAgua(); // Determinamos el agua a cargar
		
		// Obtenemos estanque con vertedero
		int posicionDelVertedero = this.vertedero.getNumEstanque() - 1;
		Estanque estanqueConVertedero = estanques.get(posicionDelVertedero);
		
		while (volAgua > 0) {

			// Cargar estanque hasta cañeria mas profunda
			int proCañoMasBajo = estanqueConVertedero.calcularProCañoMasBajo();
			volCargado = estanqueConVertedero.llenarEstanque(volAgua, proCañoMasBajo);

			// Restamos el agua ya cargada del vertedero
			volAgua -= volCargado;

			// Verificamos si se puede cargar múltiples estanques en simultáneo
			int superficieTotal = 0;
			List<Estanque> estanquesPorCargar = new ArrayList<Estanque>();

			for (Estanque estanque : this.estanques) {

				boolean debeCargarseEstanque = estanque.getProAgua() == estanqueConVertedero.getProAgua();

				if (debeCargarseEstanque) {
					estanquesPorCargar.add(estanque);
					superficieTotal += estanque.getSuperficie();
				}
			}

			int cantidadDeEstanquesPorCargar = estanquesPorCargar.size();
			boolean cargaMultiple = cantidadDeEstanquesPorCargar > 1;

			if (cargaMultiple) {
				if (volAgua >= superficieTotal) {

					Estanque auxIzq = estanquesPorCargar.get(0);
					Estanque auxDer = estanquesPorCargar.get(estanquesPorCargar.size() - 1);
					int proCañoIzq = auxIzq.getProCañeriaIzq();
					int proCañoDer = auxDer.getProCañeriaDer();
					int profundidadMaxima = Math.max(proCañoIzq, proCañoDer);

					int bloquesACargar = volAgua / superficieTotal;
					int volCargadoAux = 0;
					for (Estanque est : estanquesPorCargar) {
						estanqueConVertedero = est;
						int vol = est.getSuperficie() * bloquesACargar;
						volCargadoAux += est.llenarEstanque(vol, profundidadMaxima);
					}

					volAgua -= volCargadoAux;
					
					if(auxIzq.getProCañeriaIzq() == estanqueConVertedero.getProAgua())
						estanqueConVertedero = auxIzq;
					else
						estanqueConVertedero = auxDer;
				}
			}

			Estanque estIzq = estanqueConVertedero.getEstanqueIzq();
			Estanque estDer = estanqueConVertedero.getEstanqueDer();

			// Carga individual
			if (estIzq != null && estIzq.getProAgua() != estanqueConVertedero.getProAgua()) {
				if (estanqueConVertedero.getProAgua() == estanqueConVertedero.getProCañeriaIzq()) {
					estanqueConVertedero = estIzq;
				} else if (estanqueConVertedero.getProAgua() == estanqueConVertedero.getProCañeriaDer()) {
					estanqueConVertedero = estDer;
				}
			} else {
				estanqueConVertedero = estDer;
			}

			// Verificamos si se puede cargar un m3 de agua completo
			if (estanqueConVertedero != null
					&& volAgua < estanqueConVertedero.getSuperficie() * estanqueConVertedero.getProCañeriaDer()
					&& volAgua < estanqueConVertedero.getSuperficie() * estanqueConVertedero.getProCañeriaIzq()) {
				break;
			}
		}
		
		return 0;
	}
	
	public List<Estanque> getEstanques(){
		return this.estanques;
	}
}
