package br.inpe.cap.junit5.extension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class TestHashNewString {

	private static byte[] hash;

	@BeforeAll static void createHash() throws NoSuchAlgorithmException {
		String senha = "password";
		
		MessageDigest digest = MessageDigest.getInstance("SHA-512");
		hash = digest.digest(senha.getBytes(StandardCharsets.UTF_8));
	}
	
	
	@Test void crypto() {
		
		String cryptoSenha = new String(hash);

		System.out.println(cryptoSenha);
		
		assertEquals("�	�$N�$A�~�ma���	���^9Lpj�����x^Yv��F�_&�Z.����S������", cryptoSenha);
		
	}

	@Test void cryptoWithUTF8Charset() {
		
		String cryptoSenha = new String(hash, Charset.forName("UTF-8"));

		System.out.println(cryptoSenha);
		
		assertEquals("�	�$N�$A�~�ma���	���^9Lpj�����x^Yv��F�_&�Z.����S������", cryptoSenha);
		
	}

	@DisabledOnOs(OS.WINDOWS)
	@Test void cryptoWithDefaultCharset() {
		
		String cryptoSenha = new String(hash, Charset.forName("ISO-8859-1"));

		System.out.println(cryptoSenha);
		
		assertEquals("±	ó»¼$N¸$A~ÐmaÝ	³¾ý^9Lpj¹±×x^YvìFß_&¯Z.¦ÑýÉSÿ«¬¼", cryptoSenha);
		
	}

}
