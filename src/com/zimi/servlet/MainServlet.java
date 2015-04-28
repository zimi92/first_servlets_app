package com.zimi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = request.getParameter("id");
		String target2 = request.getParameter("name");
		RequestDispatcher requestDispatcher = null;
		if(target == null && target2 == null){
			requestDispatcher = request.getRequestDispatcher("/mainsite.jsp");
		}else{
			requestDispatcher = request.getRequestDispatcher("/SQLservlet");
		}
		
		requestDispatcher.forward(request, response);
	}

}
