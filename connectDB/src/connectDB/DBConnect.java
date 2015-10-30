package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {
	
	private final String className = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/student";
	private final String user = "root";
	private final String pass = "q135773751";
	
	
	public Connection connect() throws ClassNotFoundException {
	 Connection connection = null;
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (connection != null) {
			return connection;
		} else {
			return null;
		}
		
	}
	
	public void getData (Connection connection) {
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM STUDENT";
			
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.print(resultSet.getInt("id") + " " 
								+ resultSet.getString("fullname") + " " 
								+ resultSet.getInt("age"));
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}
	
	public static void main(String[] args) {
		DBConnect dbconnect = new DBConnect();
		Connection connection = null;
		try {
			connection = dbconnect.connect();
			dbconnect.getData(connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
			
}
