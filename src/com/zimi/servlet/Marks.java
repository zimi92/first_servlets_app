package com.zimi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Marks
 */
@WebServlet("/Marks")
public class Marks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Marks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public String sql_hand(String id) throws ClassNotFoundException{
		String JDBC_DRIVER = "com.mysql.Driver";
		String DB_URL="jdbc:mysql://localhost:3306/portf1";
		String USER = "root";
		String PASS = "admin";
		Connection conn = null;
		Statement stmt = null;
		int Historia=0;
		int Matematyka=0;
		int Fizyka=0;
		try{
			// Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
           
            String sql = "SELECT * FROM user Where id ="+id;
    		ResultSet rs = stmt.executeQuery(sql);
    		rs.next();
    		Matematyka = rs.getInt("Matematyka");
    		Historia = rs.getInt("Historia");
    		Fizyka = rs.getInt("Fizyka");
		}catch(SQLException e){
			System.out.print(e);
		}
		
		
		
		return ("<tr><td>"+Historia+"</td><td>"+Matematyka+"</td><td>"+Fizyka+"</td></tr>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> z = request.getParameterNames();
		String[] k = request.getParameterValues(z.nextElement());
		
		
		PrintWriter out = response.getWriter();
		String temp1="";
		//if(k.hasMoreElements())
			try {
				temp1 = sql_hand(k[0]);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		out.println("<table><tr><td>Historia</td><td>Matematyka</td><td>Fizyka</td></tr>");
		out.println(temp1);
		out.println("</table>");
	}

}
