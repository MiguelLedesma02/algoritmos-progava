package criaderoDeTruchas;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int tuvoExito;
		Criadero criadero;
		
		criadero = Archivo.leerArchivoCriadero();
		
		tuvoExito = criadero.llenar();
		
		System.out.println("Estimados,");
		System.out.println("La ejecución a finalizado con exito. "
				         + "Puede encontrar la respuesta en el archivo "
				         + "Truchas.out");
		System.out.println("Saludos. Integrantes Grupo 2.");
		
		if(tuvoExito == 0)
			Archivo.generarArchivoSalida(criadero.getEstanques());
		else
			Archivo.generarArchivoSalidaDesborde(tuvoExito);
	}
}
