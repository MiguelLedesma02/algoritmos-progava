package ordenamiento;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] lista = {7,6,3,2,5,1,4};
		

		System.out.println("Lista antes de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");

		lista = bubbleSort(lista);
		
		System.out.println("\n");
		System.out.println("Lista despues de ordenar:");
		for(int i = 0;i < lista.length;i ++)
			System.out.print(lista[i] + " ");
		
	}
	
	static int[] bubbleSort(int[] lista) {
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
}
