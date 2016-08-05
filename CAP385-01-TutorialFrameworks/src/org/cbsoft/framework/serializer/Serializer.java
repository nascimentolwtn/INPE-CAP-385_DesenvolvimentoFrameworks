package org.cbsoft.framework.serializer;

import org.cbsoft.framework.processor.PostProcessor;

public interface Serializer {

	void generateFile(String filename, Object propGetter);

	PostProcessor getPostProcessor();

	void setPostProcessor(PostProcessor postProcessor);

}