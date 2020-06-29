package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Doctor;


public interface DoctorService {
	
	Integer registrar(Doctor doctor);

	Integer actualizar(Doctor doctor);

	Integer eliminar(Integer idDoctor);

	List<Doctor> obtenerDoctor();
	
	List<Doctor> obtenerDoctorPorEspecialidad();
	
	Doctor obtenerPorId (Integer idDoctor);

}
