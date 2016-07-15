package testingLambda;

import java.util.List;
import java.util.stream.Collectors;

public class StringToUppercase {

	public List<String> allToUpperCase(List<String> words) {
	    return words.stream()
	                .map(string -> string.toUpperCase())
	                .collect(Collectors.toList());
	}
	

	public List<String> uppercaseFirstChar(List<String> words) {
	    return words.stream()
	                .map(value -> {
	                    char firstChar = value.charAt(0);
	                    firstChar = Character.toUpperCase(firstChar);
	                    return firstChar + value.substring(1);
	                })
	                .collect(Collectors.toList());
	}
	
	public List<String> testableUppercaseFirstChar(List<String> words) {
	    return words.stream()
	                .map(this::testableFirstToUppercase)
	                .collect(Collectors.toList());
	}
	 
	public String testableFirstToUppercase(String value) {
	    char firstChar = value.charAt(0);
	    firstChar = Character.toUpperCase(firstChar);
	    return firstChar + value.substring(1);
	}
	
}
