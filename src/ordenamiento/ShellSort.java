package ordenamiento;

public class ShellSort {

	public static void main(String[] args) {
		
		Integer[] lista = {7,6,3,2,5,1,4};

		System.out.println("Lista antes de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");

		//lista = shellSort(lista);
		shellSort2(lista);
		
		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");

	}
	
	static Integer[] shellSort(Integer[] lista) {
		int i, j, h = 1;
		int aux;
		boolean intercambio = true;
		
		while(h<= lista.length) {
			h=(h*3)+1;
		}
		
		//La lista está ordenada cuando no se realizaron intercambios
		while(intercambio != false) {
			intercambio = false;
			
			i = 0;
			j = i + h;
			while(j < lista.length) {
				
				//Si este elemento es mayor, lo intercambio
				if(lista[i] > lista[j]) {
					aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
					
					intercambio = true;
				}
				
				i ++;
				j ++;
			}
			
			//Recalcular "h", el cual es la distancia entre los dos elementos a comparar
			if(h > 1) {
				h = (h - 1)/3;	
				intercambio = true;
			}
		}
				
		return lista;
	}
	
	//Método genérico
	
	public static <T extends Comparable<T>> void shellSort2(T[] lista) {
        int i, j;
        int h = 1;
        T aux;
        boolean intercambio = true;
        
        while(h<= lista.length) {
			h=(h*3)+1;
		}

        while (intercambio) {
            intercambio = false;

            i = 0;
            j = i + h;
            while (j < lista.length) {
                if (lista[i].compareTo(lista[j]) > 0) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;

                    intercambio = true;
                }

                i++;
                j++;
            }

            if (h > 1) {
                h = (h - 1) / 3;
                intercambio = true;
            }
        }

	}

}
