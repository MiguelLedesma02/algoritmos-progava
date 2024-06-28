package criaderoDeTruchas;

public class Estanque {

	private int numero;
	private int profundidad; // En m
	private int superficie; // En m2
	private int volumen; // En m3
	private int proCañeriaIzq;
	private int proCañeriaDer;
	private int proAgua;
	private int nivel;
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

	public int calcularProCañoMasBajo() {

		// Si el nivel del agua está sobre la cañería mas alta, cargar hasta la
		// superficie
		if (this.proAgua <= this.proCañeriaIzq && this.proAgua <= this.proCañeriaDer)
			return 0;

		return this.proCañeriaIzq > this.proCañeriaDer ? this.proCañeriaIzq : this.proCañeriaDer;
		// return Math.min(this.proCañeriaIzq, this.proCañeriaDer);
	}

	public int llenarEstanque(int volAgua, int proCañoMasBajo) {

		//Este metodo se encarga de actualizar el nivel y la profundidad del agua.
		//Retorna el volumen cargado en este llamado.
		
		//Para ello, requiere saber cuantos niveles se deben cargar, de acuerdo al
		//volumen que venga por parámetro.
		
		int nivelesACargar = volAgua / this.superficie;
		
		//Es importante determinar si la cantidad de niveles supera la altura del
		//siguiente caño (mas bajo).
		
		int volumenCargado = this.nivel * this.superficie;
		int volumenHastaCaño = (this.profundidad - proCañoMasBajo) * this.superficie;
		int volumenDisponible = volumenHastaCaño - volumenCargado;
		int nivelesHastaCaño = volumenDisponible / this.superficie;
		int diferencia = nivelesACargar - nivelesHastaCaño;
		
		//La Profundidad se mide desde arriba hacia abajo.
		//El Nivel se mide desde abajo hacia arriba.		
		//Profundidad Estanque = Profundidad Agua + Nivel Agua
		
		if(diferencia <= 0) {
			//Se carga sólo este Estanque
			this.nivel += nivelesACargar;
			this.proAgua = this.profundidad - this.nivel;
			return nivelesACargar * this.superficie;
		}
		
		//Si Diferencia es positiva, se seguirán cargando estanques
		this.nivel += nivelesHastaCaño;
		this.proAgua = this.profundidad - this.nivel;
		return nivelesHastaCaño * this.superficie;
	}

	public int getNivel() {
		return this.nivel;
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
