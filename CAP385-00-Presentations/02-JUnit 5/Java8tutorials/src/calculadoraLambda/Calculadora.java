package calculadoraLambda;

public interface Calculadora {

	static double calcular(double a, double b, OperacaoMatematica op) {
		return op.operacao(a, b);
	}

}
