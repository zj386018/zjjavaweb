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
	 * ��֤�����ʽ
	 * 
	 * @param passWord
	 *            �û����������
	 * @param regex
	 *            �Զ���������ʽ
	 * @return boolean
	 */
	public boolean isPassWord(String passWord, String regex) {
		return passWord.matches(regex);
	}

	/**
	 * @param passWord
	 *            �û����������
	 * @return PASSWORD_LEVEL_LOWER=1 ��ȫ����Ϊ��
	 * @return PASSWORD_LEVEL_MEDIUM=2 ��ȫ����Ϊ��
	 * @return PASSWORD_LEVEL_SENIOR=3 ��ȫ����Ϊ��
	 * @return PASSWORD_LEVEL_ERROR=-1 �����ʽ����ȷ
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
	 * ��֤�����ʽ
	 * 
	 * @param email
	 *            �û�����
	 * @param regex
	 *            �Զ���������ʽ
	 * @return
	 */
	public boolean isEmail(String email, String regex) {
		return email.matches(regex);
	}

	/**
	 * ��֤�����ʽ
	 * 
	 * @param email
	 *            �û�����
	 * @return boolean
	 */
	public boolean isEmail(String email) {
		String regex = "^[a-zA-Z]\\w{5,19}@\\w{2,5}.[a-zA-Z]{2,4}[.]?([a-z]{2,4})?&";
		return email.matches(regex);
	}

	/**
	 * ��֤�û�������ֻ�����
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