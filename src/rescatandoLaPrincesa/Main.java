package rescatandoLaPrincesa;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Bosque bosque = null;
		
		try {
			bosque = Archivo.leerArchivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int claros[][] = new int[bosque.getBosque().length][bosque.getBosque().length];
		claros = bosque.getBosque();
		
		for(int i=0; i < claros.length; i ++) {
			for(int j=0; j < claros.length; j ++) {
				if(claros[i][j] != 0) {
					System.out.println("Inicial: " + (i+1) + " Final: " + (j+1) + " Largo: " + claros[i][j]);					
				}
			}
		}
	}

}
