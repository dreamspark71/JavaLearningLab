package JPAHibernateORMCodeTableMapping;

import java.io.File;

/*
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityManagerUtil {

	private static final EntityManagerFactory entityManagerFactory;
	static {
		try {

			entityManagerFactory = Persistence.createEntityManagerFactory( "com.fireduptech.demo.jpa.tablemapping" );

		} catch ( Throwable e ) {
			throw new ExceptionInInitializerError( e );
		}
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public static void shutDown() {
		entityManagerFactory.close();
	}

/*	private static final SessionFactory sessionFactory = buildSessionFactory();


	private static SessionFactory buildSessionFactory() {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
						.configure( new File("source/HibernateORMCode/hibernate.cfg.xml") )
						.build();

		try {

			return new MetadataSources( registry ).buildMetadata().buildSessionFactory();

		} catch ( Exception e ) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			throw new ExceptionInInitializerError( e );
		}

	}


	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutDown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
	------------------------------------------------------------------------------------------------------------------------
*/

}

 
  

