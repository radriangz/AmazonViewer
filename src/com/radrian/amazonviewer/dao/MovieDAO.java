package com.radrian.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.radrian.amazonviewer.db.DataBase.*;

import com.radrian.amazonviewer.model.Movie;
import com.radrian.amazonviewer.db.DBConectionInterface;

public interface MovieDAO extends DBConectionInterface{
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try (Connection connection = connectToDB()){
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
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
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
