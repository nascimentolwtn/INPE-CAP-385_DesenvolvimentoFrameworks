package org.cbsoft.framework;

import java.io.FileOutputStream;

public class FileSerializer {

	private PostProcessor postProcessor;
	private DataFormatter dataFormatter;
	
	public FileSerializer(PostProcessor postProcessor, DataFormatter dataFormatter) {
		super();
		this.postProcessor = postProcessor;
		this.dataFormatter = dataFormatter;
	}

	public void generateFile(String filename, PropertiesGetter propGetter) {
		byte[] bytes = this.dataFormatter.formatData(propGetter.getPropertiesList());
		
		try {
			bytes = this.postProcessor.postProcess(bytes);	
			FileOutputStream fileout = new FileOutputStream(filename);
			fileout.write(bytes);
			fileout.close();
		} catch (Exception e) {
			throw new RuntimeException("Problems writing the file",e);
		}
	}
	
}