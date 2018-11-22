package com.radrian.amazonviewer.db;

public class DataBase {
	public static final String URL = "jdbc:mysql://localhost:3307";
	public static final String DB = "amazonviewer";
	public static final String USER = "amazonviewer";
	public static final String PASSWORD = "AmazonViewer";

	public static final String MOVIE_TABLE = "movie";
	public static final String MOVIE_TABLE_ID = "id";
	public static final String MOVIE_TABLE_TITLE = "title";
	public static final String MOVIE_TABLE_GENRE = "genre";
	public static final String MOVIE_TABLE_CREATOR = "creator";
	public static final String MOVIE_TABLE_DURATION = "duration";
	public static final String MOVIE_TABLE_YEAR = "year";
	
	public static final String MATERIAL_TABLE 	= "material";
	public static final int[] MATERIAL_TABLE_ID 	= {1,2,3,4,5};
	
	public static final String TUSER 			= "user";
	public static final int TUSER_IDUSUARIO 		= 1;
	
	public static final String TVIEWED 				= "viewed";
	public static final String TVIEWED_IDMATERIAL 	= "id_material";
	public static final String TVIEWED_IDELEMENT 	= "id_element";
	public static final String TVIEWED_IDUSUARIO 	= "id_user";
	
	public static final String _TABLE = "movie";
	public static final String MOVIE_TABLE_ID = "id";
	public static final String MOVIE_TABLE_TITLE = "title";
	public static final String MOVIE_TABLE_GENRE = "genre";
	public static final String MOVIE_TABLE_CREATOR = "creator";
	public static final String MOVIE_TABLE_DURATION = "duration";
	public static final String MOVIE_TABLE_YEAR = "year";

	
}
