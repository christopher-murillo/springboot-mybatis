package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Specialty;

@Repository
	public interface SpecialtyRepository extends CrudRepository<Specialty,Integer>{
		
	}

