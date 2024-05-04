package hospital;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		NivelDeUrgencia nivel1 = new NivelDeUrgencia(1);
		NivelDeUrgencia nivel3 = new NivelDeUrgencia(3);
		NivelDeUrgencia nivel4 = new NivelDeUrgencia(4);
		NivelDeUrgencia nivel5 = new NivelDeUrgencia(5);
		
		Afeccion afeccion1 = new Afeccion("Resfrio", nivel5);
		Afeccion afeccion2 = new Afeccion("Catarro", nivel4);
		Afeccion afeccion3 = new Afeccion("Gripe", nivel3);
		Afeccion afeccion5 = new Afeccion("Pulmonia", nivel1);
		
		List<Afeccion> listaAfecciones1 = new ArrayList<>();
		List<Afeccion> listaAfecciones2 = new ArrayList<>();
		List<Afeccion> listaAfecciones3 = new ArrayList<>();
		List<Afeccion> listaAfecciones4 = new ArrayList<>();
		
		listaAfecciones1.add(afeccion1);
		listaAfecciones1.add(afeccion2);
		listaAfecciones2.add(afeccion2);
		listaAfecciones2.add(afeccion3);
		listaAfecciones3.add(afeccion5);
		listaAfecciones4.add(afeccion1);
		
		Paciente paciente1 = new Paciente("Horacio", 50, listaAfecciones1); // 4
		Paciente paciente2 = new Paciente("Silvio", 50, listaAfecciones2); // 3
		Paciente paciente3 = new Paciente("Roberto", 50, listaAfecciones3); // 1
		Paciente paciente4 = new Paciente("Julio", 50, listaAfecciones4); // 5
		Paciente paciente5 = new Paciente("Humberto", 50, listaAfecciones4); // 5
		Paciente paciente6 = new Paciente("Hector", 50, listaAfecciones3); // 1
	
		SalaDeEspera sala = new SalaDeEspera(31);
		
		sala.ingresarPaciente(paciente1);
		sala.ingresarPaciente(paciente2);
		sala.ingresarPaciente(paciente3);
		sala.ingresarPaciente(paciente4);
		sala.ingresarPaciente(paciente5);
		sala.ingresarPaciente(paciente6);

		
		System.out.println("Paciente " + sala.atenderPaciente().getNombre());
		System.out.println("Paciente " + sala.atenderPaciente().getNombre());
		System.out.println("Paciente " + sala.atenderPaciente().getNombre());
		System.out.println("Paciente " + sala.atenderPaciente().getNombre());
		System.out.println("Paciente " + sala.atenderPaciente().getNombre());
		System.out.println("Paciente " + sala.atenderPaciente().getNombre());
	}

}
