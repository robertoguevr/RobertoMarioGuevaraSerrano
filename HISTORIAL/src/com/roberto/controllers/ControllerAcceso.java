package com.roberto.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roberto.entidades.Loguin;
import com.roberto.negocio.clsLoguin;

/**
 * Servlet implementation class ControllerAcceso
 */
@WebServlet("/ControllerAcceso")
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAcceso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String user= request.getParameter("user");
		String pass = request.getParameter("pass");
		
		Loguin log = new Loguin();
		clsLoguin clsL = new clsLoguin();
		
		log.setUser(user);
		log.setPass(pass);
		
		int valordeacceso = clsL.acceso(log);
		
		if(valordeacceso==1) 
		{
			System.out.println("WeLCOME");
			response.sendRedirect("Saludo.jsp");
		}else {
			
			System.out.println("ERROR");
			response.sendRedirect("Error.jsp");
		}
	}

}
