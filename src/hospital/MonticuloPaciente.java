package hospital;

public class MonticuloPaciente {

	private int tope = 1;
	private Paciente[] vec;

	public MonticuloPaciente(int tam) {
		this.vec = new Paciente[tam];
	}

	public void agregar(Paciente x) {

		int actualIndex, padreIndex;
		int prioridadActual = 0, prioridadPadre = 0;

		// Agrego el elemento en la primera posición libre
		this.vec[this.tope] = x;

		actualIndex = this.tope;
		padreIndex = this.tope / 2;
		prioridadActual = vec[actualIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();
		
		if(padreIndex > 0)
			prioridadPadre = vec[padreIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();

		while (padreIndex > 0 && prioridadPadre > prioridadActual) {
			this.intercambiar(padreIndex, actualIndex);

			actualIndex = padreIndex;
			padreIndex = padreIndex / 2;
			prioridadActual = vec[actualIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();
			if(padreIndex > 0)
				prioridadPadre = vec[padreIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();
		}

		this.tope++;

		return;
	}

	public Paciente eliminar() { //Si no hay nada para eliminar, tirar error

		Paciente raiz;
		int actualIndex, hijoIzqIndex, hijoDerIndex, menorIndex;
		int prioridadActual, prioridadMenor;
	
		raiz = vec[1];
		
		// Llevo a la raiz al ultimo elemento agregado
		vec[1] = vec[this.tope - 1];

		actualIndex = 1;
		hijoIzqIndex = 2 * actualIndex;
		hijoDerIndex = 2 * actualIndex + 1;
		
		this.tope--;

		
		while (hijoIzqIndex < this.tope) {
			
			prioridadActual = vec[actualIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();

			menorIndex = this.determinarMenor(hijoIzqIndex, hijoDerIndex);
			prioridadMenor = vec[menorIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();
			
			if (prioridadActual > prioridadMenor ||
				(prioridadActual == prioridadMenor && vec[actualIndex].getOrdenLlegada() > vec[menorIndex].getOrdenLlegada())) {
				this.intercambiar(actualIndex, menorIndex);
			}
			
			actualIndex = menorIndex;
			hijoIzqIndex = 2 * actualIndex;
			hijoDerIndex = 2 * actualIndex + 1;
		}


		return raiz;
	}

	public void recorrer() {

		for (int i = 1; i < this.tope; i++) {
			System.out.println(vec[i]);
		}
	}
	
	private void intercambiar(int actualIndex, int auxIndex) {
		Paciente aux;
		
		aux = vec[auxIndex];
		vec[auxIndex] = vec[actualIndex];
		vec[actualIndex] = aux;
	}
	
	private int determinarMenor(int hijoIzqIndex, int hijoDerIndex) {
		
		int menorIndex;
		int prioridadHijoIzq, prioridadHijoDer;
		
		prioridadHijoIzq = vec[hijoIzqIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();
		if(hijoDerIndex < this.tope)
			prioridadHijoDer = vec[hijoDerIndex].getAfeccionMasUrgente().getNivelDeUrgencia().getPrioridad();
		else
			prioridadHijoDer = 5;
		
		if (hijoIzqIndex+1 < this.tope && 
			prioridadHijoDer < prioridadHijoIzq ||
			(prioridadHijoDer == prioridadHijoIzq && vec[hijoDerIndex].getOrdenLlegada() < vec[hijoIzqIndex].getOrdenLlegada())) {
			menorIndex = hijoDerIndex;
		}
		else {
			menorIndex = hijoIzqIndex;
		}

		return menorIndex;
	}

}
