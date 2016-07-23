package br.inpe.cap.junit5.extension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

<<<<<<< Upstream, based on github/master
<<<<<<< Upstream, based on github/master
import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(OsCondition.class)
=======
=======
import org.junit.jupiter.api.extension.ExtendWith;

>>>>>>> 74ba60e Implementação de teste para apresentação - new String(hash)
@Retention(RetentionPolicy.RUNTIME)
<<<<<<< Upstream, based on github/master
//@ExtendWith(OsCondition.class)
>>>>>>> 382015a Classes e apresentação dos pontos de extensão - @Benchmark - @DisabledOnOS
=======
@ExtendWith(OsCondition.class)
>>>>>>> 74ba60e Implementação de teste para apresentação - new String(hash)
public @interface DisabledOnOs {

	OS[] value() default {};

}
