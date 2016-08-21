package HibernateORMCode;

import org.hibernate.Session;
import org.hibernate.query.Query;

//import org.hibernate.Query; // THIS IS DEPRECATED ALSO...

import java.util.List;
import java.util.ArrayList;


public class HibernateCrudBikeExample {

	public static Session session;

	public static void main( String[] args ) {

		// Showing full CRUD cycle

		// Add a new Bike object
		BikeEntity bike = new BikeEntity();
		int newBikeId = create( bike );


		// Retrieve all bike entities
		List<BikeEntity> bikes = retrieve();

		// Print out the names and decriptions of each of the bikes retrieved
		for ( BikeEntity b : bikes ) {
		    System.out.println( "BikeEntity (" + b.getName() + ") : " + b.getDescription() );
		}

		HibernateBikeExampleUtil.shutDown();  // Final closing of the SessionFactory...
	}

	// Create an entity
	public static int create( BikeEntity bike ) {

		session = HibernateBikeExampleUtil.getSessionFactory().openSession();
		session.beginTransaction();

		bike.setName( "Trek" );
		bike.setPrice( (float)1200.00 );
		bike.setDescription( "Road racing bike" );

		session.save( bike );
		session.getTransaction().commit();
		session.close();

		return bike.getId();
	}

	// Retrieve the created entities
	@SuppressWarnings("unchecked")  // http://stackoverflow.com/questions/15913150/what-is-the-proper-way-to-cast-hibernate-query-list-to-listtype
	public static List<BikeEntity> retrieve() {

		session = HibernateBikeExampleUtil.getSessionFactory().openSession();
		session.beginTransaction();

		List<BikeEntity> bikes = session.createQuery( "FROM BikeEntity" ).list();		

		session.getTransaction().commit();
		session.close();

		return bikes;
	}

	// Update a specified entity
	public static void update( BikeEntity bike ) {

	}
	// Delete a specified entity
	public static void delete( int i ) {

	}

}




