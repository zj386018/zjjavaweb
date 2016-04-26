package com.baiyi.hotelsystem.bean;

public class Home {

	/**
	 * �����Ѿ���ס
	 */
	public static final int HOMESTATE_CHECKIN = 1;
	/**
	 * �����ѱ�Ԥ��
	 */
	public static final int HOMESTATE_BOOK = 2;
	/**
	 * �������
	 */
	public static final int HOMESTATE_EMPTY = 0;

	private int id;
	private String homeNumber;// ������
	private String homeDescribe;// ��������
	private double homePrice;// ����۸�
	private int homeState;// ����״̬ ��ס��1����ά�ޣ�-1����Ԥ����2�������У�0��
	private boolean isCanCheckin;// �����Ƿ����ס 1������ס�� 0����������ס
	private String customerName;// ������ס��Ԥ���ο͵�����
	private String customerIdNumber;// �ο͵����֤����
	private String customerPhoneNumber;// �ο͵绰

	public Home() {
		super();
	}

	public Home(String homeNumber, String homeDescribe, double homePrice,
			int homeState, boolean isCanCheckin, String customerName,
			String customerIdNumber, String customerPhoneNumber) {
		super();
		this.homeNumber = homeNumber;
		this.homeDescribe = homeDescribe;
		this.homePrice = homePrice;
		this.homeState = homeState;
		this.isCanCheckin = isCanCheckin;
		this.customerName = customerName;
		this.customerIdNumber = customerIdNumber;
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getHomeDescribe() {
		return homeDescribe;
	}

	public void setHomeDescribe(String homeDescribe) {
		this.homeDescribe = homeDescribe;
	}

	public double getHomePrice() {
		return homePrice;
	}

	public void setHomePrice(double homePrice) {
		this.homePrice = homePrice;
	}

	public int getHomeState() {
		return homeState;
	}

	public void setHomeState(int homeState) {
		this.homeState = homeState;
	}

	public boolean isCanCheckin() {
		return isCanCheckin;
	}

	public void setCanCheckin(boolean isCanCheckin) {
		this.isCanCheckin = isCanCheckin;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerIdNumber() {
		return customerIdNumber;
	}

	public void setCustomerIdNumber(String customerIdNumber) {
		this.customerIdNumber = customerIdNumber;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", homeNumber=" + homeNumber
				+ ", homeDescribe=" + homeDescribe + ", homePrice=" + homePrice
				+ ", homeState=" + homeState + ", isCanCheckin=" + isCanCheckin
				+ ", customerName=" + customerName + ", customerIdNumber="
				+ customerIdNumber + ", customerPhoneNumber="
				+ customerPhoneNumber + "]";
	}
	
	

}
