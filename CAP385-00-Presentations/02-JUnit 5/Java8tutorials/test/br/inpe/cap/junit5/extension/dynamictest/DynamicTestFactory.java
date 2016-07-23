package br.inpe.cap.junit5.extension.dynamictest;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class DynamicTestFactory {

	@TestFactory
	List<DynamicTest> registeredTests() {
		return asList(
				dynamicTest("Dynamic Test #1", () -> System.out.println("Hi, this is Dynamic Test #1!")),
				dynamicTest("Dynamic Test #2", () -> fail("Esta semente falhou!")),
				dynamicTest("Dynamic Test #2", () -> System.out.println("Hi, this is Dynamic Test #2!")));
	}

	@Test
	void staticTest() {
		// see https://github.com/junit-team/junit5/issues/384
		assertTrue(true);
	}

}