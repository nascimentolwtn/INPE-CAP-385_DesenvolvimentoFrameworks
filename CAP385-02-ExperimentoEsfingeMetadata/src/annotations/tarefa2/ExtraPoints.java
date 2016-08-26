package annotations.tarefa2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@PointsToUser(value=1)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtraPoints {

}
