package com.mitocode.dto;

import com.mitocode.model.Empleado;

public class EmpleadoDTO {
	
	private String nombreCompleto;

	public EmpleadoDTO(Empleado empleado) {
		super();
		this.setNombreCompleto(String.join(" ", empleado.getNombres(), empleado.getApellidos()));
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	

}
