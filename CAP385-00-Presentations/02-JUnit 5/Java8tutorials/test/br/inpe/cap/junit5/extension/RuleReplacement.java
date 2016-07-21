package br.inpe.cap.junit5.extension;

import org.junit.Rule;
import org.junit.Test;

public class RuleReplacement {

	@Rule
	public ConditionalIgnoreRule rule = new ConditionalIgnoreRule();
	  
	@Test
	@ConditionalIgnore( condition = IsWindowsPlatform.class )
	public void testSomethingPlatformSpecific() {
	  // ...
	}
	
	
}
