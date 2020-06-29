package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.DetailConsultation;

@Repository
public interface DetailConsultationRepository extends CrudRepository<DetailConsultation, Integer>{

}
