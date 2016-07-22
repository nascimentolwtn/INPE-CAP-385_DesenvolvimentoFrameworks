package br.inpe.cap.junit5.extension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
//@ExtendWith(OsCondition.class)
public @interface DisabledOnOs {

	OS[] value() default {};

}
