package parque;

public class Arista implements Comparable<Arista>{

	private int nodo1;
	private int nodo2;
	private int costo;
	
	public Arista(int n1, int n2, int c) {
		
		this.nodo1 = n1;
		this.nodo2 = n2;
		this.costo = c;
	}
	
	public int getNodo1() {
		return this.nodo1;
	}
	
	public int getNodo2() {
		return this.nodo2;
	}
	
	public int getCosto() {
		return this.costo;
	}
	
    public int compareTo(Arista otra) {
        return Integer.compare(this.costo, otra.costo);
    }
}
