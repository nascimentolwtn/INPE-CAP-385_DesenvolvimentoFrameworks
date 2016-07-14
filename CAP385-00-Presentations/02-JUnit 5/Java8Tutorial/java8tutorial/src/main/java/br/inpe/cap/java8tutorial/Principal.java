package br.inpe.cap.java8tutorial;

import java.util.stream.IntStream;


/*
 * Requisito:
 * Se listarmos todos os números naturais abaixo de 10 
 * que são múltiplos de 3 u 5, obtemos 3, 5, 6 e 9.
 * A soma destes números é 23.
 * 
 * Encontre a soma de todos os múltiplos de 3 ou 5 
 * abaixo de 1000. 
 * 
 */

public class Principal {

	public static void main( String[] args ) {
    	
    	System.out.println(
    			IntStream.range(1, 1000)
					//.forEach(n -> System.out.println(n));
		    		.filter(n -> (n %3 == 0) || (n % 5 == 0)) // apenas múltiplos de 3 ou 5
		    		.sum());
    	
    }
}