package calculadoraLambda;

@FunctionalInterface
interface OperacaoMatematica {
	
	double operacao(double a, double b);
	
	static OperacaoMatematica adicao = new OperacaoMatematica() {
		
		@Override
		public double operacao(double a, double b) {
			return a + b;
		}
		
	};

	static OperacaoMatematica subtracao = (a, b) -> {
		return a - b;
	};

	static OperacaoMatematica multiplicacao = (a, b) -> a * b;

	static OperacaoMatematica divisao = (a, b) -> a / b;

}
