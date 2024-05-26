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

	public static Criadero leerArchivoCriadero() throws IOException {
		List<Estanque> estanques = new ArrayList<Estanque>();
		Criadero criadero = null;
		String fileName = "1680-2";

		try {
			file = new File("./archivos/in/" + fileName + ".in");

			scanner = new Scanner(file);

			scanner.useLocale(Locale.ENGLISH);

			String linea = scanner.nextLine();
			String[] atributos = linea.split("\t");

			int cantEstanques = Integer.parseInt(atributos[0]);
			int i = 1;
			
			for (i = 1; i < cantEstanques; i++) {
				
				linea = scanner.nextLine();
				atributos = linea.split("\t");

				int superficie = Integer.parseInt(atributos[0]);
				int profundidad = Integer.parseInt(atributos[1]);
				int alturaCanio = Integer.parseInt(atributos[2]);

				Estanque estanque = new Estanque(i, superficie, profundidad, alturaCanio);

				estanques.add(estanque);
			}
			
			linea = scanner.nextLine();
			atributos = linea.split("\t");

			int superficie = Integer.parseInt(atributos[0]);
			int profundidad = Integer.parseInt(atributos[1]);
			
			Estanque estanque = new Estanque(i, superficie, profundidad, 0);

			estanques.add(estanque);
			
			linea = scanner.nextLine();
			atributos = linea.split("\t");
			
			int volumenAgua = Integer.parseInt(atributos[0]);
			int ubicacionVertedero = Integer.parseInt(atributos[1]);

			Vertedero vertedero = new Vertedero(volumenAgua, ubicacionVertedero);
			
			criadero = new Criadero(estanques, vertedero);

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return criadero;
	}
	
	public static void generarArchivoSalidaDesborde(int cantMetrosDesborde) {

		try {
			String nombreArchivo = "./archivos/out/truchas.out"; 
			FileWriter escritor = new FileWriter(nombreArchivo);

			escritor.write("Hay desborde: "+ cantMetrosDesborde +  "\n");

			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo.");
			e.printStackTrace();
		}

	}
	
	public static void generarArchivoSalida(List<Estanque> estanques) {

		try {
			String nombreArchivo = "./archivos/out/truchas.out"; 
			FileWriter escritor = new FileWriter(nombreArchivo);

			int cant = 0;
			
			for(Estanque est : estanques) {
				if(est.getNivel() != 0)
					cant ++;
			}
			
			escritor.write(cant + "\n");
			
			for(Estanque est : estanques) {
				if(est.getNivel() != 0)
					escritor.write(est.getNumero() + " " + est.getNivel() + "\n");
			}
			
			
			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo.");
			e.printStackTrace();
		}

	}
	
}



