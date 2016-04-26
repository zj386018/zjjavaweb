package com.baiyi.hotelsystem.utils;

public class RegExpUtils {
	public static final int PASSWORD_LEVEL_ERROR = -1;
	public static final int PASSWORD_LEVEL_LOWER = 1;
	public static final int PASSWORD_LEVEL_MEDIUM = 2;
	public static final int PASSWORD_LEVEL_SENIOR = 3;

	public boolean isUserName(String userName, String regex) {
		return userName.matches(regex);
	}

	public boolean isUserName(String userName) {
		String regex = "^[a-zA-Z][\\w]{5,19}$";
		return userName.matches(regex);
	}

	/**
	 * 验证密码格式
	 * 
	 * @param passWord
	 *            用户输入的密码
	 * @param regex
	 *            自定义正则表达式
	 * @return boolean
	 */
	public boolean isPassWord(String passWord, String regex) {
		return passWord.matches(regex);
	}

	/**
	 * @param passWord
	 *            用户输入的密码
	 * @return PASSWORD_LEVEL_LOWER=1 安全级别为低
	 * @return PASSWORD_LEVEL_MEDIUM=2 安全级别为中
	 * @return PASSWORD_LEVEL_SENIOR=3 安全级别为高
	 * @return PASSWORD_LEVEL_ERROR=-1 密码格式不正确
	 */
	public int isPassWord(String passWord) {
		String regex1 = "^[\\d]{5,10}$";
		String regex2 = "^[\\w]{5,10}$";
		String regex3 = "^[\\w.#_*/\\@$%^&()]{5,10}$";

		if (passWord.matches(regex1)) {
			return PASSWORD_LEVEL_LOWER;
		} else if (passWord.matches(regex2)) {
			return PASSWORD_LEVEL_MEDIUM;
		} else if (passWord.matches(regex3)) {
			return PASSWORD_LEVEL_SENIOR;
		}
		return PASSWORD_LEVEL_ERROR;
	}

	/**
	 * 验证邮箱格式
	 * 
	 * @param email
	 *            用户邮箱
	 * @param regex
	 *            自定义正则表达式
	 * @return
	 */
	public boolean isEmail(String email, String regex) {
		return email.matches(regex);
	}

	/**
	 * 验证邮箱格式
	 * 
	 * @param email
	 *            用户邮箱
	 * @return boolean
	 */
	public boolean isEmail(String email) {
		String regex = "^[a-zA-Z]\\w{5,19}@\\w{2,5}.[a-zA-Z]{2,4}[.]?([a-z]{2,4})?&";
		return email.matches(regex);
	}

	/**
	 * 验证用户输入的手机号码
	 * 
	 * @param phoneNumber
	 * @param regex
	 * @return
	 */
	public boolean isPhoneNumber(String phoneNumber, String regex) {
		return phoneNumber.matches(regex);
	}

	public boolean isPhoneNumber(String phoneNumber) {
		String regex = "^[1][34578]\\d{9}";
		return phoneNumber.matches(regex);
	}

}