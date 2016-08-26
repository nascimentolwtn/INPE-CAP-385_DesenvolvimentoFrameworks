package tarefa2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import annotations.tarefa2.ExtraPoints;
import annotations.tarefa2.LosePoint;
import annotations.tarefa2.PointsToUser;
import annotations.tarefa2.RemovePoints;
import annotations.tarefa2.TrophyWhenReachPointLimit;

public class TesteValidacaoTarefa2 {
	private static ValidadorTarefa2 validador;
	
	@BeforeClass
	public static void criarValidador(){
		validador = new ValidadorTarefa2();
	}
	
	
	public class ClasseA {
		@PointsToUser(value=1)
		@RemovePoints(value=1)
		public void registrar() {
		}
	}
	

	@Test 
	public void validaAnotacaoNoMetodo() throws Exception {	
		assertFalse ("Configuração de anotação inválida no método da classe -> "+ClasseA.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseA.class));
	}
	
	@TrophyWhenReachPointLimit 
	public class ClasseB {		
		public void registrar() {
		}
	}
	

	@Test 
	public void validaAnotacaoNaClasse() throws Exception {	
		assertFalse ("Configuração de anotação inválida na classe -> "+ClasseB.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseB.class));
	}
	
	
	public class ClasseC {
		@ExtraPoints
		@TrophyWhenReachPointLimit 
		@RemovePoints (value=1)
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNoMetodo1() throws Exception {	
		assertFalse ("Configuração de anotações inválida nos métodos da classe -> "+ClasseC.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseC.class));
	}	
	
	public class ClasseD {
		@RemovePoints (value=1)
		@ExtraPoints 
		public void registrar() {
		}				
	}
	
	@Test
	public void validaAnotacoesNoMetodoClasse() throws Exception {	
		assertFalse ("Configuração de anotações inválida no método da classe -> "+ClasseD.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseD.class));
	}
	
	
	@ExtraPoints
	@TrophyWhenReachPointLimit 
	@RemovePoints(value=1)
	public class ClasseE {		
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNoMetodoClasse2() throws Exception {	
		assertFalse ("Configuração de anotações inválida na classe -> "+ClasseE.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseE.class));
	}	
		
	public class ClasseF {
		@ExtraPoints
		@TrophyWhenReachPointLimit	
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNoMetodo() throws Exception {	
		assertTrue ("Configuração de anotações válida no método -> "+ClasseF.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseF.class));
	}	
	
	
	@PointsToUser(value=1)	 
	@LosePoint
	public class ClasseG {				
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacoesNaClasse() throws Exception {	
		assertFalse ("Configuração de anotações inválida na classe -> "+ClasseG.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseG.class));
	}	
	
	
	@ExtraPoints	 
	@LosePoint
	public class ClasseH{				
		public void registrar() {
		}
	}
	
	@Test 
	public void validaAnotacaoExtraNaClasse() throws Exception {	
		assertFalse ("Configuração de anotação inválida na classe -> "+ClasseH.class.getSimpleName(),
				validador.validarAnotacoesNaClasse(ClasseH.class));
	}	

}
