package JPAHibernateORMCodeTableMapping;

import java.util.List;


public class BikeManager implements BikeManagerInterface {


	private static BikeEntityDao bikeEntityDao;
	private static BikeTypeEntityDao bikeTypeEntityDao;

	public BikeManager() {
		bikeEntityDao = new BikeEntityDao();
		bikeTypeEntityDao = new BikeTypeEntityDao();
	}
	
	public void cleanUpConnections() {
		bikeEntityDao.shutDown();
	}



	public int getLatestBikeId() {

		int id = 0;
		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			id = bikeEntityDao.getLatestBikeId();
			bikeEntityDao.commitTransaction();

		} catch ( NullPointerException npe ) {

			bikeEntityDao.getCurrentTransaction().rollback();
   			npe.printStackTrace();

		}  catch ( Exception e ) {

			bikeEntityDao.getCurrentTransaction().rollback();
   			e.printStackTrace();

		} finally {

			bikeEntityDao.closeSession();
		}

		return id;
	}




	public void createBike( BikeEntity bike ) {

		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			bikeEntityDao.persist( bike );
			bikeEntityDao.commitTransaction();		

		} catch( Exception ex ) {

   			if ( bikeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeEntityDao.closeSession();
		}
	
	}




	public List<BikeEntity> retrieveBikes() {

		List<BikeEntity> bikes = null;
		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			bikes = bikeEntityDao.findAll();
			bikeEntityDao.commitTransaction();

		} catch ( Exception ex ) {

   			if ( bikeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeEntityDao.closeSession();
		}

		return bikes;
	}




	public BikeEntity retrieveBikeById(int id) {

		BikeEntity bike = null;

		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			bike = bikeEntityDao.findById( id );
			bikeEntityDao.commitTransaction();

		} catch ( Exception ex ) {

   			if ( bikeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeEntityDao.closeSession();
		}

		return bike;
	}

	public void deleteBikeById( int id ) {

		BikeEntity bike = null;

		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			bike = bikeEntityDao.findById( id );
			bikeEntityDao.delete( bike );

			bikeEntityDao.commitTransaction();

		} catch ( Exception ex ) {

   			if ( bikeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeEntityDao.closeSession();
		}

	}


	public void deleteBike( BikeEntity bike  ) {

		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			// Checking if the entity is currently attached, this is relevant to check manually when using JPA
			bikeEntityDao.delete( bikeEntityDao.isEntityAttached( bike ) ? bike : bikeEntityDao.attachEntity ( bike ) );
			bikeEntityDao.commitTransaction();

		} catch ( Exception ex ) {

   			if ( bikeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeEntityDao.closeSession();
		}

	}


	public void updateBike( BikeEntity bike ) {
		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			bikeEntityDao.update( bike );
			bikeEntityDao.commitTransaction();

		} catch ( Exception ex ) {

   			if ( bikeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeEntityDao.closeSession();
		}
	}


	public void deleteAllBikes() {
		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

			bikeEntityDao.deleteAll();
			bikeEntityDao.commitTransaction();	

		} catch( Exception ex ) {

   			if ( bikeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeEntityDao.closeSession();
		}
	}


	// BikeTypeEntity Specific...

	public BikeTypeEntity retrieveBikeTypeById(int id) {
		BikeTypeEntity bikeType = null;

		try {

			bikeTypeEntityDao.startSession();
			bikeTypeEntityDao.startTransaction();

			bikeType = bikeTypeEntityDao.findById( id );
			bikeTypeEntityDao.commitTransaction();

		} catch ( Exception ex ) {

   			if ( bikeTypeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeTypeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeTypeEntityDao.closeSession();
		}

		return bikeType;
	}

	public void updateBikeType(BikeTypeEntity bikeType) {
		try {

			bikeTypeEntityDao.startSession();
			bikeTypeEntityDao.startTransaction();

			bikeTypeEntityDao.update( bikeType );
			bikeTypeEntityDao.commitTransaction();

		} catch ( Exception ex ) {

   			if ( bikeTypeEntityDao.getCurrentTransaction() != null ) {

	   			// Rollback   				
   				bikeTypeEntityDao.getCurrentTransaction().rollback();
   				ex.printStackTrace();

   			}
		} finally {

			bikeTypeEntityDao.closeSession();
		}
	}




}
