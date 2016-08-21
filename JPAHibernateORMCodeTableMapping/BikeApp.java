package JPAHibernateORMCodeTableMapping;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Entry point for the Bike App.
 * This is just a demo of Hibernate ORM CRUD operations.
 */
public class BikeApp {


	public static void main(String[] args) {

 /*LAST TASK WITH THIS IS TO SET SOME NEW BIKE OBJECTS THROUGH ONE EXISTING BIKE TYPE OBJECT - SO WE SEE IT WORKING IN THE BI-DIRECTIONAL WAY FOR THE ONE-TO-MANY MAPPING...

THERE ARE CURRENTLY 2 ENTIES IN THE BIKE-TYPE TABLE, SO USE AN EXISTING ONE OF THOSE AND ATTACHED A FEW BIKES TO ITS OBJECT AND SAVE THAT 
	(NOTE: WILL NEED NEW PERSIS METHODS IN MY MANAGER AS CURRENTLY IT IS SPECIFIC FOR THE BIKE ENTITY TYPE - SEE IF CAN MAKE THAT MORE GENERIC IF NOT OVER THE TOP FOR THIS EXAMPLE)
*/




		BikeManager bm = new BikeManager();

		// 2nd Approach, creating new bikes and setting through an existing Bike Type entity.


		// Get the existing bike type
		BikeTypeEntity bikeTypeToUpdate = bm.retrieveBikeTypeById( 1 );

		// Create some bikes
		BikeEntity bike1 = new BikeEntity();
		bike1.setName( "Trek" );
		bike1.setPrice( (float)1200.00 );
		bike1.setDescription( "Trek racing bike" );

		bike1.setBikeType( bikeTypeToUpdate );


		BikeEntity bike2 = new BikeEntity();
		bike2.setName( "Colnago" );
		bike2.setPrice( (float)1500.00 );
		bike2.setDescription( "Colnago racing bike" );

		bike2.setBikeType( bikeTypeToUpdate );



		// Add new bikes to a Set
		Set<BikeEntity> bikes = new HashSet<BikeEntity>();
        bikes.add( bike1 );
        bikes.add( bike2 );


		// Attach Set of new bikes to the retrieved existing Bike Type
		bikeTypeToUpdate.setBikeEntities( bikes );


		// Update the Bike Type
		bm.updateBikeType( bikeTypeToUpdate );




		//  - 1st Approach. The owner is the Bike Entity: 
		//	   This block of code creates a Bike Type and a Bike and sets the Bike Type through the Bike entity.

		/*BikeTypeEntity bikeType = new BikeTypeEntity();
		bikeType.setBikeType("Road racer");


		BikeEntity bike = new BikeEntity();
		bike.setName( "Trek" );
		bike.setPrice( (float)1200.00 );
		bike.setDescription( "Trek racing bike" );

		bike.setBikeType( bikeType );

		bm.createBike( bike );
		*/

		


		// Call the Bike Manager and give it some bikes from here...

		// Create a bike
/*		BikeManager bm = new BikeManager();
		
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
*/		

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