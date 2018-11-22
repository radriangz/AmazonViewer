package com.radrian.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.radrian.amazonviewer.db.DataBase.*;

public interface DBConectionInterface {
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return connection;
		}
		
	}
}
