package com.baiyi.hotelsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baiyi.hotelsystem.bean.Home;
import com.baiyi.hotelsystem.utils.JdbcUtils;

/**
 * 封装了操作数据库中房间表的工具类
 * 
 * @category queryAllHomes() 查询所有房间
 * @category queryCanCheckinHome() 查询所有可以入住的房间
 * @category updateHomeById(Home home) 按在数据库中的id来修改房间信息
 * @category updateHomeByNumber(Home home) 按房间编号来修改房间信息
 * @category insertHome(Home home) 新增酒店房间信息
 */
public class HomeDaoImpl {

	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * 查询所有的房间信息
	 * 
	 * @return
	 */
	public List<Home> queryAllHomes() {
		// 利用left join进行联表查询
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
			System.out.println("加载数据失败");
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
			System.out.println("加载数据失败");
		} finally {
			jdbcUtils.close();
		}
		return home;
	}
	
	
	/**
	 * 查询可以入住的房间
	 * isCanCheckin = 1 表示可以入住
	 * @return 返回该酒店所有可以入住的房间的信息
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
			System.out.println("加载数据失败");
		} finally {
			jdbcUtils.close();
		}
		return homes;
	}

	/**
	 * 根据id修改房间内容
	 * id是房间在数据库中的编号，与房间编号不同，不会显示给用户看到
	 * 
	 * 如果是工作人员对房间信息进行修改（比如修改房间编号，房间描述等信息），建议
	 * 用该方法，如果工作人员修改的是房间编号，则只能使用该方法
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
	 * 根据房间编号修改房间内容
	 * 房间编号是用户可以看得到的
	 * 
	 * 如果是游客预订房间和工作人员登记用户开房信息，可以使用该方法
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
	 * 新增酒店房间信息
	 * 
	 * 酒店若新增了房间，用该方法在数据库中添加新增的房间的信息
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
