package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Patient;
import com.mitocode.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Integer registrar(Patient patient) {
		int status = patientRepository.save(patient) !=null ? 1:0;
		return status;
	}

	@Override
	public Integer actualizar(Patient patient) {
		int status = patientRepository.save(patient) !=null ? 1:0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idPatient) {
		patientRepository.deleteById(idPatient);
		return 1;
	}

	@Override
	public List<Patient> obtenerPatient() {
		return (List<Patient>)patientRepository.findAll();
	}

	@Override
	public Patient obtenerPorId(Integer idPatient) {
		return patientRepository.findById(idPatient).get();
	}

	
}
