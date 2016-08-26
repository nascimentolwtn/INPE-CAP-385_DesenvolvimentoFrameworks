package annotations.tarefa1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.Prohibits;
import org.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import org.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Prohibits(OptimizeExecution.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction {
}
