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
	
	

}
