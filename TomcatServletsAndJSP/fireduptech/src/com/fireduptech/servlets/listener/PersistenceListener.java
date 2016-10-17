package com.fireduptech.servlets.listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class PersistenceListener implements ServletContextListener {

	private EntityManagerFactory entityManagerFactory;

	public void contextInitialized( ServletContextEvent sce ) {

		ServletContext context = sce.getServletContext();
		entityManagerFactory = Persistence.createEntityManagerFactory( "com.fireduptech.servlet.jpa" ); 
		// LINE ABOVE: --> THIS IS THE PROBLEM LINE - IT CAUSES THE LISTENER TO FAIL..
		
		context.setAttribute( "emf", entityManagerFactory );

	}

	public void contextDestroyed( ServletContextEvent sce ) {

		entityManagerFactory = (EntityManagerFactory)sce.getServletContext().getAttribute( "emf" );
		entityManagerFactory.close();
	}


}
