package br.inpe.cap.junit5;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TesteComJUnit5 {
	
	@Test
	void helloJUnit5() {
		System.out.println("Hello, JUnit 5.");
	}

}

