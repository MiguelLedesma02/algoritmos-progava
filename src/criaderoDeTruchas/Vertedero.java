package criaderoDeTruchas;

public class Vertedero {

	private int volAgua;     //En m3
	private int numEstanque;
	
	public Vertedero(int volAgua, int numEstanque) {
		
		this.volAgua = volAgua;
		this.numEstanque = numEstanque;
		
	}

	public int getVolAgua() {
		return this.volAgua;
	}

	public void setVolAgua(int volAgua) {
		this.volAgua = volAgua;
	}

	public int getNumEstanque() {
		return this.numEstanque;
	}
}
