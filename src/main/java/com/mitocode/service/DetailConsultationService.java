package com.mitocode.service;

import java.util.List;

import com.mitocode.model.DetailConsultation;

public interface DetailConsultationService {

	Integer registrar (DetailConsultation detailconsultation);
	
	Integer actualizar (DetailConsultation detailConsultation);
	
	Integer eliminar (Integer idDetailConsultation);
	
	DetailConsultation obtenerPorId (Integer idDetailConsultation);
	
	List<DetailConsultation> obtenerDetailConsultation();
}
