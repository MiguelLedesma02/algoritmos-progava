package criaderoDeTruchas;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Criadero criadero;
		
		criadero = Archivo.leerArchivoUsuarios();
		
		criadero.llenar();

	}

}
