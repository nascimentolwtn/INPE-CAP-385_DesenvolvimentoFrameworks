package br.inpe.cap.junit5;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.runner.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "br.inpe.cap.junit5" })
class TesteComJUnit5 {
	
	@Test
	void helloJUnit5() {
		System.out.println("Hello, JUnit 5.");
	}

}

