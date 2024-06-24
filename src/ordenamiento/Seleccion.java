package ordenamiento;

public class Seleccion {

	public static void ordenarPorSeleccion(Integer[] datos) {
		int n = datos.length;
		for (int i = 0; i < (n - 1); i++) {
			int menor = i;
			for (int j = i + 1; j < n; j++)
				if (datos[j] < datos[menor])
					menor = j;
			int swap = datos[i];
			datos[i] = datos[menor];
			datos[menor] = swap;
		}
	}
	
	//Método genérico
	
	   public static <T extends Comparable<T>> void ordenarPorSeleccionGen(T[] datos) {
	        int n = datos.length;
	        for (int i = 0; i < (n - 1); i++) {
	            int menor = i;
	            for (int j = i + 1; j < n; j++) {
	                if (datos[j].compareTo(datos[menor]) < 0) {
	                    menor = j;
	                }
	            }
	            T swap = datos[i];
	            datos[i] = datos[menor];
	            datos[menor] = swap;
	        }
	    }

	    public static void main(String[] args) {
	        Integer[] vecEntero = {4, 3, 2, 10, 12, 1, 5, 6};
	        String[] vecStringy = {"Manzana", "Pera", "Banana", "Pera"};

	        ordenarPorSeleccionGen(vecEntero);
	        ordenarPorSeleccionGen(vecStringy);

	        System.out.println("Vector entero:");
	        for (Integer num : vecEntero) {
	            System.out.print(num + " ");
	        }

	        System.out.println("\nVector String");
	        for (String str : vecStringy) {
	            System.out.print(str + " ");
	        }

	    }
}
