package hospital;

public class NivelDeUrgencia {

	private int prioridad;
	private String descripcion;
	
	public NivelDeUrgencia(int prioridad) {
		
		if(prioridad < 1 || prioridad > 5) {
			//Arrojar una excepcion
		}
			
		this.prioridad = prioridad;
		
		switch(prioridad) {
		case 1:
			this.descripcion = "Resuscitation";
		case 2:
			this.descripcion = "Emergent";
		case 3:
			this.descripcion = "Urgent";
		case 4:
			this.descripcion = "Less Urgent";
		case 5:
			this.descripcion = "Non Urgent";
		}
	}
	
	public int getPrioridad() {
		return this.prioridad;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
