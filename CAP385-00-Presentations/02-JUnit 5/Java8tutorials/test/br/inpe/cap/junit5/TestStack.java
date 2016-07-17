package br.inpe.cap.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("A stack")
class TestStack {

	Stack<Object> stack;
	boolean isRun = false;

	@Test
	@DisplayName("is instantiated with new Stack()")
	void isInstantiatedWithNew() {
		new Stack<Object>();
	}

	@Nested
	@DisplayName("when new")
	class WhenNew {

		@BeforeEach
		void init() {
			stack = new Stack<Object>();
		}

		@Test
		@DisplayName("is empty")
		void isEmpty() {
			assertTrue(stack.isEmpty());
		}

		@Test
		@DisplayName("throws EmptyStackException when popped")
		void throwsExceptionWhenPopped() {
			expectThrows(EmptyStackException.class, () -> stack.pop());
		}

		@Test
		@DisplayName("throws EmptyStackException when peeked")
		void throwsExceptionWhenPeeked() {
			expectThrows(EmptyStackException.class, () -> stack.peek());
		}

		@Nested
		@DisplayName("after pushing an element")
		class AfterPushing {

			String anElement = "an element";

			@BeforeEach
			void init() {
				stack.push(anElement);
			}

			@Test
			@DisplayName("it is no longer empty")
			void isEmpty() {
				assertFalse(stack.isEmpty());
			}

			@Test
			@DisplayName("returns the element when popped and is empty")
			void returnElementWhenPopped() {
				assertEquals(anElement, stack.pop());
				assertTrue(stack.isEmpty());
			}

			@Test
			@DisplayName("returns the element when peeked but remains not empty")
			void returnElementWhenPeeked() {
				assertEquals(anElement, stack.peek());
				assertFalse(stack.isEmpty());
			}
			
			@Test
			void falha() {
				fail("IndexOutOfBound");
			}
		}
	}
}