package com.roberto.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.roberto.Conexion.ConexionBd;

public class ClsArchivo {

	public void guardararchivos(String nombre) {

		try {
			ConexionBd con = new ConexionBd();
			PreparedStatement stm;
			String consulta = "insert into image(nameoffile) value(?)";
			stm = con.RetornarConexion().prepareStatement(consulta);
			stm.setString(1, nombre);

			stm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}

	public String mostrarArchivo(String name) {

		String lista = "";
		try {
			ConexionBd con = new ConexionBd();
			PreparedStatement stm;
			String consulta = "select * from image where nameoffile = ?";
			stm = con.RetornarConexion().prepareStatement(consulta);
			stm.setString(1, name);
			ResultSet result = stm.executeQuery();

			while (result.next()) {
				lista = result.getString("nameoffile");
			}

		} catch (Exception e) {
			System.out.println("Error en el DAO " + e);
		}
		return lista;
	}

}
