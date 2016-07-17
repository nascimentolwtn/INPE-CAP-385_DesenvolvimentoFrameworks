package br.inpe.cap.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class AssertivasJUnit5 {

	@Test
	void assertVerdadeiroOuFalso() {
		assertTrue(true);
		assertTrue(this::verdadeVerdadeira);

		assertFalse(false, () -> "Mensagem " + "opcional " + "como " + "último " + "argumento. "
				+ "Usando "
				+ "expressão lambda, "
				+ "mensagens "
				+ "'pesadas' "
				+ "são "
				+ "carregadas "
				+ "conforme "
				+ "necessidade "
				+ "(lazy).");
	}

	private boolean verdadeVerdadeira() {
		return true;
	}
	
	@Test
	public void lambdaExpressions() {
		// Expressão Lambda como condição
		assertTrue(() -> "".isEmpty(), "String não deveria ser vazia.");
	}

	@Test
	void assertComListas() {
		List<String> esperado = Arrays.asList("elemento");
		List<String> real = new LinkedList<>(esperado);

		assertEquals(esperado, real, () -> "Implementações " + "diferentes " + "deveriam " + "retornar " + "listas " + "iguais.");

		assertNotSame(esperado, real, "Mas não são a mesma instância.");
	}

	@Test
	@Disabled
	void testeBugado() {
		fail("Burlando o servidor IC!");
	}

	@Test
	void assertAllProperties() {
		Endereco endereco = new Endereco("BH", "Av. Contorno", "10386");

		assertAll("construtor",
				() -> assertEquals("BH", endereco.cidade),
				() -> assertEquals("pertin, sô. logo ali", endereco.rua),
				() -> assertEquals("811", endereco.numero)
		);
	}
	
	@Test
	public void groupedAssertions() {
		Dimension dim = new Dimension(800, 600);
		assertAll("dimension",
					() -> assertTrue(dim.getWidth() == 800, "width"),
					() -> assertTrue(dim.getHeight() == 600, "height"));
	}

	@Test
	void testeDeException() {
		assertThrows(Exception.class, this::lancandoExcecao);

		Exception exception = expectThrows(Exception.class, this::lancandoExcecao);

		assertEquals("Teste de exceptions, sem try/catch.", exception.getMessage());
	}

	private void lancandoExcecao() throws Exception {
		throw new RuntimeException("Teste de exceptions, sem try/catch.");
	}

	private static class Endereco {

		public final String cidade;
		public final String rua;
		public final String numero;

		private Endereco(String cidade, String rua, String numero) {
			this.cidade = cidade;
			this.rua = rua;
			this.numero = numero;
		}
	}
	

}
