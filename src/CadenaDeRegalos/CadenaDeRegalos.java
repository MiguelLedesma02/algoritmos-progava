package CadenaDeRegalos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadenaDeRegalos {

	public static void main(String[] args) {

		int[][] matrizAdyacencia = leerArchivo();
		//imprimirMatriz(matrizAdyacencia);
		Welsh_Powell grafo = new Welsh_Powell(matrizAdyacencia);
		int[] resultadoColoreo = grafo.colorGraph();
		int[] resultado = procesarColoreo(resultadoColoreo);
		grabarArchivo(resultado);

	}

	public static int[] procesarColoreo(int[] vec) {

	    int max = 0;

	    for (int i = 0; i < vec.length; i++) { // Obtengo la cantidad de colores
	        if (max < vec[i]) {
	            max = vec[i];
	        }
	    }

	    int[] colores = new int[max + 1];

	    for (int i = 0; i < vec.length; i++) { // Cuantos nodos hay con cada color
	        colores[vec[i]] += 1;
	    }

	    int colorMaximo = 0;
	    int color = -1;
	    for (int i = 0; i < colores.length; i++) { // Obtengo que color aparece mas y el nro de color
	        if (colorMaximo < colores[i]) {
	            colorMaximo = colores[i];
	            color = i;
	        }
	    }

	    List<Integer> resultado = new ArrayList<Integer>();

	    for (int i = 0; i < vec.length; i++) {
	        if (vec[i] == color) {
	            resultado.add(i+1);
	        }
	    }

	    int[] res = resultado.stream().mapToInt(Integer::intValue).toArray();

	    return res;
	}


	public static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void grabarArchivo(int[] vec) {
		int tam = vec.length;

		String rutaArchivo = "../Guia_PAvanzada/src/CadenaDeRegalos/REGALOS.OUT";

		try {
			PrintWriter writer = new PrintWriter(new File(rutaArchivo));

			writer.println(tam);
			for (int i = 0; i < tam; i++) {
				writer.print(vec[i] + " ");
			}

			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("No se pudo encontrar el archivo: " + e.getMessage());
		}
	}

	public static int[][] leerArchivo() {
		int[][] matrizAdyacencia = null;
		try {

			File archivo = new File("../Guia_PAvanzada/src/CadenaDeRegalos/REGALOS.IN");

			Scanner scanner = new Scanner(archivo);

			int tam = scanner.nextInt();
			scanner.nextLine();
			matrizAdyacencia = new int[tam][tam];

			for (int i = 0; i < tam; i++) {
				String linea = scanner.nextLine();
				String[] partes = linea.split(" ");
				int nodo = Integer.parseInt(partes[0]) - 1;

				for (int j = 1; j < partes.length - 1; j++) {
					int conectado = Integer.parseInt(partes[j]) - 1;
					matrizAdyacencia[nodo][conectado] = 1;
					matrizAdyacencia[conectado][nodo] = 1;
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado: " + e.getMessage());
		}
		return matrizAdyacencia;
	}

}
