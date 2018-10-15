package org.com.shopcloud.consumer;

import java.nio.charset.Charset;
import java.util.Base64;

public class HeaderTest {

	public static void main(String[] args) {
		String auth = "shopjava:hello";
		byte[] encodeAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic" + new String(encodeAuth);
		System.out.println(authHeader);
	}

}
