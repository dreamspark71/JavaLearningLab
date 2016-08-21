package JPAHibernateORMCodeTableMapping;

import java.util.List;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class BikeTypeEntityDao implements BikeTypeEntityDaoInterface {

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



	public boolean isEntityAttached( BikeTypeEntity bike ) {
		return entityManager.contains(bike);
	}

	public BikeTypeEntity attachEntity( BikeTypeEntity bike ) {
		return entityManager.merge( bike );
	}




	// Create an entity
	public int persist( BikeTypeEntity bike ) {

		entityManager.persist( bike );
		return bike.getId();
	}



	// Retrieve the created entities
	// http://stackoverflow.com/questions/15913150/what-is-the-proper-way-to-cast-hibernate-query-list-to-listtype
	@SuppressWarnings("unchecked")
	public List<BikeTypeEntity> findAll() {

		List<BikeTypeEntity> bikes = entityManager.createQuery( "FROM JPAHibernateORMCodeTableMapping.BikeTypeEntity" ).getResultList();
		return bikes;
	}


	public BikeTypeEntity findById(int id) {

		BikeTypeEntity bike = ( BikeTypeEntity ) entityManager.find( BikeTypeEntity.class, id );
		return bike;
	}


	// Update a specified entity
	public void update( BikeTypeEntity bike ) {

		entityManager.merge( bike );
	}


	// Delete a specified entity
	public void delete( BikeTypeEntity bike ) {

		entityManager.remove( bike );
	}


	public int getLatestBikeId() {

		// Native SQL Version
		//Query query = entityManager.createNativeQuery( "SELECT MAX(id) FROM bike" );  // THIS WORKS ALSO!

		// HQL Version
		Query query = entityManager.createQuery( "SELECT MAX(id) FROM BikeTypeEntity" );
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
		List<BikeTypeEntity> bikesToDelete = findAll();
		for ( BikeTypeEntity bikeToDelete : bikesToDelete ) {
			delete( bikeToDelete );
		}
	}



}