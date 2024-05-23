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

		// ver cañeria derecha en ultimo estanque
		// nos fijamos si es el ultimo por el indice y en cañeriaDer = 0?

		
		//Al ser el primer estanque, no hay cañeríaIzq, por eso la profundidad es cero.
		int profundidadCañeriaIzq = 0;
		
		//Por cada estanque, se setea la profundidad de la cañeriaIzq.
		for (Estanque estanque : this.estanques) {

			estanque.setProfundidadCañeriaIzq(profundidadCañeriaIzq);
			
			//La profundidad de la cañeríaDer del estanque actual es la misma que la de 
			//la cañeríaIzq del estanque siguiente.
			profundidadCañeriaIzq = estanque.getProfundidadCañeriaDer();
		}

	}

	public void llenarSiguiente(Estanque estanque, int index) {
		
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
		estanque = estanques.get(indice + index);
		
	}
	
	public void llenar() {

		Archivo archivo = new Archivo();

		int maximaCapacidadEstanques = 0;

		// Guardamos la capacidad máxima de todos los estanques
		for (Estanque estanque : this.estanques) {
			maximaCapacidadEstanques += estanque.getVolumenMaximo();
		}

		// Veo si hay desborde
		if (maximaCapacidadEstanques > vertedero.getVolumenDeAgua()) {
			int volumenDesborde = maximaCapacidadEstanques - vertedero.getVolumenDeAgua();
			archivo.generarArchivoSalidaDesborde(volumenDesborde);

			return;
		}

		// Se asignan las profundidades de las cañeriasIzq de todos los estanques
		this.asignarCañerias();

		//Trae el estanque que tiene el vertedero
		Estanque estanque = estanques.get(vertedero.getUbicacion());

		//Mientras haya agua
		while (vertedero.getVolumenDeAgua() > 0) {

			//Si el estanque no está lleno
			if (!estanque.estaLleno()) {

				int cañeriaMasBaja = estanque.getCañeriaMasBaja();

			int profAguaEstanque = estanque.getVolumenCargado()/estanque.getProfundidad();
			if(estanque.getProfundidadCañeriaDer() == cañeriaMasBaja && profAguaEstanque == cañeriaMasBaja)
				this.llenarSiguiente(estanque, 1);
			else
				this.llenarSiguiente(estanque, -1);
			
			}
		}

	}
}