package grafos;

import java.util.ArrayList;
import java.util.List;

public class Nodo implements Comparable<Nodo> {

	private int numero;
	private int grado;
	private int color;
	private List<Nodo> adyacentes;
	
	public Nodo(int numero,int grado) {
		
		this.numero = numero;
		this.grado = grado;
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
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
