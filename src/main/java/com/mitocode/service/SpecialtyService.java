package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Specialty;

public interface SpecialtyService {
	
	Integer registrar (Specialty specialty);
	
	Integer actualizar (Specialty specialty);
	
	Integer eliminar(Integer idSpecialty);
	
	Specialty obtenerPorId(Integer idSpecialty);
	
	List<Specialty> obtenerSpecialty();

}
