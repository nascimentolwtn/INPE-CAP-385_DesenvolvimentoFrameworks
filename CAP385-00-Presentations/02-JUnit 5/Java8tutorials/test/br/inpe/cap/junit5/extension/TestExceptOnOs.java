package br.inpe.cap.junit5.extension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.jupiter.api.Test;

@Retention(RetentionPolicy.RUNTIME)
//@ExtendWith(OsCondition.class)
@Test
public @interface TestExceptOnOs {

	OS[] value() default {};

}
