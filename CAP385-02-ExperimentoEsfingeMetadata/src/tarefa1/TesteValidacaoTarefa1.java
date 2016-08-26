package tarefa1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import annotations.tarefa1.Logging;
import annotations.tarefa1.Metadados;
import annotations.tarefa1.OptimizeExecution;
import annotations.tarefa1.Transaction;

public class TesteValidacaoTarefa1 {
	private static ValidadorTarefa1 validador;
	
	@BeforeClass
	public static void criarValidador(){
		validador = new ValidadorTarefa1();
	}
	
	
	public class ClasseA {
		@Logging 
		public void registrar() {
		}
	}
	

	@Test 
	public void validaAnotacaoNoMetodo() throws Exception {	
		assertFalse ("Configuração de anotação inválida no método da classe -> "+ClasseA.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseA.class));
	}
	
	@Logging 
	public class ClasseB {		
		public void registrar() {
		}
	}
	

	@Test 
	public void validaAnotacaoNaClasse() throws Exception {	
		assertFalse ("Configuração de anotação inválida na classe -> "+ClasseB.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseB.class));
	}
	
	@Transaction
	public class ClasseC {
		@Logging @OptimizeExecution 
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNoMetodo1() throws Exception {	
		assertFalse ("Configuração de anotações inválida nos métodos da classe -> "+ClasseC.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseC.class));
	}
	
	public class ClasseD {
		@Logging 
		public void registrar() {
		}
		
		@Transaction 
		public void editar() {
		}
	}
	
	@Test
	public void validaAnotacoesNoMetodoClasse() throws Exception {	
		assertFalse ("Configuração de anotações inválida no método e na classe -> "+ClasseD.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseD.class));
	}
	
	
	
	public class ClasseE {
		@Transaction
		@Logging 
		@OptimizeExecution
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNoMetodoClasse2() throws Exception {	
		assertFalse ("Configuração de anotações inválida no método e na classe -> "+ClasseE.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseE.class));
	}	
	
	public class ClasseF {
		@Transaction
		@Logging		
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNoMetodo() throws Exception {	
		assertTrue ("Configuração de anotações válida no método -> "+ClasseF.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseF.class));
	}	
	

	@Transaction	
	@Logging 
	@OptimizeExecution
	public class ClasseG {				
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNaClasse() throws Exception {	
		assertFalse ("Configuração de anotações inválida no método e na classe -> "+ClasseG.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseG.class));
	}	
	
	
	@Test 
	public void validaAnotacaoNoMetodoPacote() throws Exception {	
		assertFalse ("Configuração de anotação inválida no método da classe -> "+Metadados.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(Metadados.class));
	}	

}
