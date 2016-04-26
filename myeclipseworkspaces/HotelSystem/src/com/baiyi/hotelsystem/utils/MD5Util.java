package com.baiyi.hotelsystem.utils;

import java.security.MessageDigest;

/**
 * �ɽ���Ϣת���MD5�룬��ɶ�MD5����ܽ��� Ϊ��֤�û���Ϣ��ȫ��ϵͳ�ڱ����û���Ϣ��ʱ�����Ҫ����������ܱ��浽���ݿ⡣
 * ��Ҫʹ�������ʱ��ȡ�����ݣ����ܴ����ɡ� ���Ᵽ���������롣
 */
public class MD5Util {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * ת���ֽ�����Ϊ16�����ִ�
	 * 
	 * @param b
	 *            �ֽ�����
	 * @return 16�����ִ�
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}

		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * ����MD5��
	 * 
	 * @param origin
	 * @return
	 */
	public static String getMD5(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return resultString;
	}

	/**
	 * ִ�е�һ���ǽ��м��� ִ�еڶ����ǶԼ��ܺ����Ϣ����
	 * 
	 * @param inStr
	 * @return
	 */
	public static String convertMD5(String inStr) {
		char[] a = inStr.toCharArray();

		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}

		String s = new String(a);
		return s;
	}

	public static void main(String[] args) {
		String instr = "zj386018";
		System.out.println("����MD5��" + getMD5(instr));
		System.out.println("����MD5��" + convertMD5(getMD5(instr)));
		System.out.println("����:" + convertMD5(convertMD5(getMD5(instr))));
	}

}