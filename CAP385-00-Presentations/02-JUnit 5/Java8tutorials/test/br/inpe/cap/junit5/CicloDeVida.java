package br.inpe.cap.junit5;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class CicloDeVida {
 
	@BeforeAll
	static void inicializaRecursosExternos() {
		System.out.println("Inicializando Recursos Externos...");
	}
 
	@BeforeEach
	void inicializaMockObjects() {
		System.out.println("Inicializando mock objects");
	}
 
	@Test
	void primeiroTestAssertTrue() {
		assertTrue(true);
		System.out.println("Assert true óbvio");
	}
 
	@Test
	void segundoTestAssume() {
		int soma = 2 + 2;
		assumeTrue(soma == 5);
 
		System.out.println("Teste 2 + 2 = 5");
		assertNotEquals(2 + 2, 4, "Será que não é mesmo?");
	}
 
	@Test
	@Disabled
	void testeDesabilitado() {
		System.exit(1);
	}
 
	@AfterEach
	void tearDown() {
		System.out.println("Finalizar mocks");
	}
 
	@AfterAll
	static void liberarRecursosExternos() {
		System.out.println("Liberando recursos externos...");
	}
 
}