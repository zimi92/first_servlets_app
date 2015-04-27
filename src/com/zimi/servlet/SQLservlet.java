package com.zimi.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//sql
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
/**
 * Servlet implementation class SQLservlet
 */
@WebServlet("/SQLservlet")
public class SQLservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SQLservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     String DB_URL="jdbc:mysql://localhost:3306/portf1";
	     
	     String USER = "root";
	     String PASS = "admin";
	     
	     String us_id = request.getParameter("id");
	     String us_name = request.getParameter("name");
	     response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Database Result";
	      String docType =
	        "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n");
	        Connection conn = null;
			Statement stmt = null;
			try{
	             // Register JDBC driver
	             Class.forName("com.mysql.jdbc.Driver");

	             // Open a connection
	             conn = DriverManager.getConnection(DB_URL,USER,PASS);

	             // Execute SQL query
	             stmt = conn.createStatement();
	             String sql="";
	             out.println("<table>");
	             

	             if(us_name != "")
	            	 sql = "SELECT * FROM user WHERE name = '"+us_name+"'";
	             else if(us_id != "")
	            	 sql = "SELECT * FROM user WHERE id ="+us_id;
		             
	            	 ResultSet rs = stmt.executeQuery(sql);

	             // Extract data from result set
	             out.println("<tr><td></td><td>id</td><td>name</td>	<td>sirname</td>	<td>age</td>	<td>start</td></tr>");
	             out.println("<form action=\"Marks\" method=\"POST\"");
	             while(rs.next()){
	                //Retrieve by column name
	            	int id = rs.getInt("id");
	                int age  = rs.getInt("age");
	                String name = rs.getString("name");
	                String sirname = rs.getString("sirname");
	                String start = rs.getString("start");
	                
	                //Display values
	                //out.println("<tr><td><input type=\"radio\" name=\""+Integer.toString(id)+"\" value=\""+Integer.toString(id)+"\"></td>");
	                out.println("<tr><td><input type=\"radio\" name=\"nazwa\" value=\""+Integer.toString(id)+"\"></td>");
	                out.println("<td>"+id+"</td><td>"+name + "</td>	<td>"+sirname+"</td>	<td>"+age+"</td>	<td>"+start+"</td></tr>");
	             }
	             out.println("</table>");
	             out.println("<input type =\"submit\" value=\"Submit\"");
	             out.println("</form>");
	             
	             out.println("<a href = \"http://localhost:8080/Servlet_ex_1/mainsite.jsp\">Powrot do wybierania</a>");
	             out.println("</body></html>");

	             // Clean-up environment
	             rs.close();
	             stmt.close();
	             conn.close();
	          }catch(SQLException se){
	             //Handle errors for JDBC
	        	  out.print(se);
	              se.printStackTrace();
	          }catch(Exception e){
	             //Handle errors for Class.forName
	        	  out.print(e);
	        	  e.printStackTrace();
	          }finally{
	             //finally block used to close resources
	             try{
	                if(stmt!=null)
	                   stmt.close();
	             }catch(SQLException se2){
	             }// nothing we can do
	             try{
	                if(conn!=null)
	                conn.close();
	             }catch(SQLException se){
	                se.printStackTrace();
	             }//end finally try
	          } //end try
	}

}
