package com.baiyi.hotelsystem.bean;

public class Home {

	/**
	 * 房间已经入住
	 */
	public static final int HOMESTATE_CHECKIN = 1;
	/**
	 * 房间已被预订
	 */
	public static final int HOMESTATE_BOOK = 2;
	/**
	 * 房间空闲
	 */
	public static final int HOMESTATE_EMPTY = 0;

	private int id;
	private String homeNumber;// 房间编号
	private String homeDescribe;// 房间描述
	private double homePrice;// 房间价格
	private int homeState;// 房间状态 入住（1）、维修（-1）、预订（2）、空闲（0）
	private boolean isCanCheckin;// 房间是否可入住 1：可入住； 0：不可以入住
	private String customerName;// 房间入住或预订游客的姓名
	private String customerIdNumber;// 游客的身份证号码
	private String customerPhoneNumber;// 游客电话

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
