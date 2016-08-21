package JPAHibernateORMCodeTableMapping;

import java.util.List;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class BikeEntityDao implements BikeEntityDaoInterface {

	/*private Session session;
	private Transaction transaction;*/

	private EntityManager entityManager;
	private EntityTransaction transaction = null;

	public void startSession() {
		entityManager = JPAEntityManagerUtil.getEntityManager();
	}

	public void startTransaction() {
		transaction = entityManager.getTransaction();
		transaction.begin();
	}

	public void commitTransaction() {
		transaction.commit();
	}

	public void closeSession() {
		entityManager.close();
	}

	public EntityTransaction getCurrentTransaction() {
		return transaction;
	}

	public void shutDown() {
		JPAEntityManagerUtil.shutDown();
	}


	public EntityManager getCurrentSessionManager() {
		return entityManager;
	}



	public boolean isEntityAttached( BikeEntity bike ) {
		return entityManager.contains(bike);
	}

	public BikeEntity attachEntity( BikeEntity bike ) {
		return entityManager.merge( bike );
	}




	// Create an entity
	public int persist( BikeEntity bike ) {

		entityManager.persist( bike );
		return bike.getId();
	}



	// Retrieve the created entities
	// http://stackoverflow.com/questions/15913150/what-is-the-proper-way-to-cast-hibernate-query-list-to-listtype
	@SuppressWarnings("unchecked")
	public List<BikeEntity> findAll() {

		List<BikeEntity> bikes = entityManager.createQuery( "FROM JPAHibernateORMCodeTableMapping.BikeEntity" ).getResultList();
		return bikes;
	}


	public BikeEntity findById(int id) {

		BikeEntity bike = ( BikeEntity ) entityManager.find( BikeEntity.class, id );
		return bike;
	}


	// Update a specified entity
	public void update( BikeEntity bike ) {

		entityManager.merge( bike );
	}


	// Delete a specified entity
	public void delete( BikeEntity bike ) {

		entityManager.remove( bike );
	}


	public int getLatestBikeId() {

		// Native SQL Version
		//Query query = entityManager.createNativeQuery( "SELECT MAX(id) FROM bike" );  // THIS WORKS ALSO!

		// HQL Version
		Query query = entityManager.createQuery( "SELECT MAX(id) FROM BikeEntity" );
		List list = query.getResultList();

		// Check that a null value was not returned due to an empty database
		if ( list.get(0) != null ) {

			Integer id = (Integer) list.get(0);
			return id;

		} else {
			throw new NullPointerException("There are currently no bikes in the database");
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