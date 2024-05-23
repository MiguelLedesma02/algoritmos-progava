package rescatandoLaPrincesa;

import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args){
		
		Bosque bosque = null;
		
		try {
			bosque = Archivo.leerArchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		bosque.getCamino();
		
	}

}
