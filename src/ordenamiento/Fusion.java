package ordenamiento;

public class Fusion {

	public static void main(String[] args) {

		Integer[] lista = { 7, 6, 3, 2, 5, 1, 4 };

		System.out.println("Lista antes de ordenar:");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i] + " ");
		System.out.print("\n");
		System.out.print("Lista después de ordenar ");
		System.out.print("\n");
		ordenarFusion(lista);

		imprimir(lista);

	}


    public static void ordenarFusion2(Integer[] lista) {
        int tam = lista.length;

        if (lista == null || tam <= 1) {
            return;
        }

        ordenarFusion2(lista, 0, tam - 1);
    }

    private static void ordenarFusion2(Integer[] vec, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;

            ordenarFusion2(vec, izq, medio);
            ordenarFusion2(vec, medio + 1, der);

            fusion2(vec, izq, medio, der);
        }
    }

    private static void fusion2(Integer[] vec, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        Integer[] vecAux1 = new Integer[n1];
        Integer[] vecAux2 = new Integer[n2];

        System.arraycopy(vec, izq, vecAux1, 0, n1);
        System.arraycopy(vec, medio + 1, vecAux2, 0, n2);

        int i = 0, j = 0;
        int k = izq;

        while (i < n1 && j < n2) {
            if (vecAux1[i] <= vecAux2[j]) {
                vec[k] = vecAux1[i];
                i++;
            } else {
                vec[k] = vecAux2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vec[k] = vecAux1[i];
            i++;
            k++;
        }

        while (j < n2) {
            vec[k] = vecAux2[j];
            j++;
            k++;
        }
    }

    public static void imprimir(Integer[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
	
    // Método genérico para ordenar por fusión
    
    
    public static <T extends Comparable<T>> void ordenarFusion(T[] lista) {
        int tam = lista.length;

        if (lista == null || tam <= 1) {
            return;
        }

        ordenarFusion(lista, 0, tam - 1);
    }

    private static <T extends Comparable<T>> void ordenarFusion(T[] vec, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;

            ordenarFusion(vec, izq, medio);
            ordenarFusion(vec, medio + 1, der);

            fusion(vec, izq, medio, der);
        }
    }

    @SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void fusion(T[] vec, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        T[] vecAux1 = (T[]) new Comparable[n1];
        T[] vecAux2 = (T[]) new Comparable[n2];

        System.arraycopy(vec, izq, vecAux1, 0, n1);
        System.arraycopy(vec, medio + 1, vecAux2, 0, n2);

        int i = 0, j = 0;
        int k = izq;

        while (i < n1 && j < n2) {
            if (vecAux1[i].compareTo(vecAux2[j]) <= 0) {
                vec[k] = vecAux1[i];
                i++;
            } else {
                vec[k] = vecAux2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vec[k] = vecAux1[i];
            i++;
            k++;
        }

        while (j < n2) {
            vec[k] = vecAux2[j];
            j++;
            k++;
        }
    }

    public static <T> void imprimir(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
