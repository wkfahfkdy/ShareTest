package com.shop.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;
import java.sql.DatabaseMetaData;

public class DAO {

//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	//private String url = "jdbc:oracle:thin:@adb.ap-seoul-1.oraclecloud.com:1522:sovgh7r6aeulzdz_shop_medium.adb.oraclecloud.com";
//	private String user = "shop";
//	private String passwd = "shop";

	final static String DB_URL = "jdbc:oracle:thin:@shop_medium?TNS_ADMIN=/Users/admin/test/Wallet_shop/";
	// For ATP and ADW - use the TNS Alias name along with the TNS_ADMIN when using
	// 18.3 JDBC driver
	// final static String
	// DB_URL="jdbc:oracle:thin:@wallet_dbname?TNS_ADMIN=/Users/test/wallet_dbname";
	// In case of windows, use the following URL
	// final static String
	// DB_URL="jdbc:oracle:thin:@wallet_dbname?TNS_ADMIN=C:\\Users\\test\\wallet_dbname";
	final static String DB_USER = "admin";
	final static String DB_PASSWORD = "Shop210601??";

	public OracleConnection conn;

	public DAO() {
		Properties info = new Properties();
		info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
		info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
		info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

		OracleDataSource ods;
		try {
			ods = new OracleDataSource();
			ods.setURL(DB_URL);
			ods.setConnectionProperties(info);
			conn = (OracleConnection) ods.getConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, passwd);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
	}
}
