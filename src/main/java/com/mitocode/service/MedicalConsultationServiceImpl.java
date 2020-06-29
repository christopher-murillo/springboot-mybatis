package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.MedicalConsultation;
import com.mitocode.repository.MedicalConsultationRepository;

@Service
public class MedicalConsultationServiceImpl implements MedicalConsultationService{

	@Autowired
	private MedicalConsultationRepository medicalConsultationRepository;
	
	@Override
	public Integer registrar(MedicalConsultation medicalConsultation) {
		int status = medicalConsultationRepository.save(medicalConsultation) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer actualizar(MedicalConsultation medicalConsultation) {
		int status = medicalConsultationRepository.save(medicalConsultation) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idMedicalConsultation) {
		medicalConsultationRepository.deleteById(idMedicalConsultation);
		return 1;
	}

	@Override
	public List<MedicalConsultation> obtenerMedicalConsultation() {
		return (List<MedicalConsultation>)medicalConsultationRepository.findAll();
	}

	@Override
	public MedicalConsultation obtenerPorId(Integer idMedicalConsultation) {
		return medicalConsultationRepository.findById(idMedicalConsultation).get();
	}
	
}
