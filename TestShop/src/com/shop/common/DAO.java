package com.shop.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//private String url = "jdbc:oracle:thin:@adb.ap-seoul-1.oraclecloud.com:1522:sovgh7r6aeulzdz_shop_medium.adb.oraclecloud.com";
	private String user = "shop";
	private String passwd = "shop";
	public Connection conn;
	
	public DAO() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
