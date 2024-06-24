package hospital;

import java.util.*;

public class Paciente {

	private String nombre;
	private int edad;
	private List<Afeccion> afecciones;
	private int ordenLlegada;
	
	public Paciente(String nombre, int edad, List<Afeccion> afecciones) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.afecciones = afecciones;
	}
	
	public String getNombre() {		
		return this.nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public List<Afeccion> getAfecciones(){
		return this.afecciones;
	}
	
	public Afeccion getAfeccionMasUrgente() {
		
		int nivel = 6;
		Afeccion afeccionMasUrgente = null;
		
		for (Afeccion afeccion : this.afecciones) {
			
			if(nivel > afeccion.getNivelDeUrgencia().getPrioridad()) {
				nivel = afeccion.getNivelDeUrgencia().getPrioridad();
				afeccionMasUrgente = afeccion;		
			}
		}
		
		return afeccionMasUrgente;
	}
	
	public int getOrdenLlegada() {
		return this.ordenLlegada;
	}
	
	public void setOrdenLlegada(int orden) {
		this.ordenLlegada = orden;
	}
}
