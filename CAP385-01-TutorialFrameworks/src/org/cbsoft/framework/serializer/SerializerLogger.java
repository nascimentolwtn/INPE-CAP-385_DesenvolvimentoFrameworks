package org.cbsoft.framework.serializer;

import org.cbsoft.framework.processor.PostProcessor;

public class SerializerLogger implements Serializer {
	
	private Serializer serializer;
	
	public SerializerLogger(Serializer serializer) {
		this.serializer = serializer;
	}

	@Override
	public void generateFile(String filename, Object propGetter) {
		System.out.println("Serializing file " + filename + " ...");
		serializer.generateFile(filename, propGetter);
		System.out.println("Serialization for file " + filename + " finished!");
	}

	public PostProcessor getPostProcessor() {
		return this.serializer.getPostProcessor();
	}

	public void setPostProcessor(PostProcessor postProcessor) {
		this.serializer.setPostProcessor(postProcessor);
	}

}
