package com.radrian.amazonviewer.db;

public class DataBase {
	
//	connectionString = "jdbc:mysql://{server-name}:3306/%s?useUnicode=yes&characterEncoding=UTF-8&useSSL=false"
	
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DB = "amazonviewer";
	public static final String ALLOW_PUBLIC_KEY = "?allowPublicKeyRetrieval=true";
	public static final String USE_SSL_FALSE = "&useSSL=false";
	public static final String USER = "amazonviewer";
	public static final String PASSWORD = "amazonviewer";

	public static final String MOVIE_TABLE = "movie";
	public static final String MOVIE_TABLE_ID = "id";
	public static final String MOVIE_TABLE_TITLE = "title";
	public static final String MOVIE_TABLE_GENRE = "genre";
	public static final String MOVIE_TABLE_CREATOR = "creator";
	public static final String MOVIE_TABLE_DURATION = "duration";
	public static final String MOVIE_TABLE_YEAR = "year";
	
	public static final String MATERIAL_TABLE 	= "material";
	public static final int[] MATERIAL_TABLE_ID 	= {1,2,3,4,5};
	
	public static final String USER_TABLE = "user";
	public static final int USER_TABLE_USERID = 1;
	
	public static final String VIEWED_TABLE = "viewed";
	public static final String VIEWED_TABLE_IDMATERIAL 	= "id_material";
	public static final String VIEWED_TABLE_IDELEMENT 	= "id_element";
	public static final String VIEWED_TABLE_USER_ID = "id_user";
	
//	public static final String _TABLE = "movie";
//	public static final String MOVIE_TABLE_ID = "id";
//	public static final String MOVIE_TABLE_TITLE = "title";
//	public static final String MOVIE_TABLE_GENRE = "genre";
//	public static final String MOVIE_TABLE_CREATOR = "creator";
//	public static final String MOVIE_TABLE_DURATION = "duration";
//	public static final String MOVIE_TABLE_YEAR = "year";

	
}
