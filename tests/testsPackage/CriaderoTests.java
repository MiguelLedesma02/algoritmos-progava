package testsPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import criaderoDeTruchas.*;
import java.util.*;

class CriaderoTests {
    
	@Test
	void unEstanqueConSuficienteProfundidadAsignaNivelDeProfundidad() {

		// Arrange
		int numero = 1;
		int proCañoDer = 0;
		int superficie = 100;
		int profundidad = 10;
		Estanque estanque = new Estanque(numero, superficie, profundidad, proCañoDer);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);

		int volumenDeAguaPorCargar = 900;
		int numeroDeEstanque = 1;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);

		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperado = volumenDeAguaPorCargar / superficie;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperado);

	}
	
	@Test
	void unEstanqueConProfundidadJustaAsignaNivelDeProfundidad() {
		
		// Arrange
		int numero = 1;
		int proCañoDer = 0;
		int superficie = 100;
		int profundidad = 10;
		Estanque estanque = new Estanque(numero, superficie, profundidad, proCañoDer);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		
		int volumenDeAguaPorCargar = 1000;
		int numeroDeEstanque = 1;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);

		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperado = volumenDeAguaPorCargar / superficie;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperado);
	}
	
	@Test
	void unEstanqueSinProfundidadSuficienteDesborda() {
		
		// Arrange
		int numero = 1;
		int proCañoDer = 0;
		int superficie = 100;
		int profundidad = 10;
		Estanque estanque = new Estanque(numero, superficie, profundidad, proCañoDer);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		
		int volumenDeAguaPorCargar = 5000;
		int numeroDeEstanque = 1;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);

		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperado = 0; // vacío, no pudo llenar nada
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperado);
	}
	
	@Test
	void nEstanquesSeLlenanSinDesbordarPuntasCriadero() {
		// Arrange
				int numero1 = 1;
				int numero2= 2;
				int numero3= 3;
				int numero4= 4;
				int proCañoDer1 = 4;
				int proCañoDer2= 2;
				int proCañoDer3= 1;
				int proCañoDer4= 0;
				int superficie1 = 120;
				int superficie2= 80;
				int superficie3= 60;
				int superficie4= 50;
				int profundidad1 = 7;
				int profundidad2= 10;
				int profundidad3= 5;
				int profundidad4= 3;
				Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
				Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);
				Estanque estanque3 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);
				Estanque estanque4 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

				List<Estanque> estanques = new ArrayList<Estanque>();
				estanques.add(estanque);
				estanques.add(estanque2);
				estanques.add(estanque3);
				estanques.add(estanque4);

				int volumenDeAguaPorCargar = 1040;
				int numeroDeEstanque = 2;
				Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);

				Criadero criadero = new Criadero(estanques, vertedero);

				// Act
				criadero.llenar();

				// Assert
				int nivelDeCargaEsperado = 4;
				System.out.println(nivelDeCargaEsperado);
				assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperado);
				nivelDeCargaEsperado = 7;
				System.out.println(nivelDeCargaEsperado);
				assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperado);
	}
	
	

}
