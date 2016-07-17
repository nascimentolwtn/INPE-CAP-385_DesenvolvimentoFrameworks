package br.inpe.cap.junit5;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Executable;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class TagJenkins {
 
	@Test
	@Tag("jenkins")
	public void jenkinsOnly() {
		// verifica se está rodando no IC
		assumingThat(() -> true, (Executable) () -> {
			fail("Deveria executarapenas dentro do IC");
		});
	} 
	
}