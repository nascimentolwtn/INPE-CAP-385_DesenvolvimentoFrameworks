package br.inpe.cap.junit5.extension;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

public class OsCondition implements ContainerExecutionCondition, TestExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluate(ContainerExtensionContext context) {
		return evaluateIfAnnotated(context.getElement());
	}

	@Override
	public ConditionEvaluationResult evaluate(TestExtensionContext context) {
		return evaluateIfAnnotated(context.getElement());
	}

	private ConditionEvaluationResult evaluateIfAnnotated(Optional<AnnotatedElement> element) {
		Optional<DisabledOnOs> disabled = element.flatMap(el -> findAnnotation(el, DisabledOnOs.class));
		if (disabled.isPresent())
			return disabledIfOn(disabled.get().value());

		Optional<TestExceptOnOs> testExcept = element.flatMap(el -> findAnnotation(el, TestExceptOnOs.class));
		if (testExcept.isPresent())
			return disabledIfOn(testExcept.get().value());

		return ConditionEvaluationResult.enabled("");
	}

	private ConditionEvaluationResult disabledIfOn(OS[] disabledOnOs) {
		OS os = OS.determine();
		if (Arrays.asList(disabledOnOs).contains(os))
			return ConditionEvaluationResult.disabled("Test is disabled on " + os + ".");
		else
			return ConditionEvaluationResult.enabled("Test is not disabled in " + os + ".");
	}

}
