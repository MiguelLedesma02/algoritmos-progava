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
	void dosEstanquesConVertederoEnPrimerEstanqueSeLlenaUnoHastaCaño() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 1;
		int volumenDeAguaPorCargar = 360;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 3;
		int nivelDeCargaEsperadoSegundoEstanque = 0;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnPrimerEstanqueSeLlenaElPrimeroHastaElCañoYElOtroSinPasarElNivelDelPrimero() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 1;
		int volumenDeAguaPorCargar = 600;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 3;
		int nivelDeCargaEsperadoSegundoEstanque = 3;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnPrimerEstanqueSeLlenanPasandoElCañoSinDesbordar() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 1;
		int volumenDeAguaPorCargar = 1040;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 4;
		int nivelDeCargaEsperadoSegundoEstanque = 7;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnPrimerEstanqueSeLlenanJusto() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 1;
		int volumenDeAguaPorCargar = 1640;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 7;
		int nivelDeCargaEsperadoSegundoEstanque = 10;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnPrimerEstanqueDesbordan() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 1;
		int volumenDeAguaPorCargar = 3000;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 0;
		int nivelDeCargaEsperadoSegundoEstanque = 0;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	// ---------------------------------------------------------------------------------------------
	
	@Test
	void dosEstanquesConVertederoEnSegundoEstanqueSeLlenaUnoHastaCaño() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 2;
		int volumenDeAguaPorCargar = 480;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 0;
		int nivelDeCargaEsperadoSegundoEstanque = 6;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnSegundoEstanqueSeLlenaElPrimeroHastaElCañoYElOtroSinPasarElNivelDelPrimero() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 2;
		int volumenDeAguaPorCargar = 720;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 2;
		int nivelDeCargaEsperadoSegundoEstanque = 6;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnSegundoEstanqueSeLlenanPasandoElCañoSinDesbordar() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 2;
		int volumenDeAguaPorCargar = 1040;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 4;
		int nivelDeCargaEsperadoSegundoEstanque = 7;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnSegundoEstanqueSeLlenanJusto() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 2;
		int volumenDeAguaPorCargar = 1640;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 7;
		int nivelDeCargaEsperadoSegundoEstanque = 10;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	@Test
	void dosEstanquesConVertederoEnSegundoEstanqueDesbordan() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int proCañoDer1 = 4;
		int proCañoDer2 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int profundidad1 = 7;
		int profundidad2 = 10;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);

		int numeroDeEstanque = 2;
		int volumenDeAguaPorCargar = 3000;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 0;
		int nivelDeCargaEsperadoSegundoEstanque = 0;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
	}
	
	// -----------------------------------------------------------------------------------------


	@Test
	void nEstanquesSeLlenanSinDesbordarPuntasCriadero() {
		// Arrange
		int numero1 = 1;
		int numero2 = 2;
		int numero3 = 3;
		int numero4 = 4;
		int proCañoDer1 = 4;
		int proCañoDer2 = 2;
		int proCañoDer3 = 1;
		int proCañoDer4 = 0;
		int superficie1 = 120;
		int superficie2 = 80;
		int superficie3 = 60;
		int superficie4 = 50;
		int profundidad1 = 7;
		int profundidad2 = 10;
		int profundidad3 = 5;
		int profundidad4 = 3;
		Estanque estanque = new Estanque(numero1, superficie1, profundidad1, proCañoDer1);
		Estanque estanque2 = new Estanque(numero2, superficie2, profundidad2, proCañoDer2);
		Estanque estanque3 = new Estanque(numero3, superficie3, profundidad3, proCañoDer3);
		Estanque estanque4 = new Estanque(numero4, superficie4, profundidad4, proCañoDer4);

		List<Estanque> estanques = new ArrayList<Estanque>();
		estanques.add(estanque);
		estanques.add(estanque2);
		estanques.add(estanque3);
		estanques.add(estanque4);

		int numeroDeEstanque = 2;
		int volumenDeAguaPorCargar = 1040;
		Vertedero vertedero = new Vertedero(volumenDeAguaPorCargar, numeroDeEstanque);
		Criadero criadero = new Criadero(estanques, vertedero);

		// Act
		criadero.llenar();

		// Assert
		int nivelDeCargaEsperadoPrimerEstanque = 4;
		int nivelDeCargaEsperadoSegundoEstanque = 7;
		int nivelDeCargaEsperadoTercerEstanque = 0;
		int nivelDeCargaEsperadoCuartoEstanque = 0;
		assertEquals(estanques.get(0).getNivel(), nivelDeCargaEsperadoPrimerEstanque);
		assertEquals(estanques.get(1).getNivel(), nivelDeCargaEsperadoSegundoEstanque);
		assertEquals(estanques.get(2).getNivel(), nivelDeCargaEsperadoTercerEstanque);
		assertEquals(estanques.get(3).getNivel(), nivelDeCargaEsperadoCuartoEstanque);
		
	}

}
