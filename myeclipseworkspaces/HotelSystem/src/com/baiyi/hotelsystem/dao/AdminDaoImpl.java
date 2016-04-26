package com.baiyi.hotelsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baiyi.hotelsystem.bean.Admin;
import com.baiyi.hotelsystem.utils.JdbcUtils;

/**
 * 封装了操作数据库中管理员表的工具类
 * 
 * @category queryAllAdmins() 查询所有酒店管理员的信息。
 * @category querySingleAdmin(String account) 按账号查询酒店管理员的信息。
 * @category updateAdmin(Admin admin) 修改酒店管理员信息。
 * @category insertAdmin(Admin admin) 添加新的管理员信息。
 * @category deleteAdmin(Admin admin) 删除管理员信息。
 * 
 */
public class AdminDaoImpl {
	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * 查询所有酒店管理员的信息（仅账号和密码）
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
			System.out.println("查询管理员数据失败");
			e.printStackTrace();
		}finally{
			jdbcUtils.close();
		}
		return admins;
	}

	/**
	 * 按酒店管理员账号查询管理员信息
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
			System.out.println("查询管理员数据失败");
			e.printStackTrace();
		}finally{
			jdbcUtils.close();
		}

		return admin;
	}

	/**
	 * 修改酒店管理员信息
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
	 * 添加新的管理员信息
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
	 * 删除管理员信息
	 * 
	 * @param admin
	 */
	public void deleteAdmin(Admin admin) {
		String sql = "delete from admins where id =" + admin.getId();
		jdbcUtils.delete(sql);
		jdbcUtils.close();
	}

}
