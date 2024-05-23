package rescatandoLaPrincesa;

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

	public static Bosque leerArchivo() throws IOException {

		Bosque bosque = null;
		int[] dragones;
		int[][] claros;
		
		try {
			file = new File("Archivos/princesa.in");
			
			scanner = new Scanner(file);
			
			scanner.useLocale(Locale.ENGLISH);
			
			//Leer primera linea
			String linea = scanner.nextLine();
			String[] atributos = linea.split("\t");
			
			int cantidadClaros = Integer.parseInt(atributos[0]);
			int cantidadSenderos = Integer.parseInt(atributos[1]); 
			int cantidadDragones = Integer.parseInt(atributos[2]); 
			
			//Leer segunda linea
			linea = scanner.nextLine();
			atributos = linea.split("\t");
			
			int claroPrincesa = Integer.parseInt(atributos[0]);
			int claroPrincipe = Integer.parseInt(atributos[1]); 
		
			//Leer linea de dragones
			linea = scanner.nextLine();
			atributos = linea.split("\t");
			
			dragones = new int[atributos.length];
			for(int i = 0; i < atributos.length; i ++) {
				dragones[i] = Integer.parseInt(atributos[i]);
			}
			
			claros = new int[cantidadClaros][cantidadClaros];
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				atributos = linea.split("\t");
				
				int claroInicial = Integer.parseInt(atributos[0]);
				int claroFinal = Integer.parseInt(atributos[1]);
				int largoDelSendero = Integer.parseInt(atributos[2]);
				
				claros[claroInicial-1][claroFinal-1] = largoDelSendero;
			}
			
			bosque = new Bosque(dragones, claros, claroPrincipe, claroPrincesa);
			

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		return bosque;
	}
	
}


