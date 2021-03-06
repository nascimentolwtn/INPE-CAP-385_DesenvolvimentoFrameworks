package org.cbsoft.framework.processor;

import java.io.IOException;

public class Crypto implements PostProcessor {

	private int delay;
	
	public Crypto(int delay) {
		super();
		this.delay = delay;
	}

	@Override
	public byte[] postProcess(byte[] bytes) throws IOException {
		byte[] newBytes = new byte[bytes.length];
		for(int i=0;i<bytes.length;i++){
			newBytes[i]= (byte) ((bytes[i]+delay) % Byte.MAX_VALUE);
		}
		return newBytes;
	}

}
