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

	public SerializerInConstruction createXMLSerializer() {
		return new SerializerInConstruction(new FileSerializer(new NullPostProcessor(), new XMLFormatter()));
	}
	
	public SerializerInConstruction createPropertiesSerializer() {
		return new SerializerInConstruction(new FileSerializer(new NullPostProcessor(), new PropertiesFormatter()));
	}
	
	public class SerializerInConstruction {
		
		public SerializerInConstruction(Serializer serializer) {
			SerializerBuilder.this.serializer = serializer;
		}
		
		public SerializerInConstruction withEncription(int number) {
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
				SerializerBuilder.this.serializer.setPostProcessor(composite);
			}
		}
		
		public SerializerInConstruction withLogging() {
			SerializerBuilder.this.serializer = new SerializerLogger(SerializerBuilder.this.serializer);
			return this;
		}
		
		public SerializerInConstruction withCompression() {
			PostProcessor pp = new Compressor();
			this.addPostProcessor(pp);
			return this;
		}
		
		public Serializer build() {
			return SerializerBuilder.this.serializer;
		}

	}
	
}
