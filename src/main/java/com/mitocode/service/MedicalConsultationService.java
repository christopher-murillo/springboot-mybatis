package com.mitocode.service;

import java.util.List;

import com.mitocode.model.MedicalConsultation;

public interface MedicalConsultationService {

	Integer registrar (MedicalConsultation medicalConsultation);
	
	Integer actualizar (MedicalConsultation medicalConsultation);
	
	Integer eliminar (Integer idMedicalConsultation);
	
	MedicalConsultation obtenerPorId (Integer idMedicalConsultation);
	
	List<MedicalConsultation> obtenerMedicalConsultation();
}
