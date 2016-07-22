package org.cbsoft.framework;

public class Main {
	
	public static void main(String[] args){
		Product p = new Product("notebook", "HP", 1999.99, "2348203894032948");
		p.setSecretCode("não deve aparecer!");
		
		FileSerializer cxs = new FileSerializer(new Compressor(), new XMLFormatter());
		cxs.generateFile("product.zip", p);
		
		FileSerializer sps = new FileSerializer(new Crypto(5), new PropertiesFormatter());
		sps.generateFile("product.txt", p);
		
		FileSerializer zipProp = new FileSerializer(new Compressor(), new PropertiesFormatter());
		zipProp.generateFile("properties.zip", p);
		
		CompositePostProcessor cpp = new CompositePostProcessor(new Crypto(5), new Compressor());
		FileSerializer compositeCryptoZipped = new FileSerializer(cpp, new PropertiesFormatter());
		compositeCryptoZipped.generateFile("compositeCryptoZipped.zip", p);
		
		System.out.println("Done!");
	}

}
