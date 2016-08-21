package MySQLConnectionCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

/**
 * The only difference with this version is that is stores the
 * database retrieved values to an ArrayList (via an object which matches
 * the database table columns) and then can print then out after the 
 * while() retrieval loop.
 */
public class MySqlJavaConnectionPreparedStatement2 {


	public static final String DB_URL = "jdbc:mysql://localhost/java_classroom";

	public static final String USER = "****";
	public static final String PASS = "****";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt  = null;
		ResultSet res   = null;
		PreparedStatement pst = null;

		try {

			// Open a connection
			System.out.println( "Connecting to the database..." );
			conn = DriverManager.getConnection( DB_URL, USER, PASS );

			// Execute a query
			System.out.println( "Creating statement..." );
			stmt = conn.createStatement();

			String updateQuery = "UPDATE bike SET name = ? WHERE id = ?";

			pst = conn.prepareStatement( updateQuery );

			pst.setString( 1, "updateTest" );
			pst.setInt( 2, 3 );

			pst.executeUpdate();

			String sqlQuery = "SELECT id, name, price FROM bike";
			res = stmt.executeQuery( sqlQuery );

			List<Bike> bikes = new ArrayList<>();

			// Extract the data from the result set
			while ( res.next() ) {

				// Retrieve by column name and add to the Bike object
				Bike bike = new Bike();
				bike.setId( res.getInt( "id" ) );
				bike.setName( res.getString( "name" ) );
				bike.setPrice( res.getFloat( "price" ) );

				// Add the bike object to the ArrayList
				bikes.add( bike );
			}

			// Clean up the environment
			res.close();
			stmt.close();
			conn.close();

			// Print out the values stored in the ArrayList
			for ( Bike b : bikes ) {
				System.out.println( "ID: " 
					+ b.getId() 
					+ ", Name: " 
					+ b.getName() 
					+ ", Price: " 
					+ b.getPrice() );
			}



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

class Bike {

	private int id;
	private String name;
	private float price;

	public void setId( int id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setPrice( float price ) {
		this.price = price;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public float getPrice() {
		return this.price;
	}
}











