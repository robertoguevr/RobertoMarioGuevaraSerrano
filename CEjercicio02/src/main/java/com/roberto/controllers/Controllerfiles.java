package com.roberto.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.roberto.DAO.ClsArchivo;

/**
 * Servlet implementation class Controllerfiles
 */
@MultipartConfig
public class Controllerfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllerfiles() {
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
		//doGet(request, response);
		Part archivo= request.getPart("archivo");
		
		String nombreImagen = archivo.getSubmittedFileName();
		String ruta = "C:\\Users\\rober\\OneDrive\\Documentos\\GitHub\\RobertoMarioGuevaraSerrano\\CEjercicio02\\src\\main\\webapp\\Files\\"+nombreImagen;
		
		try {
			FileOutputStream fileoutput = new FileOutputStream(ruta);
			InputStream stream = archivo.getInputStream();
			
			byte[] datos = new byte[stream.available()];
			stream.read(datos);
			fileoutput.write(datos);
			fileoutput.close();
			
		} catch (Exception e) {
			System.out.println("Error en ControllerFiles " + e);
		}
		
		ClsArchivo clsArchivo = new ClsArchivo();
		clsArchivo.guardararchivos(nombreImagen);
		
		String nombre = clsArchivo.mostrarArchivo(nombreImagen);
		HttpSession session = request.getSession(true);
		session.setAttribute("nombre", nombre);
		System.out.println(nombre);
	}

}
