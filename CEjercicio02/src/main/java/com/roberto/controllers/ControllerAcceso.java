package com.roberto.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roberto.DAO.ClsUsuario;
import com.roberto.entidades.Loguin;
import com.roberto.entidades.usuario;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession(true);
		String btncerrar = request.getParameter("btncerrar");
		if (btncerrar != null) {
			response.sendRedirect("index.jsp");
			session.invalidate();
		} else {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			usuario log = new usuario();
			clsLoguin clsL = new clsLoguin();

			log.setUsuario(user);
			log.setPass(pass);

			int valoracceso = clsL.acceso(log);

			if (valoracceso == 1) {
				
				System.out.println("> Usted ha iniciado como Administrador.");
				response.sendRedirect("Administrador.jsp");
				session.setAttribute("usuario", valoracceso);
			} else if (valoracceso == 2) {
				
				System.out.println("> Usted ha iniciado como Usuario.");
				response.sendRedirect("Usuario.jsp");
			} else {
				System.out.println("> Error.");
				response.sendRedirect("Error.jsp");
			}
		}
	}
}