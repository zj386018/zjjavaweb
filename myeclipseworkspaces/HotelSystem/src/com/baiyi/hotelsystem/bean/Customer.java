package com.baiyi.hotelsystem.bean;

public class Customer {

	/**
	 * 游客离开状态
	 */
	public static int CUSTOMER_STATE_LEAVE = 0;
	/**
	 * 游客预订房间状态
	 */
	public static int CUSTOMER_STATE_BOOK = 1;
	/**
	 * 游客在住状态
	 */
	public static int CUSTOMER_STATE_LIVEIN = 2;
	
	private int id;
	private String accout;// 账号
	private String password;// 密码
	private String name;// 姓名
	private String phoneNumber;// 电话号码
	private String idNumber;// 身份证号码
	private int state;// 状态：0--离开；1--预订；2--在住
	private String homeNumber;// 预订或在住房间编号

	public Customer() {
	}

	public Customer(String accout, String password, String name,
			String phoneNumber, String idNumber, int state, String homeNumber) {
		this.accout = accout;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.idNumber = idNumber;
		this.state = state;
		this.homeNumber = homeNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccout() {
		return accout;
	}

	public void setAccout(String accout) {
		this.accout = accout;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", accout=" + accout + ", password="
				+ password + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", idNumber=" + idNumber + ", state=" + state
				+ ", homeNumber=" + homeNumber + "]";
	}
	
	

}
