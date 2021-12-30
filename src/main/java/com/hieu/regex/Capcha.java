package com.hieu.regex;

import java.util.Random;

public class Capcha {

	/*
	 * math.random chay tu 0-1, toi thieu la 6 ki tu capcha
	 */
	public StringBuilder getCapcha() {
		Random rn = new Random();
		int n = (int) (3*Math.random() + 6);
		 String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                 + "0123456789"
                 + "abcdefghijklmnopqrstuvxyz";
		 StringBuilder sb = new StringBuilder(n);
		 for (int i = 0; i < n; i++) {
			  
	            // generate a random number between
	            // 0 to AlphaNumericString variable length
	            int index= (int)(str.length() * Math.random());
	            // add Character one by one in end of sb
	            sb.append(str.charAt(index));
	        }
		 return sb;
	}
	public static void main(String[] args) {
		Capcha capcha = new Capcha();
		System.out.println(capcha.getCapcha());
	}
}
