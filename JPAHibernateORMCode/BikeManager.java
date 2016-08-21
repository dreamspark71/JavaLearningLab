package JPAHibernateORMCode;

import java.util.List;


public class BikeManager implements BikeManagerInterface {


	private static BikeEntityDao bikeEntityDao;

	public BikeManager() {
		bikeEntityDao = new BikeEntityDao();
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
/* ORIGINAL DELETE BEFORE THE CONTAINS() AND MERGE() CODE ADDITIONS TO WORK FOR BOTH NATIVE HIBERNATE AND JPA
public void deleteBike( BikeEntity bike  ) {
		try {

			bikeEntityDao.startSession();
			bikeEntityDao.startTransaction();

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
*/



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


}
