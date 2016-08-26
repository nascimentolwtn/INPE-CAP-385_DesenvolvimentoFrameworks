package annotations.tarefa2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RemovePoints(value=1)
@Retention(RetentionPolicy.RUNTIME)
public @interface LosePoint {

}
