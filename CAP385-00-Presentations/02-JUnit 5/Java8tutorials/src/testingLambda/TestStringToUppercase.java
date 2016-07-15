package testingLambda;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestStringToUppercase {

	private StringToUppercase stringToUppercase;

	@Before
	public void setUp() {
		this.stringToUppercase = new StringToUppercase();
	}

	@Test
	public void multipleWordsToUppercase() {
		List<String> input = Arrays.asList("a", "b", "hello");
		List<String> result = stringToUppercase.allToUpperCase(input);
	    assertEquals(Arrays.asList("A", "B", "HELLO"), result);
	    
	}
	
	@Test
	public void lettersStringConvertedToUppercaseLambdas() {
	    List<String> input = Arrays.asList("abcdefg hijklmnop");
	    List<String> result = this.stringToUppercase.uppercaseFirstChar(input);
	    assertEquals(Arrays.asList("Abcdefg hijklmnop"), result);
	}

	@Test
	public void testableLettersStringConvertedToUppercaseLambdas() {
	    List<String> input = Arrays.asList("abcdefg hijklmnop");
	    List<String> result = this.stringToUppercase.testableUppercaseFirstChar(input);
	    assertEquals(Arrays.asList("Abcdefg hijklmnop"), result);
	}

	@Test
	public void testFirstToUppercase() {
	    String input = "abc";
	    String result = this.stringToUppercase.testableFirstToUppercase(input);
	    assertEquals("Abc", result);
	}
	
}
