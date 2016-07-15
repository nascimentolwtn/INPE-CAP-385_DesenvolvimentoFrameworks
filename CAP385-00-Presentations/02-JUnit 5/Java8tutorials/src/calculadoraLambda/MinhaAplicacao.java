package calculadoraLambda;

import static calculadoraLambda.OperacaoMatematica.adicao;
import static calculadoraLambda.OperacaoMatematica.divisao;
import static calculadoraLambda.OperacaoMatematica.multiplicacao;
import static calculadoraLambda.OperacaoMatematica.subtracao;

public class MinhaAplicacao {

	public static void main(String... args) {
		
		Calculadora calculadora = new Calculadora();
		
		double resultadoSoma = calculadora.calcular(40, 2, adicao);
		System.out.println("40 + 2 = " + resultadoSoma);
		
		double resultadoSubtracao = calculadora.calcular(20, 10, subtracao);
		System.out.println("20 - 10 = " + resultadoSubtracao);
		
		double resultadoMultiplicacao = calculadora.calcular(2, 10, multiplicacao);
		System.out.println("2 * 10 = " + resultadoMultiplicacao);
		
		double resultadoDivisao = calculadora.calcular(5, 10, divisao);
		System.out.println("5 / 10 = " + resultadoDivisao);
		
	}
	
}
