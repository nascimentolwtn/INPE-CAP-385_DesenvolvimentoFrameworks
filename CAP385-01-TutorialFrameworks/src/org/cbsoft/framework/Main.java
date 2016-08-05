package org.cbsoft.framework;

import org.cbsoft.framework.domain.Product;
import org.cbsoft.framework.formatter.PropertiesFormatter;
import org.cbsoft.framework.processor.Crypto;
import org.cbsoft.framework.serializer.FileSerializer;
import org.cbsoft.framework.serializer.Serializer;
import org.cbsoft.framework.serializer.SerializerBuilder;
import org.cbsoft.framework.serializer.SerializerLogger;

public class Main {
	
	public static void main(String[] args){
		Product p = new Product("notebook", "HP", 1999.99, "2348203894032948");
		p.setSecretCode("não deve aparecer!");
		
		SerializerBuilder builder = new SerializerBuilder();
		Serializer cxs = builder.createXMLSerializer()
				.withCompression().withLogging().build();
		cxs.generateFile("product.zip", p);
		
		Serializer sps = builder.createPropertiesSerializer()
				.withEncription(5).withLogging().build(); 
		sps.generateFile("product.txt", p);
		
		Serializer zipProp = builder.createPropertiesSerializer()
				.withCompression().withLogging().build();
		zipProp.generateFile("properties.zip", p);
		
		Serializer compositeCryptoZipped = builder.createPropertiesSerializer()
				.withEncription(5).withCompression().withLogging().build();
		compositeCryptoZipped.generateFile("compositeCryptoZipped.zip", p);
		
		Serializer logger4classes = new SerializerLogger(new FileSerializer(new Crypto(4), new PropertiesFormatter()));
		logger4classes.generateFile("sembuilder.txt", p);
		
		System.out.println("Done!");
	}

}
