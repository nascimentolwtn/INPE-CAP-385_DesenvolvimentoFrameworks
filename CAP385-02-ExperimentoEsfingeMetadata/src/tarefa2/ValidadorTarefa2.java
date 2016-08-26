package tarefa2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import annotations.tarefa2.ExtraPoints;
import annotations.tarefa2.LosePoint;
import annotations.tarefa2.PointsToUser;
import annotations.tarefa2.RemovePoints;
import annotations.tarefa2.TrophyWhenReachPointLimit;

public class ValidadorTarefa2 {
	
	public boolean validarAnotacoesNaClasse(Class<?> clazz) {
		boolean allValidations = true;
		try {
			
			Annotation[] clazzAnnotations = clazz.getAnnotations();
			Method[] declaredMethods = clazz.getDeclaredMethods();
			for (Method method : declaredMethods) {
				Annotation[] methodAnnotations = method.getAnnotations();
				for (Annotation methodAnnotation : methodAnnotations) {
					boolean validateTrophyWhenReachPointLimit = validateTrophyWhenReachPointLimit(methodAnnotations, methodAnnotation);
					boolean validatePointsToUser = validatePointsToUser(methodAnnotations, methodAnnotation);
					boolean validateRemovePoints = validateRemovePoints(methodAnnotations, methodAnnotation);
					
					allValidations = allValidations &&
										(validateTrophyWhenReachPointLimit &&
										 validatePointsToUser &&
										 validateRemovePoints);
					
				}
				
			}
			
			for (Annotation clazzAnnotation : clazzAnnotations) {
				boolean clazzTrophyValidate = validateTrophyWhenReachPointLimit(clazzAnnotations, clazzAnnotation, declaredMethods);
				allValidations = allValidations && clazzTrophyValidate;
			}
			
			
			return allValidations;
		} catch (Exception e) {
			return allValidations;
		}							
	}

	private boolean validateTrophyWhenReachPointLimit(Annotation[] clazzAnnotations, Annotation clazzAnnotation, Method[] declaredMethods) {
		for (Method method : declaredMethods) {
			Annotation[] methodAnnotations = method.getAnnotations();
			for (Annotation methodAnnotation : methodAnnotations) {
				if(methodAnnotation instanceof PointsToUser || methodAnnotation instanceof ExtraPoints) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean validateTrophyWhenReachPointLimit(Annotation[] elementAnnotations, Annotation elementAnnotation) {
		if(elementAnnotation instanceof TrophyWhenReachPointLimit) {
			for (Annotation annotation : elementAnnotations) {
				if(annotation instanceof PointsToUser || annotation instanceof ExtraPoints) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	private boolean validatePointsToUser(Annotation[] elementAnnotations, Annotation elementAnnotation) {
		if(elementAnnotation instanceof PointsToUser) {
			for (Annotation annotation : elementAnnotations) {
				if(annotation instanceof RemovePoints || annotation instanceof LosePoint) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean validateRemovePoints(Annotation[] elementAnnotations, Annotation elementAnnotation) {
		if(elementAnnotation instanceof RemovePoints) {
			for (Annotation annotation : elementAnnotations) {
				if(annotation instanceof PointsToUser || annotation instanceof ExtraPoints) {
					return false;
				}
			}
		}
		return true;
	}

}
