package com.roberto.negocio;

import com.roberto.entidades.Loguin;

public class clsLoguin {

	public int acceso(Loguin log) {
		
		int acceso=0;
		if(log.getUser().equals("roberto") && log.getPass().equals("123"))
		{
			acceso=1;
		}
		return acceso;
	}
}
