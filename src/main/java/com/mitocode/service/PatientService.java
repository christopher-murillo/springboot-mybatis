package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Patient;

public interface PatientService {

	Integer registrar(Patient patient);

	Integer actualizar(Patient patient);

	Integer eliminar(Integer idPatient);
	
	Patient obtenerPorId (Integer idPatient);
	
	List<Patient> obtenerPatient();
	
	
	
}
