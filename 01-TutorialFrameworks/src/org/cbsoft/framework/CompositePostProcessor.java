package org.cbsoft.framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositePostProcessor implements PostProcessor {
	
	private List<PostProcessor> processors;

	public CompositePostProcessor(PostProcessor... listProcessors) {
		super();
		this.processors = new ArrayList<PostProcessor>();
		Collections.addAll(this.processors, listProcessors);
	}

	@Override
	public byte[] postProcess(byte[] bytes) throws IOException {
		for (PostProcessor p : this.processors) {
			bytes = p.postProcess(bytes);
		}
		return bytes;
	}

}
