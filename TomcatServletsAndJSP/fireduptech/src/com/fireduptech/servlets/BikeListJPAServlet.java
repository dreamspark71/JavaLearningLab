package com.fireduptech.servlets;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.fireduptech.servlets.hibernate.model.BikeTypeEntity;
import com.fireduptech.servlets.hibernate.model.BikeEntity;


@WebServlet( name = "BikeListJPAServlet", urlPatterns = "/listBikesJPAServlet" )
public class BikeListJPAServlet extends HttpServlet {

	private EntityTransaction transaction = null;


	public void init() throws ServletException {
		// servlet initialisation code
		super.init();
	}


	@SuppressWarnings("unchecked")
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		// Obtain a database connection
		EntityManagerFactory emf = (EntityManagerFactory)request.getServletContext().getAttribute( "emf" );
		EntityManager em = emf.createEntityManager();

		try {

			List<BikeEntity> bikes = null;

			transaction = em.getTransaction();
			transaction.begin();

			bikes = em.createQuery( "FROM com.fireduptech.servlets.hibernate.model.BikeEntity" ).getResultList();

			transaction.commit();

			// Print out the names and decriptions of each of the bikes retrieved
			for ( BikeEntity b : bikes ) {
			    writer.println( "BikeEntity (" + b.getName() + ") : " + b.getDescription() );
			}



		} catch ( Exception ex ) {

			transaction.rollback();
			ex.printStackTrace();			
		
		} finally {
			em.close();
		}


	}

}
