package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
      throws ServletException, IOException
    {
    	// Connect to the database and get content
    	ArrayList<String> dogNames = new ArrayList<String>() ;
    	ArrayList<String> dogImages = new ArrayList<String>() ;
        String error = "" ;
        
    	try {
            Class.forName("org.postgresql.Driver");
    		//org.postgresql.Driver driver = new org.postgresql.Driver() ;
        }
        catch (java.lang.ClassNotFoundException e) {
            //System.out.println(e.getMessage());
        	error += e.getMessage() + "\n";
        }
        
        String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nbfpsiii";
        String username = "nbfpsiii";
        String password = "XbLsQhqyOSKLAvdHY74GyVwBBSDwhjhO";

        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dogs ORDER BY dogs");
            while (rs.next()) {
            	dogNames.add(rs.getString(1)) ;
            	dogImages.add(rs.getString(2)) ;
            }
            rs.close();
            st.close();
            db.close();
            request.setAttribute("dogNames", dogNames);
            request.setAttribute("dogImages", dogImages);
            }
        catch (java.sql.SQLException e) {
        	error += e.getMessage();
        }
    	
        if (error != "") {
            // Very simple - just return some plain text
        	response.setContentType("text/plain;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        	response.getWriter().println(error);
        } else {
        	this.getServletContext().getRequestDispatcher("/WEB-INF/dogs.jsp").forward(request, response);
        }
    }
}
