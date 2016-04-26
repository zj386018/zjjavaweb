package com.baiyi.hotelsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.baiyi.hotelsystem.bean.Customer;
import com.baiyi.hotelsystem.utils.JdbcUtils;

/**
 * ��װ�˲������ݿ����οͱ�Ĺ�����
 * 
 * @category queryCustomer(String account, String passWord) �����ο��˺������ѯ���ݿ�
 * 
 * @category queryCustomerByIdNumber(String idNumber) �����ο����֤�����ѯ���ݿ�ķ���
 * 
 * @category queryCustomer(String account) �����ο��˺Ų�ѯ���ݿ�ķ���
 * 
 * @category updateCustomerByAccount(Customer customer) �����ο��˺��޸���Ϣ
 * 
 * @category updateCustomerByIdNumber(Customer customer) �����ο����֤�����޸���Ϣ
 * 
 * @category insertCustomer(Customer newCustomer)
 *           �����ο���Ϣ���ȸ����˺��жϸ��˺��Ƿ�ע�����Ȼ�����жϸ����֤�Ƿ����˺�ע���ˣ���û�У���������
 *           ������������֤�����ڸþƵ꿪�����䣬����û��ע�ᣬ��Ὣע����Ϣ���뵽�����֤�ļ�¼��Ϣ���У�
 * 
 */
public class CustomerDaoImpl {

	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * �����ο��˺Ų�ѯ���ݿ�
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
	 * �����ο��˺�,�����ѯ���ݿ�
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
	 * �����ο����֤�����ѯ���ݿ�ķ���
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

	// �����ο��˺��޸���Ϣ
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

	// �����ο����֤�޸���Ϣ
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
	 * �����ο���Ϣ���ȸ����˺��жϸ��˺��Ƿ�ע�����Ȼ�����жϸ����֤�Ƿ����˺�ע���ˣ���û�У���������
	 * ������������֤�����ڸþƵ꿪�����䣬����û��ע�ᣬ��Ὣע����Ϣ���뵽�����֤�ļ�¼��Ϣ���У�
	 */
	public int insertCustomer(Customer newCustomer) {
		// �ж��˺��Ƿ�ע��
		if (queryCustomer(newCustomer.getAccout()) != null) {
			return 1;// ********"���˺��ѱ�ע��"
		} else {/* �˺�δ��ע�� */
			// �ж����֤�Ƿ�ʹ�ù�
			if (queryCustomerByIdNumber(newCustomer.getIdNumber()) != null) {
				Customer customer = queryCustomerByIdNumber(newCustomer
						.getIdNumber());
				if (customer.getAccout() != null
						&& !customer.getAccout().equals("null")) {
					return 2;// ********"�����֤��ע����˺�";
				} else {// ���֤ʹ�ù�������δ��ע����˺�
					updateCustomerByIdNumber(newCustomer);
					return 0;// *********"ע��ɹ�";
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
				return 0;// *********"ע��ɹ�";
			}

		}

	}

}
