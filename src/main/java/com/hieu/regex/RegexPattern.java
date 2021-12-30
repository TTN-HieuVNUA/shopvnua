package com.hieu.regex;

import java.util.regex.Pattern;

public class RegexPattern {

	/*
	 * chấp nhận gmail, không chấp nhận mail khác
	 */
	public boolean checkEmail(String email) {
		String email_pattren = "[a-z_0-9]{1,}@[a-z]{4,}.[\\w]{3}";
		String email_pattren1 = "[0-9]{6}@[a-z]{2}.[a-z]{4}.[a-z]{3}.[a-z]{2}";
		if(Pattern.matches(email_pattren, email) == true || Pattern.matches(email_pattren1, email))  {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * trả về chuỗi kí tự dùng cho tên
	 */
	public String deleteSpicialCharacter(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		str = str.replaceAll("[!-/_0-9_:-?]+", "");
		return str;
	}
	
	public boolean checkPassword(String password) {
//		if(password.length()<5 && ) {
//			return false;
//		}
		return true;
	}
}
