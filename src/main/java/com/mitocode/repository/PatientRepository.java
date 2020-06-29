package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
