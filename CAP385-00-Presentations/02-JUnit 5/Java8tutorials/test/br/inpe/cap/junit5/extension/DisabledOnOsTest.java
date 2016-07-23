package br.inpe.cap.junit5.extension;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
<<<<<<< Upstream, based on github/master
<<<<<<< Upstream, based on github/master
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import br.inpe.cap.junit5.extension.benchmark.Benchmark;

@RunWith(JUnitPlatform.class)
=======
import org.junit.jupiter.api.extension.ExtendWith;
=======
>>>>>>> 74ba60e Implementação de teste para apresentação - new String(hash)
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import br.inpe.cap.junit5.extension.benchmark.Benchmark;

@RunWith(JUnitPlatform.class)
<<<<<<< Upstream, based on github/master
@ExtendWith(OsCondition.class)
>>>>>>> 382015a Classes e apresentação dos pontos de extensão - @Benchmark - @DisabledOnOS
=======
>>>>>>> 74ba60e Implementação de teste para apresentação - new String(hash)
@Benchmark
class DisabledOnOsTest {

	@Test
	void runsOnAllOS() {
		assertTrue(true);
	}

	@Test
	@DisabledOnOs(OS.NIX)
	void doesNotRunOnLinux() {
		assertTrue(true);
	}

	@Test
	@DisabledOnOs(OS.WINDOWS)
	void doesNotRunOnWindows() {
		assertTrue(false);
	}

	@TestExceptOnOs(OS.NIX)
	void doesNotRunOnLinuxEither() {
		assertTrue(true);
	}

	@TestExceptOnOs(OS.WINDOWS)
	void doesNotRunOnWindowsEither() {
		assertTrue(false);
	}

}
