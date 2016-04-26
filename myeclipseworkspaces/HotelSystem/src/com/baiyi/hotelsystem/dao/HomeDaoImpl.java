package com.baiyi.hotelsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baiyi.hotelsystem.bean.Home;
import com.baiyi.hotelsystem.utils.JdbcUtils;

/**
 * ��װ�˲������ݿ��з����Ĺ�����
 * 
 * @category queryAllHomes() ��ѯ���з���
 * @category queryCanCheckinHome() ��ѯ���п�����ס�ķ���
 * @category updateHomeById(Home home) �������ݿ��е�id���޸ķ�����Ϣ
 * @category updateHomeByNumber(Home home) �����������޸ķ�����Ϣ
 * @category insertHome(Home home) �����Ƶ귿����Ϣ
 */
public class HomeDaoImpl {

	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * ��ѯ���еķ�����Ϣ
	 * 
	 * @return
	 */
	public List<Home> queryAllHomes() {
		// ����left join���������ѯ
		// SELECT a.id,a.homeNumber,a.homeDescribe,a.homePrice,a.isCanCheckin,a.customerIdNumber,b.name,b.idNumber,b.phoneNumber
		// FROM homes a LEFT JOIN customers b ON b.idNumber = a.customerIdNumber

		String sql = "select a.id,a.homeNumber,a.homeDescribe,a.homePrice,a.homeState,a.isCanCheckin,"
				+ "a.customerIdNumber,"
				+ "b.name,b.phoneNumber from homes a left join customers b on b.idNumber = a.customerIdNumber order by a.id";
		ResultSet rs = jdbcUtils.query(sql);
		List<Home> homes = new ArrayList<Home>();
		try {
			while (rs.next()) {
				Home home = new Home();
				home.setId(rs.getInt("id"));
				home.setHomeNumber(rs.getString("homeNumber"));
				home.setHomeDescribe(rs.getString("homeDescribe"));
				home.setHomePrice(rs.getDouble("homePrice"));
				home.setHomeState(rs.getInt("homeState"));
				home.setCanCheckin(rs.getBoolean("isCanCheckin"));
				home.setCustomerIdNumber(rs.getString("customerIdNumber"));
				home.setCustomerName(rs.getString("name"));
				home.setCustomerPhoneNumber(rs.getString("phoneNumber"));
				homes.add(home);
			}
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
			System.out.println(e);
		} finally {
			jdbcUtils.close();
		}
		return homes;
	}

	public Home queryHomeByHomeNumber(String homeNumber){
		
		String sql = "select * from homes where homeNumber = '"+homeNumber+"'";
		ResultSet rs = jdbcUtils.query(sql);
		Home home = new Home();
		try {
			while (rs.next()) {
				home.setId(rs.getInt("id"));
				home.setHomeState(rs.getInt("homeState"));
				home.setHomePrice(rs.getDouble("homePrice"));
				home.setHomeNumber(rs.getString("homeNumber"));
				home.setHomeDescribe(rs.getString("homeDescribe"));
				home.setCanCheckin(rs.getBoolean("isCanCheckin"));
				home.setCustomerIdNumber(rs.getString("customerIdNumber"));
			}
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
		} finally {
			jdbcUtils.close();
		}
		return home;
	}
	
	
	/**
	 * ��ѯ������ס�ķ���
	 * isCanCheckin = 1 ��ʾ������ס
	 * @return ���ظþƵ����п�����ס�ķ������Ϣ
	 */
	public List<Home> queryCanCheckinHome() {
		String sql = "select * from homes where isCanCheckin = 1";
		ResultSet rs = jdbcUtils.query(sql);
		List<Home> homes = new ArrayList<Home>();
		try {
			while (rs.next()) {
				Home home = new Home();
				home.setId(rs.getInt("id"));
				home.setHomeState(rs.getInt("homeState"));
				home.setHomePrice(rs.getDouble("homePrice"));
				home.setHomeNumber(rs.getString("homeNum"));
				home.setHomeDescribe(rs.getString("homeDescribe"));
				home.setCanCheckin(rs.getBoolean("isCanCheckin"));
				homes.add(home);
			}
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
		} finally {
			jdbcUtils.close();
		}
		return homes;
	}

	/**
	 * ����id�޸ķ�������
	 * id�Ƿ��������ݿ��еı�ţ��뷿���Ų�ͬ��������ʾ���û�����
	 * 
	 * ����ǹ�����Ա�Է�����Ϣ�����޸ģ������޸ķ����ţ�������������Ϣ��������
	 * �ø÷��������������Ա�޸ĵ��Ƿ����ţ���ֻ��ʹ�ø÷���
	 */
	public void updateHomeById(Home home) {
		
		 String sql = "update homes SET " +
		 		"homeNumber='" + home.getHomeNumber()
		 + "' ,homeDescribe='" + home.getHomeDescribe()
		 + "' ,homePrice=" + home.getHomePrice()
		 + " ,homeState='" + home.getHomeState()
		 + "' ,isCanCheckin=" + home.isCanCheckin()
		 +",customerIdNumber='"+home.getCustomerIdNumber()
		 + "' where id=" + home.getId();
		 jdbcUtils.update(sql);
		 jdbcUtils.close();
	}
	
	/**
	 * ���ݷ������޸ķ�������
	 * ���������û����Կ��õ���
	 * 
	 * ������ο�Ԥ������͹�����Ա�Ǽ��û�������Ϣ������ʹ�ø÷���
	 */
	public void updateHomeByNumber(Home home) {
		
		 String sql = "update homes SET " 
		 + "homeDescribe='" + home.getHomeDescribe()
		 + "' ,homePrice=" + home.getHomePrice()
		 + " ,homeState='" + home.getHomeState()
		 + "' ,isCanCheckin=" + home.isCanCheckin()
		 +",customerIdNumber='"+home.getCustomerIdNumber()
		 + "' where homeNumber='" + home.getHomeNumber()+"'";
		 jdbcUtils.update(sql);
		 jdbcUtils.close();
		 
	}
	
	/**
	 * �����Ƶ귿����Ϣ
	 * 
	 * �Ƶ��������˷��䣬�ø÷��������ݿ�����������ķ������Ϣ
	 * 
	 */
	public void insertHome(Home home) {
		//INSERT INTO homes(homeNumber,homeDescribe,homePrice,homeState,isCanCheckin,customerIdNumber) 
		//VALUES('101','1122334455566',588,1,TRUE,'51356441321');
		
		 String sql = "INSERT INTO homes(homeNumber,homeDescribe,homePrice," +
		 		"homeState,isCanCheckin,customerIdNumber) " +
		 		"VALUES('" + home.getHomeNumber()
		 + "' ,'" + home.getHomeDescribe()
		 + "' ," + home.getHomePrice()
		 + "," + home.getHomeState()
		 + "," + home.isCanCheckin()
		 +",'"+home.getCustomerIdNumber()
		 + "')";
		 jdbcUtils.update(sql);
		 jdbcUtils.close();

	}

}
