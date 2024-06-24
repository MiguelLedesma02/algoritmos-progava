package rescatandoLaPrincesa;

import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {
			Bosque bosque = Archivo.leerArchivo();
			bosque.getCamino();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}