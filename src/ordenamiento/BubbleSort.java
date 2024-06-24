package ordenamiento;

public class BubbleSort {

	public static void main(String[] args) {
		
		Integer[] lista = {7,6,3,2,5,1,4};
		

		System.out.println("Lista antes de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");

		lista = bubbleSort(lista);
		
		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");
		System.out.println("\n");
		System.out.println("Genérico");
		bubbleSortv2(lista);
		imprimir(lista);
	}
	


	static Integer[] bubbleSort(Integer[] lista) {
		int i, j;
		int aux;
		boolean intercambio = true;
		
		//Si no realizo intercambios, quiere decir que mi vector está ordenado
		while(intercambio != false) {
			intercambio = false;
			for(i = 0;i < lista.length - 1;i ++) {
				j = i + 1;
				
				//Si este elemento es mayor al siguiente, lo intercambio
				if(lista[i] > lista[j]) {
					aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
					
					intercambio = true;
				}
			}
		}
		
		return lista;
	}


public static <T extends Comparable<T>> void bubbleSortv2(T[] array) {
    int n = array.length;
    boolean intercambio;

    for (int i = 0; i < n - 1; i++) {
        intercambio = false;
        for (int j = 0; j < n - 1 - i; j++) {
            if (array[j].compareTo(array[j + 1]) > 0) {
                T temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                intercambio = true;
            }
        }
        if (!intercambio) {
        	break;
        }
    }
}

public static <T> void imprimir(T[] array) {
    for (T elemento : array) {
        System.out.print(elemento + " ");
    }
    System.out.println();
	}
}

