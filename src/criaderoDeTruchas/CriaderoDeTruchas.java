package criaderoDeTruchas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriaderoDeTruchas {

	private Vertedero vertedero;
	private List<Estanque> estanques;

	CriaderoDeTruchas(List<Estanque> estanques) {

		this.estanques = new ArrayList<Estanque>();
		try {
			this.estanques = estanques;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void asignarCañerias() {

		//ver cañeria derecha en ultimo estanque
		// nos fijamos si es el ultimo por el indice y en cañeriaDer = 0?
		
		int profundidadCañeriaIzq = 0;
		for (Estanque estanque : this.estanques) {

			estanque.setProfundidadCañeriaIzq(profundidadCañeriaIzq);
			profundidadCañeriaIzq = estanque.getProfundidadCañeriaDer();
		}

	}

	public void llenar() {

		Archivo archivo = new Archivo();

		int maximaCapacidadEstanques = 0;

		for (Estanque estanque : this.estanques) {
			maximaCapacidadEstanques += estanque.getVolumenMaximo();
		}

		if (maximaCapacidadEstanques <= vertedero.getVolumenDeAgua()) { // veo si hay desborde
			this.asignarCañerias();

			Estanque estanque = estanques.get(vertedero.getUbicacion());

			while (vertedero.getVolumenDeAgua() > 0) {

				if (!estanque.estaLleno()) {

					int cañeriaMasBaja = estanque.getCañeriaMasBaja();
					if (cañeriaMasBaja == estanque.getProfundidadCañeriaDer()) {
						// Te vas a la der
						int volumenCargado = 0;
						if (vertedero.getVolumenDeAgua() >= estanque.getVolumenMaximo()) {
							volumenCargado = (estanque.getProfundidad() - estanque.getProfundidadCañeriaDer())
									* estanque.getSuperficie();
						} else {
							volumenCargado = vertedero.getVolumenDeAgua();
						}

						estanque.setVolumenCargado(volumenCargado);
						vertedero.setVolumenDeAgua(vertedero.getVolumenDeAgua() - volumenCargado);

						int indice = estanques.indexOf(estanque);
						estanque = estanques.get(indice + 1);

					} else {
						// Te vas a la izq
						int volumenCargado = 0;
						if (vertedero.getVolumenDeAgua() >= estanque.getVolumenMaximo()) {
							volumenCargado = (estanque.getProfundidad() - estanque.getProfundidadCañeriaIzq())
									* estanque.getSuperficie();
						} else {
							volumenCargado = vertedero.getVolumenDeAgua();
						}

						estanque.setVolumenCargado(volumenCargado);
						vertedero.setVolumenDeAgua(vertedero.getVolumenDeAgua() - volumenCargado);

						int indice = estanques.indexOf(estanque);
						estanque = estanques.get(indice - 1);
					}

				}
			}
		} else {
			int volumenDesborde = maximaCapacidadEstanques - vertedero.getVolumenDeAgua();
			archivo.generarArchivoSalidaDesborde(volumenDesborde);

		}

	}
}
