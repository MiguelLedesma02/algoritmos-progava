package hospital;

public class SalaDeEspera {

	private int capacidad;
	private int aforo;
	private MonticuloPaciente cola;
	
	public SalaDeEspera(int capacidad) {
		
		this.capacidad = capacidad;
		this.aforo = 0;
		this.cola = new MonticuloPaciente(this.capacidad);
	}
	
	public MonticuloPaciente getCola() {
		return this.cola;
	}
	
	public void ingresarPaciente(Paciente paciente) {
		
		this.aforo ++;
		paciente.setOrdenLlegada(this.aforo);
		this.cola.agregar(paciente);
	}
	
	public Paciente atenderPaciente() {
		
		return this.cola.eliminar();
	}
}
