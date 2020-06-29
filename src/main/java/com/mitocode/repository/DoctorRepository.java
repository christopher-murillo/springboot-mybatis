package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
