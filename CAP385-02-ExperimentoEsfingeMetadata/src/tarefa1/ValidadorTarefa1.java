package tarefa1;

import org.esfinge.metadata.validate.MetadataValidator;

public class ValidadorTarefa1 {
	
	public boolean validarAnotacoesNaClasse(Class<?> clazz) {
		try {
			MetadataValidator.validateMetadataOn(clazz);
			return true;
		} catch (Exception e) {
			return false;
		}							
	}

}
