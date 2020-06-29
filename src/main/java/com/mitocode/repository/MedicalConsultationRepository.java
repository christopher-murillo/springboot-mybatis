package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.MedicalConsultation;

@Repository
public interface MedicalConsultationRepository extends CrudRepository<MedicalConsultation, Integer> {

}
