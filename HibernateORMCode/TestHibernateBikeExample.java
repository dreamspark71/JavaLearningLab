package HibernateORMCode;

import org.hibernate.Session;

public class TestHibernateBikeExample {

	public static void main(String[] args) {

		Session session = HibernateBikeExampleUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add a new Bike object
		BikeEntity bike = new BikeEntity();
		bike.setName( "Trek" );
		bike.setPrice( (float)1200.00 );
		bike.setDescription( "Road racing bike" );

		session.save( bike );

		session.getTransaction().commit();

		HibernateBikeExampleUtil.shutDown();
	}
}
