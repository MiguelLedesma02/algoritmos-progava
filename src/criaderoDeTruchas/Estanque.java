package criaderoDeTruchas;

public class Estanque {

	private int numero;
	private int profundidad; // En m
	private int superficie; // En m2
	private int volumen; // En m3
	private int proCañeriaIzq;
	private int proCañeriaDer;
	private int proAgua;
	private Estanque estanqueIzq;
	private Estanque estanqueDer;

	public Estanque(int numero, int superficie, int profundidad, int proCañeriaDer) {

		this.numero = numero;
		this.profundidad = profundidad;
		this.superficie = superficie;
		this.volumen = this.profundidad * this.superficie;
		this.proCañeriaIzq = 0;
		this.proCañeriaDer = proCañeriaDer;
		this.proAgua = this.profundidad; // Si no hay agua, el nivel está al fondo del estanque
		this.estanqueIzq = null;
		this.estanqueDer = null;

	}

	private int calcularProfundidadMaximaACargar() {

		// Si el nivel del agua está sobre la cañería mas alta, cargar hasta la
		// superficie
		if (this.proAgua <= this.proCañeriaIzq && this.proAgua <= this.proCañeriaDer)
			return 0;

		return this.proCañeriaIzq > this.proCañeriaDer ? this.proCañeriaIzq : this.proCañeriaDer;
		//return Math.min(this.proCañeriaIzq, this.proCañeriaDer);
	}

	public int llenarEstanque(int volAgua) {

		int profundidadMaxima = this.calcularProfundidadMaximaACargar();
		int profundidadACargar = volAgua / this.superficie;

		int excedente = profundidadACargar - profundidadMaxima;

		// Hay excedente, se retorna solo lo cargado
		if (excedente > 0) {
			this.proAgua = profundidadMaxima;
			return (this.profundidad - profundidadMaxima) * this.superficie;
		}

		// No hay excedente, se cargó toda el agua y se retorna lo cargado
		this.proAgua = profundidadACargar;
		return profundidadACargar * this.superficie;

	}

	public int getProCañeriaIzq() {
		return this.proCañeriaIzq;
	}

	public void setProCañeriaIzq(int proCañeriaIzq) {
		this.proCañeriaIzq = proCañeriaIzq;
	}

	public int getProCañeriaDer() {
		return this.proCañeriaDer;
	}

	public void setProCañeriaDer(int proCañeriaDer) {
		this.proCañeriaDer = proCañeriaDer;
	}

	public int getNumero() {
		return this.numero;
	}

	public int getProfundidad() {
		return this.profundidad;
	}

	public int getSuperficie() {
		return this.superficie;
	}

	public int getVolumen() {
		return this.volumen;
	}

	public int getProAgua() {
		return this.proAgua;
	}

	public Estanque getEstanqueIzq() {
		return this.estanqueIzq;
	}

	public void setEstanqueIzq(Estanque estanqueIzq) {
		this.estanqueIzq = estanqueIzq;
	}

	public Estanque getEstanqueDer() {
		return this.estanqueDer;
	}

	public void setEstanqueDer(Estanque estanqueDer) {
		this.estanqueDer = estanqueDer;
	}

}
