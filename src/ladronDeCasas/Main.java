package ladronDeCasas;

public class Main {

	public static void main(String[] args) {

		int[] casas = {2, 10, 3, 6, 8, 1, 7};
		int acumuladoAnteriorDelAnterior = casas[0], acumuladoAnterior = casas[1];
	
		for(int i=2; i < casas.length; i ++) {
			
			if(casas[i] + acumuladoAnteriorDelAnterior > acumuladoAnterior) {
				int aux = acumuladoAnterior;
				acumuladoAnterior = casas[i] + acumuladoAnteriorDelAnterior;
				acumuladoAnteriorDelAnterior = aux;
			}
			else {
				acumuladoAnteriorDelAnterior = acumuladoAnterior;
			}
		}
		
		System.out.println("El acumulado total es: $" + acumuladoAnterior);
	}

}
