package calculadoraLambda;

public class Calculadora {

	double calcular(double a, double b, OperacaoMatematica op) {
		return op.operacao(a, b);
	}

}
