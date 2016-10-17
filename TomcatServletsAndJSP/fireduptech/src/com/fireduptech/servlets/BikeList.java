package com.fireduptech.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;


/**
 * This servlet shows how to access a JNDI DataSource, which here 
 * is a JDBC connection.
 * @author www.fireduptech.com
 */
@WebServlet(name = "BikeListServlet", urlPatterns = "/listBikesServlet")
public class BikeList extends HttpServlet {

    public void init() throws ServletException {
        // servlet initialisation code
        super.init();
    }

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        PrintWriter writer = response.getWriter();

        try {

            Context initContext = new InitialContext();
            // "comp" is short for component"  http://stackoverflow.com/questions/11631839/what-is-javacomp-env
            // http://stackoverflow.com/questions/4099095/what-does-javacomp-env-do
            Context envContext = (Context) initContext.lookup( "java:comp/env" );
            DataSource ds = (DataSource) envContext.lookup( "jdbc/JavaTomcatClassroomDB" );
            Connection conn = ds.getConnection();

            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT name, price FROM bike";
            ResultSet resultSet = statement.executeQuery( sqlQuery );

            int count = 1;
            while ( resultSet.next() ) {
                writer.println( 
                    String.format( "BikeName #%d: %-15s %s", count++, 
                        resultSet.getString("name"), resultSet.getFloat("price") )
                     );
            }

        } catch ( NamingException ex ) {
            System.err.println( ex );
        } catch ( SQLException ex ) {
            System.err.println( ex );
        }


    }

    public void destroy() {
        // releasing resources
        super.destroy();
    }

}

