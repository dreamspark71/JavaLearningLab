package JPAHibernateORMCode;

import java.util.List;

/**
 * Entry point for the Bike App.
 * This is just a demo of Hibernate ORM CRUD operations.
 */
public class BikeApp {


	public static void main(String[] args) {


		// Call the Bike Manager and give it some bikes from here...

		// Create a bike
		BikeManager bm = new BikeManager();
		
		BikeEntity bike = new BikeEntity();
		bike.setName( "Trek" );
		bike.setPrice( (float)1200.00 );
		bike.setDescription( "Road racing bike" );

		bm.createBike( bike );


		// Retrieve all the bikes on the system
		List<BikeEntity> bikes = bm.retrieveBikes();


		// Print out the names and decriptions of each of the bikes retrieved
		for ( BikeEntity b : bikes ) {
		    System.out.println( "BikeEntity (" + b.getName() + ") : " + b.getDescription() );
		}
		

		//int bikeId = bike.getId();

		// Get the bike entity and then update it's price
		// Even though we already have the object available to use here, for the sake of completness we will explicity
		// go retrieve it from the database and then update...

		// Update a bike
		/*
		int bikeId = 28; // NOTE: This is just a hardcoded variable for demo purposes
		BikeEntity bikeToUpdate = bm.retrieveBikeById( bikeId );	// Retrieving a specific bike

		bikeToUpdate.setPrice( (float) 999.99 );
		bm.updateBike( bikeToUpdate );
		*/

		/*
		int latestBikeId = bm.getLatestBikeId();
		if ( latestBikeId == 0 ) {
			System.out.println( "There are currently no bikes in the database" );
		} else {
			System.out.println( "The latest Bike Id is: " + latestBikeId );
		}


		// Delete a bike
		BikeEntity bikeToDelete = bm.retrieveBikeById( latestBikeId );
		bm.deleteBike( bikeToDelete );
		*/


		// Deleting all bikes	
		//bm.deleteAllBikes();




		bm.cleanUpConnections();	// Closing the Hibernate Session Factory

	}


}