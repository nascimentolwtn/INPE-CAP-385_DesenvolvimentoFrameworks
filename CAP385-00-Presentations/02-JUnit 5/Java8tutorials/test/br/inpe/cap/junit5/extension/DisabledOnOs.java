package br.inpe.cap.junit5.extension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

<<<<<<< Upstream, based on github/master
import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(OsCondition.class)
=======
@Retention(RetentionPolicy.RUNTIME)
//@ExtendWith(OsCondition.class)
>>>>>>> 382015a Classes e apresentação dos pontos de extensão - @Benchmark - @DisabledOnOS
public @interface DisabledOnOs {

	OS[] value() default {};

}
