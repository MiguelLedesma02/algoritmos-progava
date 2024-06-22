package grafos;

import java.util.*;

public class Nodo implements Comparable<Nodo> {

	private int numero;
	private int grado;
	private int color;
	private List<Nodo> adyacentes;
	
	public Nodo(int numero) {
		
		this.numero = numero;
		this.grado = 0;
		this.color = 0;
		adyacentes = new ArrayList<>();
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getGrado() {
		return this.grado;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public List<Nodo> getAdyacentes() {
		return this.adyacentes;
	}
	
	public void setGrado(int grado) {
		this.grado = grado;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public void setAdyacentes(List<Nodo> adyacentes) {
		this.adyacentes = adyacentes;
	}
	
	@Override
	public int compareTo(Nodo o) {
		
		int diferencia = 0;
		
		diferencia = (this.grado - o.grado)*-1;
		
		return diferencia;
	}
	
	public void incrementarGrado() {
		this.grado++;
	}
	
	
}
