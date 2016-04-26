package com.baiyi.hotelsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.baiyi.hotelsystem.bean.Customer;
import com.baiyi.hotelsystem.utils.JdbcUtils;

/**
 * 封装了操作数据库中游客表的工具类
 * 
 * @category queryCustomer(String account, String passWord) 根据游客账号密码查询数据库
 * 
 * @category queryCustomerByIdNumber(String idNumber) 根据游客身份证号码查询数据库的方法
 * 
 * @category queryCustomer(String account) 根据游客账号查询数据库的方法
 * 
 * @category updateCustomerByAccount(Customer customer) 根据游客账号修改信息
 * 
 * @category updateCustomerByIdNumber(Customer customer) 根据游客身份证号码修改信息
 * 
 * @category insertCustomer(Customer newCustomer)
 *           新增游客信息（先根据账号判断该账号是否被注册过，然后再判断该身份证是否有账号注册了，若没有，则进行添加
 *           但是如果该身份证曾经在该酒店开过房间，但是没有注册，则会将注册信息插入到该身份证的记录信息当中）
 * 
 */
public class CustomerDaoImpl {

	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * 根据游客账号查询数据库
	 * 
	 * @return customer
	 */
	public Customer queryCustomer(String account) {
		String sql = "select * from customers where account ='" + account + "'";
		ResultSet rst = jdbcUtils.query(sql);
		Customer customer = null;
		try {
			while (rst.next()) {
				if (rst.getString("account").equals("null")||null==rst.getString("account")) {
					customer = null;
				} else {
					customer = new Customer();
					customer.setId(rst.getInt("id"));
					customer.setAccout(rst.getString("account"));
					customer.setPassword(rst.getString("password"));
					customer.setName(rst.getString("name"));
					customer.setPhoneNumber(rst.getString("phoneNumber"));
					customer.setIdNumber(rst.getString("idNumber"));
					customer.setState(rst.getInt("state"));
					customer.setHomeNumber(rst.getString("homeNumber"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close();
		}
		return customer;
	}

	/**
	 * 根据游客账号,密码查询数据库
	 * 
	 * @return customer
	 */
	public Customer queryCustomer(String account, String passWord) {
		Customer customer = queryCustomer(account);
		if (customer == null) {
			return null;
		} else if (!customer.getPassword().equals(passWord)) {
			return null;
		} else {
			return customer;
		}
	}

	/**
	 * 根据游客身份证号码查询数据库的方法
	 * 
	 * @param idNumber
	 * @return customer
	 */
	public Customer queryCustomerByIdNumber(String idNumber) {
		String sql = "select * from customers where idNumber ='" + idNumber
				+ "'";
		ResultSet rst = jdbcUtils.query(sql);
		Customer customer = null;
		try {
			while (rst.next()) {
				if (rst.getString("idNumber").equals("null")||null==rst.getString("idNumber")) {
					customer = null;
				} else {
					customer = new Customer();
					customer.setId(rst.getInt("id"));
					customer.setAccout(rst.getString("account"));
					customer.setPassword(rst.getString("password"));
					customer.setName(rst.getString("name"));
					customer.setPhoneNumber(rst.getString("phoneNumber"));
					customer.setIdNumber(rst.getString("idNumber"));
					customer.setState(rst.getInt("state"));
					customer.setHomeNumber(rst.getString("homeNumber"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.close();
		}
		return customer;
	}

	// 根据游客账号修改信息
	public void updateCustomerByAccount(Customer customer) {
		String sql = "update customers set password = '"
				+ customer.getPassword() + "', name = '" + customer.getName()
				+ "', phoneNumber = '" + customer.getPhoneNumber()
				+ "', idNumber = '" + customer.getIdNumber() + "', state = "
				+ customer.getState() + " , homeNumber = '"
				+ customer.getHomeNumber() + "' where account = '"
				+ customer.getAccout() + "'";
		jdbcUtils.update(sql);
		jdbcUtils.close();
	}

	// 根据游客身份证修改信息
	public void updateCustomerByIdNumber(Customer customer) {

		String sql = "update customers set password = '"
				+ customer.getPassword() + "', name = '" + customer.getName()
				+ "', phoneNumber = '" + customer.getPhoneNumber()
				+ "', account = '" + customer.getAccout() + "', state = "
				+ customer.getState() + " , homeNumber = '"
				+ customer.getHomeNumber() + "' where idNumber = '"
				+ customer.getIdNumber() + "'";
		jdbcUtils.update(sql);
		jdbcUtils.close();

	}

	/**
	 * 新增游客信息（先根据账号判断该账号是否被注册过，然后再判断该身份证是否有账号注册了，若没有，则进行添加
	 * 但是如果该身份证曾经在该酒店开过房间，但是没有注册，则会将注册信息插入到该身份证的记录信息当中）
	 */
	public int insertCustomer(Customer newCustomer) {
		// 判断账号是否被注册
		if (queryCustomer(newCustomer.getAccout()) != null) {
			return 1;// ********"该账号已被注册"
		} else {/* 账号未被注册 */
			// 判断身份证是否被使用过
			if (queryCustomerByIdNumber(newCustomer.getIdNumber()) != null) {
				Customer customer = queryCustomerByIdNumber(newCustomer
						.getIdNumber());
				if (customer.getAccout() != null
						&& !customer.getAccout().equals("null")) {
					return 2;// ********"该身份证已注册过账号";
				} else {// 身份证使用过，但是未曾注册过账号
					updateCustomerByIdNumber(newCustomer);
					return 0;// *********"注册成功";
				}
			} else {
				String sql = "INSERT INTO customers(account,password,name,"
						+ "phoneNumber,idNumber,state,homeNumber) "
						+ "VALUES('" + newCustomer.getAccout() + "' ,'"
						+ newCustomer.getPassword() + "' ,'"
						+ newCustomer.getName() + "' ,'"
						+ newCustomer.getPhoneNumber() + "' ,'"
						+ newCustomer.getIdNumber() + "' ,"
						+ newCustomer.getState() + ", '"
						+ newCustomer.getHomeNumber() + "')";
				jdbcUtils.insert(sql);
				jdbcUtils.close();
				return 0;// *********"注册成功";
			}

		}

	}

}
