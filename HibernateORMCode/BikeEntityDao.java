package HibernateORMCode;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Arrays;





public class BikeEntityDao implements BikeEntityDaoInterface {

	private Session session;
	private Transaction transaction;


	public void startSession() {
		session = HibernateBikeExampleUtil.getSessionFactory().openSession();
	}

	public void startTransaction() {
		transaction = session.beginTransaction();
	}


	public void commitTransaction() {
		session.getTransaction().commit();
	}

	public void closeSession() {
		session.close();
	}


	public void shutDown() {
		HibernateBikeExampleUtil.shutDown();
	}

	public Transaction getCurrentTransaction() {
		return transaction;
	}


	public boolean isEntityAttached( BikeEntity bike ) {
		return session.contains(bike);
	}

	public BikeEntity attachEntity( BikeEntity bike ) {
		return (BikeEntity)session.merge( bike );
	}



	// Create an entity
	public int persist( BikeEntity bike ) {

		session.save( bike );
		return bike.getId();
	}



	// Retrieve the created entities
	// http://stackoverflow.com/questions/15913150/what-is-the-proper-way-to-cast-hibernate-query-list-to-listtype
	@SuppressWarnings("unchecked")
	public List<BikeEntity> findAll() {

		List<BikeEntity> bikes = session.createQuery( "FROM BikeEntity" ).list();
		return bikes;
	}


	public BikeEntity findById(int id) {

		BikeEntity bike = ( BikeEntity ) session.get( BikeEntity.class, id );
		return bike;
	}


	// Update a specified entity
	public void update( BikeEntity bike ) {

		session.update( bike );

	}


	// Delete a specified entity
	public void delete( BikeEntity bike ) {

		session.delete( bike );
	}


	public int getLatestBikeId() {

		// Native SQL Version
		//Query query = session.createNativeQuery( "SELECT MAX(id) FROM bike" );
		
		// HQL Version
		Query query = session.createQuery( "SELECT MAX(id) FROM BikeEntity" );
		List list = query.list();

		// Check that a null value was not returned due to an empty database
		if ( list.get(0) != null ) {

			Integer id = (Integer) list.get(0);
			return id;

		} else {
			throw new NullPointerException("There are currently no bikes in the database");
			//return 0;
		}

	}


	public void deleteAll() {

		// Get all the bikes, then loop through each one and delete
		List<BikeEntity> bikesToDelete = findAll();
		for ( BikeEntity bikeToDelete : bikesToDelete ) {
			delete( bikeToDelete );
		}
	}


}