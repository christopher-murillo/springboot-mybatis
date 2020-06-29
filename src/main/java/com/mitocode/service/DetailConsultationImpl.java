package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.DetailConsultation;
import com.mitocode.repository.DetailConsultationRepository;

@Service
public class DetailConsultationImpl implements DetailConsultationService {

	@Autowired
	private DetailConsultationRepository detailConsultationRepository;

	@Override
	public Integer registrar(DetailConsultation detailConsultation) {
		int status = detailConsultationRepository.save(detailConsultation) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer actualizar(DetailConsultation detailConsultation) {
		int status = detailConsultationRepository.save(detailConsultation) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idDetailConsultation) {
		detailConsultationRepository.deleteById(idDetailConsultation);
		return 1;
	}

	@Override
	public List<DetailConsultation> obtenerDetailConsultation() {
		return (List<DetailConsultation>) detailConsultationRepository.findAll();
	}

	@Override
	public DetailConsultation obtenerPorId(Integer idDetailConsultation) {
		return detailConsultationRepository.findById(idDetailConsultation).get();
	}

}
