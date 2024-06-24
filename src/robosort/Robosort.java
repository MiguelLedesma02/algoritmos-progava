package robosort;

public class Robosort {

	public static void main(String[] args) {
	
		int[] v1 = {3, 4, 5, 1, 6, 2};
		int[] v2 = {3, 10, 2, 1};
		
		System.out.println("ANTES:");
		for(int i = 0; i < v1.length; i ++)
			System.out.print(v1[i] + " ");

		System.out.println("");

		for(int i = 0; i < v2.length; i ++)
			System.out.print(v2[i] + " ");

		System.out.println("");
		
		v1 = robosort(v1);
		v2 = robosort(v2);
		
		System.out.println("DESPUES:");
		for(int i = 0; i < v1.length; i ++)
			System.out.print(v1[i] + " ");
		
		System.out.println("");

		for(int i = 0; i < v2.length; i ++)
			System.out.print(v2[i] + " ");
		
	}

	public static int[] robosort(int[] muestras) {
		
		int menor = 0;
		int indexIzq = 0;
		int indexDer = 0;
		int posMenor = 0;
		int[] pos = new int[muestras.length];
		
		for(int i = 0; i < muestras.length; i ++) {
			
			posMenor = i+1;
			menor = muestras[i];
			indexIzq = i;
			
			for(int j = i + 1; j < muestras.length; j ++) {
				
				if(muestras[j] < menor) {
					posMenor = j+1;
					menor = muestras[j];
					indexDer = j;
				}
				
			}
			
			pos[i] = posMenor;
			muestras = rotar(indexIzq, indexDer, muestras);
			
		}
		
		return pos;
	}
	
	public static int[] rotar(int indexIzq, int indexDer, int[] muestras) {
		
		if(indexIzq > indexDer)
			return muestras;
		
		int aux = 0;
		
		aux = muestras[indexIzq];
		muestras[indexIzq] = muestras[indexDer];
		muestras[indexDer] = aux;
		
		muestras = rotar(++ indexIzq, -- indexDer, muestras);
		
		return muestras;
	}
	
}
