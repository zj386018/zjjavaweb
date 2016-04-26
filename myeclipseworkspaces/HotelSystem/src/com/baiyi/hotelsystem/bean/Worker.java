package com.baiyi.hotelsystem.bean;

/**
 * Ա����
 */
public class Worker {

	private int id;
	private String account;// �˺ţ���ţ�
	private String password;// ����
	private String name;// Ա������
	private String phoneNumber;// �ֻ�����
	private String idNumber;// ���֤����

	public Worker() {
	}

	public Worker(String account, String password, String name,
			String phoneNumber, String idNumber) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.idNumber = idNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", account=" + account + ", password="
				+ password + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", idNumber=" + idNumber + "]";
	}
	
}
