package criaderoDeTruchas;

public class Estanque {
	private int numeroEstanque;
	private int superficie;
	private int profundidad;
	private int volumenMaximo;
	private int volumenCargado;
	private int profundidadCañeriaIzq;
	private int profundidadCañeriaDer;
	private boolean tieneVertedero;
	private int profundidadCargada = volumenCargado / superficie;
	// private Estanque anterior;
	// private Estanque siguiente;

	public Estanque(int numeroEstanque, int superficie, int profundidad, int profundidadCañeriaDer) {

		this.numeroEstanque = numeroEstanque;
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.volumenMaximo = this.superficie * this.profundidad;
		this.volumenCargado = 0;
		this.profundidadCañeriaDer = profundidadCañeriaDer;
		this.tieneVertedero = false;
	}

	public int getNumeroEstanque() {
		return numeroEstanque;
	}

	public int getVolumenMaximo() {
		return volumenMaximo;
	}

	public int getVolumenCargado() {
		return volumenCargado;
	}

	public void setVolumenCargado(int volumenCargado) {
		this.volumenCargado = volumenCargado;
	}

	public int getProfundidadCañeriaIzq() {
		return profundidadCañeriaIzq;
	}

	public void setProfundidadCañeriaIzq(int profundidadCañeriaIzq) {
		this.profundidadCañeriaIzq = profundidadCañeriaIzq;
	}

	public int getProfundidadCañeriaDer() {
		return profundidadCañeriaDer;
	}
	
	public int getProfundidad() {
		return profundidad;
	}
	
	public int getSuperficie() {
		return superficie;
	}

	public boolean estaLleno() {

		return this.volumenMaximo == this.volumenCargado;
	}

	public boolean cañeriaAlcanzada() {

		return this.profundidadCañeriaDer == this.volumenCargado / this.superficie;
	}

	public int getCañeriaMasBaja() {

		if (this.profundidadCañeriaIzq > this.profundidadCañeriaDer && this.profundidadCañeriaIzq > this.profundidadCargada) // viendo desde arriba, la mas profunda va a ser la cañeria mas baja desde el agua
			return this.profundidadCañeriaIzq;

		return this.profundidadCañeriaDer;
		
		//ver ultimo estanque para retornar la cañeria mas baja que seria la izquierda
	}

}
