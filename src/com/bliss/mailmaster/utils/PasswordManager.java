package com.bliss.mailmaster.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.log4j.Logger;

public class PasswordManager {

	private static Logger logger = Logger.getLogger(PasswordManager.class);

	private static Random rnd = new Random();

	private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUM = "0123456789";
	private static final String SPL_CHARS = "!@#$%^&*_=+-/";

	private static final int MIN_NUMBER_CAPS = 1;
	private static final int MIN_NUMBER_DIGITS = 1;
	private static final int MIN_NUMBER_SPL_CHARS = 1;
	private static final int MIN_CHAR_LEN = 8;
	private static final int MAX_CHAR_LEN = 12;

	public static String generatePswd() {
		logger.info("Generating new password");

		int len = rnd.nextInt(MAX_CHAR_LEN - MAX_CHAR_LEN + 1) + MIN_CHAR_LEN;
		char[] pswd = new char[len];
		int index = 0;
		for (int i = 0; i < MIN_NUMBER_CAPS; i++) {
			index = getNextIndex(rnd, len, pswd);
			pswd[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
		}
		for (int i = 0; i < MIN_NUMBER_DIGITS; i++) {
			index = getNextIndex(rnd, len, pswd);
			pswd[index] = NUM.charAt(rnd.nextInt(NUM.length()));
		}
		for (int i = 0; i < MIN_NUMBER_SPL_CHARS; i++) {
			index = getNextIndex(rnd, len, pswd);
			pswd[index] = SPL_CHARS.charAt(rnd.nextInt(SPL_CHARS.length()));
		}
		for (int i = 0; i < len; i++) {
			if (pswd[i] == 0) {
				pswd[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
			}
		}

		logger.info("Generating new password : Successful");
		return getEncryptedPassword(String.valueOf(pswd));
	}

	private static int getNextIndex(Random rnd, int len, char[] pswd) {
		int index = rnd.nextInt(len);
		while (pswd[index = rnd.nextInt(len)] != 0)
			;
		return index;
	}
	
	public static String getEncryptedPassword(String password) {
		String encryptedPassword = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] hash = md.digest(password.getBytes("UTF-8"));

			StringBuilder sb = new StringBuilder(2 * hash.length);

			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));
			}

			encryptedPassword = sb.toString();
		} catch (UnsupportedEncodingException ex) {
			logger.fatal(ex);
		} catch (NoSuchAlgorithmException ex) {
			logger.fatal(ex);
		}
		return encryptedPassword;

	}
}
