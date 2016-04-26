package com.baiyi.hotelsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baiyi.hotelsystem.bean.Admin;
import com.baiyi.hotelsystem.utils.JdbcUtils;

/**
 * ��װ�˲������ݿ��й���Ա��Ĺ�����
 * 
 * @category queryAllAdmins() ��ѯ���оƵ����Ա����Ϣ��
 * @category querySingleAdmin(String account) ���˺Ų�ѯ�Ƶ����Ա����Ϣ��
 * @category updateAdmin(Admin admin) �޸ľƵ����Ա��Ϣ��
 * @category insertAdmin(Admin admin) ����µĹ���Ա��Ϣ��
 * @category deleteAdmin(Admin admin) ɾ������Ա��Ϣ��
 * 
 */
public class AdminDaoImpl {
	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * ��ѯ���оƵ����Ա����Ϣ�����˺ź����룩
	 * 
	 * @return
	 */
	public List<Admin> queryAllAdmins() {
		String sql = "select * from admins";
		ResultSet rs = jdbcUtils.query(sql);
		List<Admin> admins = new ArrayList<Admin>();

		try {
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAccount(rs.getString("account"));
				admin.setPassword(rs.getString("password"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			System.out.println("��ѯ����Ա����ʧ��");
			e.printStackTrace();
		}finally{
			jdbcUtils.close();
		}
		return admins;
	}

	/**
	 * ���Ƶ����Ա�˺Ų�ѯ����Ա��Ϣ
	 * 
	 * @param account
	 * @return
	 */
	public Admin querySingleAdmin(String account) {
		Admin admin = new Admin();
		String sql = "select * from admins where account='" + account + "'";
		ResultSet rs = jdbcUtils.query(sql);

		try {
			while (rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setAccount(rs.getString("account"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ����Ա����ʧ��");
			e.printStackTrace();
		}finally{
			jdbcUtils.close();
		}

		return admin;
	}

	/**
	 * �޸ľƵ����Ա��Ϣ
	 * 
	 * @param admin
	 */
	public void updateAdmin(Admin admin) {
		String sql = "update admins SET account='" + admin.getAccount()
				+ "' ,password='" + admin.getPassword() + "' where id="
				+ admin.getId();
		jdbcUtils.update(sql);
		jdbcUtils.close();
	}

	/**
	 * ����µĹ���Ա��Ϣ
	 * 
	 * @param admin
	 */
	public void insertAdmin(Admin admin) {
		String sql = "insert into admins(account,password) " + "values('"
				+ admin.getAccount() + "','" + admin.getPassword() + "')";
		jdbcUtils.insert(sql);
		jdbcUtils.close();
	}

	/**
	 * ɾ������Ա��Ϣ
	 * 
	 * @param admin
	 */
	public void deleteAdmin(Admin admin) {
		String sql = "delete from admins where id =" + admin.getId();
		jdbcUtils.delete(sql);
		jdbcUtils.close();
	}

}
