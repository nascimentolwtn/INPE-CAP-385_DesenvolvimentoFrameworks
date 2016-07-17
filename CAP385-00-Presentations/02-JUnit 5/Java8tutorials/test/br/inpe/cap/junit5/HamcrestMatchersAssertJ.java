package br.inpe.cap.junit5;

import static org.hamcrest.text.IsEmptyString.isEmptyString;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;;

@RunWith(JUnitPlatform.class)
class HamcrestMatchersAssertJ {
 
	@Test
	public void emptyString() {
		// JUnit 5
		org.junit.jupiter.api.Assertions.assertTrue("".isEmpty());
		
		// AssertJ
		org.assertj.core.api.Assertions.assertThat("").isEmpty();
		
		// Hamcrest
		org.hamcrest.MatcherAssert.assertThat("", isEmptyString());
	}
	
}