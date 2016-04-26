package com.baiyi.hotelsystem.bean;

/**
 * 员工类
 */
public class Worker {

	private int id;
	private String account;// 账号（编号）
	private String password;// 密码
	private String name;// 员工姓名
	private String phoneNumber;// 手机号码
	private String idNumber;// 身份证号码

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
