package org.cbsoft.framework.serializer;

import org.cbsoft.framework.formatter.PropertiesFormatter;
import org.cbsoft.framework.formatter.XMLFormatter;
import org.cbsoft.framework.processor.CompositePostProcessor;
import org.cbsoft.framework.processor.Compressor;
import org.cbsoft.framework.processor.Crypto;
import org.cbsoft.framework.processor.NullPostProcessor;
import org.cbsoft.framework.processor.PostProcessor;

public class SerializerBuilder {
	
	private Serializer serializer;
	
	public Serializer build() {
		return this.serializer;
	}

	public SerializerBuilder createXMLSerializer() {
		serializer = new FileSerializer(new NullPostProcessor(), new XMLFormatter());
		return this;
	}
	
	public SerializerBuilder createPropertiesSerializer() {
		serializer = new FileSerializer(new NullPostProcessor(), new PropertiesFormatter());
		return this;
	}
	
	public SerializerBuilder withEncription(int number) {
		PostProcessor pp = new Crypto(number);
		this.addPostProcessor(pp);
		return this;
	}
	
	private void addPostProcessor(PostProcessor postProcessor) {
		PostProcessor current = serializer.getPostProcessor();
		if(current instanceof NullPostProcessor) {
			serializer.setPostProcessor(postProcessor);
		} else {
			CompositePostProcessor composite =
					new CompositePostProcessor(current, postProcessor);
			this.serializer.setPostProcessor(composite);
		}
	}
	
	public SerializerBuilder withLogging() {
		this.serializer = new SerializerLogger(this.serializer);
		return this;
	}
	
	public SerializerBuilder withCompression() {
		PostProcessor pp = new Compressor();
		this.addPostProcessor(pp);
		return this;
	}
	
}
