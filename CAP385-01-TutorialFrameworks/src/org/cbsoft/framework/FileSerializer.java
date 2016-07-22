package org.cbsoft.framework;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class FileSerializer {

	private PostProcessor postProcessor;
	private DataFormatter dataFormatter;
	
	public FileSerializer(PostProcessor postProcessor, DataFormatter dataFormatter) {
		super();
		this.postProcessor = postProcessor;
		this.dataFormatter = dataFormatter;
	}

	public void generateFile(String filename, Object propGetter) {
		byte[] bytes = this.dataFormatter.formatData(this.getPropertiesList(propGetter));
		
		try {
			bytes = this.postProcessor.postProcess(bytes);	
			FileOutputStream fileout = new FileOutputStream(filename);
			fileout.write(bytes);
			fileout.close();
		} catch (Exception e) {
			throw new RuntimeException("Problems writing the file",e);
		}
	}
	
	private Map<String, Object> getPropertiesList(Object obj){
		Map<String, Object> props = new HashMap<String, Object>();
		Class<?> clazz = obj.getClass();
		for (Method m : clazz.getMethods()) {
			if(isProcessableGetterMethod(m)) {
				
				try {
					Object value = m.invoke(obj);
					String getterName = m.getName();
					String propName = getterName.substring(3, 4).toLowerCase() + getterName.substring(4);
					
					props.put(propName, value);
				} catch (Exception e) {
					throw new RuntimeException("Cannot retrieve properties", e);
				}
				
			}
		}
		
		return props;
	}

	private boolean isProcessableGetterMethod(Method m) {
		return m.getName().startsWith("get") && 
		   m.getParameterTypes().length == 0 &&
		   m.getReturnType() != void.class &&
		   !m.getName().equals("getClass") &&
		   !m.isAnnotationPresent(DontIncludeOnFile.class);
	}
}