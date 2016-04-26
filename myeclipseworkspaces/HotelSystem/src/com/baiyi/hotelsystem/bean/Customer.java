package com.baiyi.hotelsystem.bean;

public class Customer {

	/**
	 * �ο��뿪״̬
	 */
	public static int CUSTOMER_STATE_LEAVE = 0;
	/**
	 * �ο�Ԥ������״̬
	 */
	public static int CUSTOMER_STATE_BOOK = 1;
	/**
	 * �ο���ס״̬
	 */
	public static int CUSTOMER_STATE_LIVEIN = 2;
	
	private int id;
	private String accout;// �˺�
	private String password;// ����
	private String name;// ����
	private String phoneNumber;// �绰����
	private String idNumber;// ���֤����
	private int state;// ״̬��0--�뿪��1--Ԥ����2--��ס
	private String homeNumber;// Ԥ������ס������

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
