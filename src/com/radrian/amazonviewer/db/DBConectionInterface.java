package com.radrian.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.radrian.amazonviewer.db.DataBase.*;

public interface DBConectionInterface {
	default Connection connectToDB() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = URL + DB;
			System.out.println(url + " " + USER + " " + PASSWORD);
			connection = DriverManager.getConnection(url, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return connection;
		}

	}
}
