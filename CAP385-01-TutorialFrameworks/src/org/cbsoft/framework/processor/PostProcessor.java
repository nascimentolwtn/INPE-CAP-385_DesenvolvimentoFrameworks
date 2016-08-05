package org.cbsoft.framework.processor;

import java.io.IOException;

public interface PostProcessor {

	byte[] postProcess(byte[] bytes) throws IOException;
	
}
