package br.inpe.cap.junit5.extension;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
<<<<<<< Upstream, based on github/master
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import br.inpe.cap.junit5.extension.benchmark.Benchmark;

@RunWith(JUnitPlatform.class)
=======
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@ExtendWith(OsCondition.class)
>>>>>>> 382015a Classes e apresentação dos pontos de extensão - @Benchmark - @DisabledOnOS
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
