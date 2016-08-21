package MySQLConnectionCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class MySqlJavaConnectionBasicRetrieval {

	public static final String DB_URL = "jdbc:mysql://localhost/java_classroom";
	public static final String USER = "****";
	public static final String PASS = "****";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt  = null;
		ResultSet res   = null;

		try {

			// Open a connection
			System.out.println( "Connecting to the database..." );
			conn = DriverManager.getConnection( DB_URL, USER, PASS );

			// Execute a query
			System.out.println( "Creating statement..." );
			stmt = conn.createStatement();

			String sqlQuery = "SELECT id, name, price FROM bike";
			res = stmt.executeQuery( sqlQuery );

			// Extract the data from the result set
			while ( res.next() ) {

				// Retrieve by column name
				int id = res.getInt( "id" );
				String name = res.getString( "name" );
				float price = res.getFloat( "price" );

				// Displaying the values
				System.out.print( "ID: " + id );
				System.out.print( ", Name: " + name );
				System.out.println( ", Price: " + price );
			}

			// Clean up the environment
			res.close();
			stmt.close();
			conn.close();


		} catch ( SQLException ex ) {
			// Handle errors for JDBC
			ex.printStackTrace();

		} finally {
			// finally block to close resources
			try {

				if ( stmt != null ) {
					stmt.close();
				}

				if ( conn != null ) {
					conn.close();
				}

			} catch ( SQLException ex2 ) {
				ex2.printStackTrace();
				// ex2.getMessage();
			}

		}


	}
}