package com.baiyi.hotelsystem.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC �����Ĺ�����
 * 
 */
public class JdbcUtils {
	
	private static String url = "jdbc:mysql://localhost:3306/hoteljava";
	private static String user = "root";
	private static String password = "";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("δ�ҵ����ݿ���������ע������ʧ��");
			throw new ExceptionInInitializerError(e);
		}
	}
	

	private Connection connection = null;
	private Statement st = null;
	private ResultSet rs = null;

	private void connect() {
		// ��������
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("�������ݿ�����ʧ��");
		}
		// �������
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("�������ݿ����ʧ��");
			System.out.println(e);
		}
	}

	/**
	 * ���ݿ��ѯ����
	 * 
	 * @param sql
	 *            ��ѯ���
	 * @return ���ز�ѯ������
	 */
	public ResultSet query(String sql) {
		connect();
		try {
			rs = st.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println("��ѯʧ��");
			System.out.println(e);
		}
		return rs;
	}

	/**
	 * ���ݿ��������
	 * 
	 * @param sql
	 *            �������
	 */
	public void insert(String sql) {
		connect();
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
			System.out.println(e);
		}
	}

	/**
	 * �޸����ݿ��е�����
	 * 
	 * @param sql
	 *            �޸����
	 */
	public void update(String sql) {
		connect();
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("�޸�����ʧ��");
			System.out.println(e);
		}
	}

	/**
	 * ɾ�����ݿ��е�����
	 * 
	 * @param sql
	 *            ɾ�����
	 */
	public void delete(String sql) {
		connect();
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("ɾ������ʧ��");
			System.out.println(e);
		}
	}

	/**
	 * �ͷ����ݿ���Դ
	 */
	public void close() {
		// �ͷ���Դ
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
				try {
					if (st != null) {
					st.close();
					}
				} catch (SQLException e) {
					System.out.println(e);
				}finally{
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
		}
	}

}