package com.mitocode.dto;

import com.mitocode.model.Specialty;

public class SpecialtyDTO {

	private String nombre;

	public SpecialtyDTO(Specialty specialty) {
		super();
		this.setNombre(specialty.getName());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
