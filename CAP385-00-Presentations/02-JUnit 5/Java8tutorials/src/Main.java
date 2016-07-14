import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

	private static final int QTD_QUEBRA_LINHA = 500;

	public static void main(String[] args) {
		
		System.out.println("Cria a lista com elementos que serão realizadas operações");
		List<Integer> integerList = IntStream.rangeClosed(1, 1200).boxed().collect(Collectors.toList());
		List<Double> list = new ArrayList<Double>();
		integerList.forEach(i -> list.add(new Double(i + (i/100d))));
		
		System.out.println("Imprime todos os números:");
		avaliaExpressao(list, (n) -> true);
		
		System.out.println("Não imprime nenhum número:");
		avaliaExpressao(list, (n) -> false);
		
		System.out.println("Imprime apenas números pares:");
		avaliaExpressaoFiltrada(list, (n) -> n%2 == 0);
		
		System.out.println("Imprime apenas números ímpares:");
		avaliaExpressao(list, (n) -> n%2 == 1);
		
		System.out.println("Imprime apenas números entre 500 e 1000:");
		avaliaExpressaoFiltrada(list, (n) -> n > 500 && n < 1000);
		
	}

	private static void avaliaExpressao(List<Double> list, Predicate<Double> predicate) {
		list.forEach(n -> {
			if(aCadaXnumeros(n)) System.out.println("");
			if(predicate.test(n)) {
				System.out.print(n + " ");
			}
		});
		
		System.out.println("");
		
	}

	private static void avaliaExpressaoFiltrada(List<Double> list, Predicate<Double> predicate) {
		List<Double> filteredList = list.stream().filter(predicate).collect(Collectors.toList());
		boolean isListaGrande = filteredList.size() > 100;
		
		filteredList.forEach(n -> {
			if(isListaGrande && aCadaXnumeros(n)) System.out.println("");
			System.out.print(n + " ");
		});

		System.out.println("");
	}

	private static boolean aCadaXnumeros(Double n) {
		return ((Double) (n % QTD_QUEBRA_LINHA)).intValue() == 0;
	}
	
}
