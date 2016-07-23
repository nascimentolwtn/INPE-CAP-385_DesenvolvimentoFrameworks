package br.inpe.cap.junit5.extension;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import br.inpe.cap.junit5.extension.benchmark.Benchmark;

@RunWith(JUnitPlatform.class)
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
