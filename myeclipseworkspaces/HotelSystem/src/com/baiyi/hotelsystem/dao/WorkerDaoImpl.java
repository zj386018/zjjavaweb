package com.baiyi.hotelsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baiyi.hotelsystem.bean.Admin;
import com.baiyi.hotelsystem.bean.Worker;
import com.baiyi.hotelsystem.utils.JdbcUtils;

/**
 * 
 * 封装了操作数据库中工作人员表的工具类
 * 
 * @category queryAllWorkers() 查询所有酒店工作人员信息
 * @category querySingleWorker(String account) 按账号查询工作人员信息
 * @category updateWorker(Worker worker) 修改工作人员的信息
 * @category insertWorker(Worker worker) 添加新工作人员的信息
 * @category deleteWorker(Admin worker) 删除员工的信息
 * @category querySingleWorker(String account,String password) 
 * 									按账号密码查询工作人员信息
 */
public class WorkerDaoImpl {

	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * 查询所有酒店工作人员的信息
	 * 
	 * @return
	 */
	public List<Worker> queryAllWorkers() {
		String sql = "select * from workers";
		ResultSet rs = jdbcUtils.query(sql);
		List<Worker> workers = new ArrayList<Worker>();

		try {
			while (rs.next()) {
				Worker worker = new Worker();
				worker.setId(rs.getInt("id"));
				worker.setAccount(rs.getString("account"));
				worker.setIdNumber(rs.getString("idNumber"));
				worker.setName(rs.getString("name"));
				worker.setPassword(rs.getString("password"));
				worker.setPhoneNumber(rs.getString("phoneNumber"));
				workers.add(worker);
			}
		} catch (SQLException e) {
			System.out.println("查询工作人员数据失败");
			e.printStackTrace();
		}finally{
			jdbcUtils.close();
		}
		return workers;
	}

	/**
	 * 按工作人员账号查找工作人员信息
	 * 
	 * @param account
	 * @return
	 */
	public Worker querySingleWorker(String account) {
		Worker worker = new Worker();
		String sql = "select * from workers where account='" + account + "'";
		ResultSet rs = jdbcUtils.query(sql);
		try {
			while (rs.next()) {
				worker.setId(rs.getInt("id"));
				worker.setAccount(rs.getString("account"));
				worker.setIdNumber(rs.getString("idNumber"));
				worker.setName(rs.getString("name"));
				worker.setPassword(rs.getString("password"));
				worker.setPhoneNumber(rs.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			System.out.println("查询工作人员数据失败");
			e.printStackTrace();
		} finally {
			jdbcUtils.close();
		}

		return worker;
	}
	
	/**
	 * 按工作人员账号和密码来查询信息 
	 */
	public Worker querySingleWorker(String account,String password){
		Worker worker = querySingleWorker( account);
		if(worker.getAccount()==null||worker.getAccount().equals("null")){
			worker = null;
		}else{
			if(!worker.getPassword().equals(password)){
				worker = null;
			}
		}
		return worker;
	}

	/**
	 * 修改酒店工作人员的信息
	 * 
	 * @param admin
	 */
	public void updateWorker(Worker worker) {
		String sql = "update workers SET account='" + worker.getAccount()
				+ "' ,password='" + worker.getPassword()
				+ "',name='" + worker.getName()
				+ "',phoneNumber='" + worker.getPhoneNumber()
				+ "',idNumber='" + worker.getIdNumber()
				+ "' where id=" + worker.getId();
		jdbcUtils.update(sql);
		jdbcUtils.close();
	}

	/**
	 * 添加新的工作人员的信息
	 * 
	 * @param admin
	 */
	public void insertWorker(Worker worker) {
		String sql = "insert into workers(account,password,name,phoneNumber,idNumber) "
				+ "values('"
				+ worker.getAccount()
				+ "','"
				+ worker.getPassword()
				+ "','"
				+ worker.getName()
				+ "','"
				+ worker.getPhoneNumber() + "','" + worker.getIdNumber() + "')";
		jdbcUtils.insert(sql);
		jdbcUtils.close();
	}

	/**
	 * 删除管理员信息
	 * 
	 * @param admin
	 */
	public void deleteWorker(Admin worker) {
		String sql = "delete from workers where id =" + worker.getId();
		jdbcUtils.delete(sql);
		jdbcUtils.close();
	}

}
