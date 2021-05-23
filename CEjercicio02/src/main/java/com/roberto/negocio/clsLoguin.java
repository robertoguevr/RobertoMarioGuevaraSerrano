package com.roberto.negocio;

import com.roberto.DAO.ClsLog;
import com.roberto.entidades.Loguin;
import com.roberto.entidades.usuario;

public class clsLoguin {

	public int acceso(usuario log) {
		int acceso = 0;
		ClsLog clsLoginBD = new ClsLog();
		usuario user = new usuario();
		
		user = clsLoginBD.ValidarLogin(log);
		if (user != null) {
			if (user.getIdTipoUsuario() == 1) {
				acceso = 1;
				System.out.println(user.getIdTipoUsuario());
			} else if (user.getIdTipoUsuario() == 2) {
				acceso = 2;
				System.out.println(user.getIdTipoUsuario());
			}
		} else {
			System.out.println("El usuario no existe");
		}
		return acceso;
	}
	
}
