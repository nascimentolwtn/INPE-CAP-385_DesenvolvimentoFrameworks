package br.inpe.cap.junit5.extension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DisabledWhenExtension.class)
public @interface DesabilitadoQuando {
	
	Class<? extends DisabledWhenCondition> value();

}
