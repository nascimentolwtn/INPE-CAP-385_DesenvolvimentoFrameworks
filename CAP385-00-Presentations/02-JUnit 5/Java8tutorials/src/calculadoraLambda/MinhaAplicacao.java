package calculadoraLambda;

import static calculadoraLambda.OperacaoMatematica.adicao;
import static calculadoraLambda.OperacaoMatematica.divisao;
import static calculadoraLambda.OperacaoMatematica.multiplicacao;
import static calculadoraLambda.OperacaoMatematica.subtracao;

public class MinhaAplicacao {

	public static void main(String... args) {

		double resultadoSoma = Calculadora.calcular(40, 2, adicao);
		System.out.println("40 + 2 = " + resultadoSoma);
		
		double resultadoSubtracao = Calculadora.calcular(20, 10, subtracao);
		System.out.println("20 - 10 = " + resultadoSubtracao);
		
		double resultadoMultiplicacao = Calculadora.calcular(2, 10, multiplicacao);
		System.out.println("2 * 10 = " + resultadoMultiplicacao);
		
		double resultadoDivisao = Calculadora.calcular(5, 10, divisao);
		System.out.println("5 / 10 = " + resultadoDivisao);
		
	}
	
}
