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
 * ��װ�˲������ݿ��й�����Ա��Ĺ�����
 * 
 * @category queryAllWorkers() ��ѯ���оƵ깤����Ա��Ϣ
 * @category querySingleWorker(String account) ���˺Ų�ѯ������Ա��Ϣ
 * @category updateWorker(Worker worker) �޸Ĺ�����Ա����Ϣ
 * @category insertWorker(Worker worker) ����¹�����Ա����Ϣ
 * @category deleteWorker(Admin worker) ɾ��Ա������Ϣ
 * @category querySingleWorker(String account,String password) 
 * 									���˺������ѯ������Ա��Ϣ
 */
public class WorkerDaoImpl {

	private JdbcUtils jdbcUtils = new JdbcUtils();

	/**
	 * ��ѯ���оƵ깤����Ա����Ϣ
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
			System.out.println("��ѯ������Ա����ʧ��");
			e.printStackTrace();
		}finally{
			jdbcUtils.close();
		}
		return workers;
	}

	/**
	 * ��������Ա�˺Ų��ҹ�����Ա��Ϣ
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
			System.out.println("��ѯ������Ա����ʧ��");
			e.printStackTrace();
		} finally {
			jdbcUtils.close();
		}

		return worker;
	}
	
	/**
	 * ��������Ա�˺ź���������ѯ��Ϣ 
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
	 * �޸ľƵ깤����Ա����Ϣ
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
	 * ����µĹ�����Ա����Ϣ
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
	 * ɾ������Ա��Ϣ
	 * 
	 * @param admin
	 */
	public void deleteWorker(Admin worker) {
		String sql = "delete from workers where id =" + worker.getId();
		jdbcUtils.delete(sql);
		jdbcUtils.close();
	}

}
