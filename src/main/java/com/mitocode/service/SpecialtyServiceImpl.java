package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Specialty;
import com.mitocode.repository.SpecialtyRepository;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Override
	public Integer registrar(Specialty specialty) {
		int status = specialtyRepository.save(specialty) !=null ? 1:0;
		return status;
	}

	@Override
	public Integer actualizar(Specialty specialty) {
		int status = specialtyRepository.save(specialty) !=null ? 1:0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idSpecialty) {
		specialtyRepository.deleteById(idSpecialty);
		return 1;
	}

	@Override
	public List<Specialty> obtenerSpecialty() {
		return (List<Specialty>)specialtyRepository.findAll();
		
	}

	@Override
	public Specialty obtenerPorId(Integer idSpecialty) {
		return specialtyRepository.findById(idSpecialty).get();
	}
	
}
