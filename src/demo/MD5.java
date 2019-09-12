package demo;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	//notsosecurepasswordsalted
	//D029515543C86A1E51E3C15DF52F0C1A
	/*
	 * Utility function for hashing and seeding logic
	 */
	public static String md5(String string) throws NoSuchAlgorithmException {

		Charset charset = Charset.forName("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes());
		

		byte[] digest = md.digest();

		StringBuilder sb = new StringBuilder(2 * digest.length);
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();

	}

	
	
}
