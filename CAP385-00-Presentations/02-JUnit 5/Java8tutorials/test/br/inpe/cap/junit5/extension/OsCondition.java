package br.inpe.cap.junit5.extension;

<<<<<<< Upstream, based on github/master
<<<<<<< Upstream, based on github/master
import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;
=======
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;
=======
import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;
>>>>>>> 74ba60e Implementação de teste para apresentação - new String(hash)

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

<<<<<<< Upstream, based on github/master
import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;
>>>>>>> 382015a Classes e apresentação dos pontos de extensão - @Benchmark - @DisabledOnOS
=======
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;
>>>>>>> 74ba60e Implementação de teste para apresentação - new String(hash)

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
