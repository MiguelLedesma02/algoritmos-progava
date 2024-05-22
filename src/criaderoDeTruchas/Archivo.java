package criaderoDeTruchas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	private static File file;
	private static Scanner scanner = null;

	public static List<Estanque> leerArchivoUsuarios() throws IOException {
		List<Estanque> estanques = new ArrayList<Estanque>();

		try {
			file = new File("archivos/in/truchas.in");

			scanner = new Scanner(file);

			scanner.useLocale(Locale.ENGLISH);

			String linea = scanner.nextLine();

			int cantEstanques = scanner.nextInt();

			for (int i = 0; i < cantEstanques; i++) {

				int superficie = scanner.nextInt();
				int profundidad = scanner.nextInt();
				int alturaCanio = scanner.nextInt();

				Estanque estanque = new Estanque(i+1, superficie, profundidad, alturaCanio);

				estanques.add(estanque);
			}
			int volumenAgua = scanner.nextInt();
			int ubicacionVertedero = scanner.nextInt();

			Vertedero vertedero = new Vertedero(volumenAgua, ubicacionVertedero);

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return estanques;
	}
	
	public void generarArchivoSalidaDesborde(int cantMetrosDesborde) {

		try {
			String nombreArchivo = "truchas.out"; 
			FileWriter escritor = new FileWriter(nombreArchivo);

			escritor.write("Hay desborde: "+cantMetrosDesborde +  "\n");

			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo.");
			e.printStackTrace();
		}

	}
	
//	public void generarArchivoSalida(int ) {
//
//		try {
//			String nombreArchivo = "truchas.out"; 
//			FileWriter escritor = new FileWriter(nombreArchivo);
//
//			escritor.write("Hay desborde: "+cantMetrosDesborde +  "\n");
//
//			escritor.close();
//
//		} catch (IOException e) {
//			System.out.println("Error al escribir el archivo.");
//			e.printStackTrace();
//		}
//
//	}
//	
}



