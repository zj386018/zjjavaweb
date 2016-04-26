package com.baiyi.hotelsystem.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC 操作的工具类
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
			System.out.println("未找到数据库驱动包，注册驱动失败");
			throw new ExceptionInInitializerError(e);
		}
	}
	

	private Connection connection = null;
	private Statement st = null;
	private ResultSet rs = null;

	private void connect() {
		// 建立连接
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("建立数据库连接失败");
		}
		// 创建语句
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("创建数据库语句失败");
			System.out.println(e);
		}
	}

	/**
	 * 数据库查询数据
	 * 
	 * @param sql
	 *            查询语句
	 * @return 返回查询的数据
	 */
	public ResultSet query(String sql) {
		connect();
		try {
			rs = st.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println("查询失败");
			System.out.println(e);
		}
		return rs;
	}

	/**
	 * 数据库插入数据
	 * 
	 * @param sql
	 *            插入语句
	 */
	public void insert(String sql) {
		connect();
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("插入数据失败");
			System.out.println(e);
		}
	}

	/**
	 * 修改数据库中的数据
	 * 
	 * @param sql
	 *            修改语句
	 */
	public void update(String sql) {
		connect();
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("修改数据失败");
			System.out.println(e);
		}
	}

	/**
	 * 删除数据库中的数据
	 * 
	 * @param sql
	 *            删除语句
	 */
	public void delete(String sql) {
		connect();
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("删除数据失败");
			System.out.println(e);
		}
	}

	/**
	 * 释放数据库资源
	 */
	public void close() {
		// 释放资源
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