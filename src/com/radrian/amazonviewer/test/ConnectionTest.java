package com.radrian.amazonviewer.test;

import static com.radrian.amazonviewer.db.DataBase.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.radrian.amazonviewer.model.Movie;

public class ConnectionTest {
	ArrayList<Movie> movies = new ArrayList<Movie>();
	Connection connection = null;
	
	public static void main(String[] args) {
		ConnectionTest test = new ConnectionTest();
		test.execute();
		test.printArrayToConsole();
	}
	
	private void printArrayToConsole() {
		for (Movie movie : movies) {
			movie.toString();
			System.out.println();
		}
	}
	
	private void execute() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = URL + DB;
			System.out.println(url + " " + USER + " " + PASSWORD);
			connection = DriverManager.getConnection(url, USER, PASSWORD);

			String query = "SELECT * FROM " + MOVIE_TABLE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie(
						rs.getString(MOVIE_TABLE_TITLE), 
						rs.getString(MOVIE_TABLE_GENRE), 
						rs.getString(MOVIE_TABLE_CREATOR), 
						Integer.valueOf(rs.getString(MOVIE_TABLE_DURATION)), 
						Short.valueOf(rs.getString(MOVIE_TABLE_YEAR)));
				
				movie.setId(Integer.valueOf(rs.getString(MOVIE_TABLE_ID)));
				movie.setViewed(getMovieViewed(
						preparedStatement, 
						connection, 
						Integer.valueOf(rs.getString(MOVIE_TABLE_ID))));
				movies.add(movie);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + VIEWED_TABLE +
						" WHERE " + VIEWED_TABLE_IDMATERIAL + "=" + MATERIAL_TABLE_ID[0] + 
						" AND " + VIEWED_TABLE_IDELEMENT + "= ?" +
						" AND " + VIEWED_TABLE_USER_ID + "= ?";
		ResultSet rs = null;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, MATERIAL_TABLE_ID[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, USER_TABLE_USERID);
			
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return viewed;
	}


}
