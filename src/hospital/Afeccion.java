package hospital;

public class Afeccion {
	
	private String nombre;
	private NivelDeUrgencia nivelDeUrgencia;
	
	public Afeccion(String nombre, NivelDeUrgencia nivelDeUrgencia) {
		
		this.nombre = nombre;
		this.nivelDeUrgencia = nivelDeUrgencia;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public NivelDeUrgencia getNivelDeUrgencia() {
		return this.nivelDeUrgencia;
	}

}
