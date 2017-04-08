import java.sql.*;

public class MyJDBCProgram {
	Connection connection;
	InsertStar insertStar;
	MovieQuery movieQuery;
	
	/* Let's the user login to sql database */
	public void login(String username, String password)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection("jdbc:mysql:///moviedb?autoReconnect=true&useSSL=false",
				username, password);
		movieQuery = new MovieQuery(connection);
	}
	
	public void insertStar() throws SQLException{
		insertStar = new InsertStar(connection);
		insertStar.insertNewStar();
	}
		
	/* The function returns a set of movies based
	 * on the user's query */
	public void queryMovie(){
		try {
			movieQuery.searchMovie();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: queryMovie");
			e.printStackTrace();
		}
	}	
}
