package com.hieu.regex;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encode {

	public String encodePassword(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(input.getBytes());
			return convertByteToHex1(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public String convertByteToHex1(byte[] data) {
		BigInteger number = new BigInteger(1, data);
		String hashtext = number.toString(16);
		return hashtext;
	}
}
