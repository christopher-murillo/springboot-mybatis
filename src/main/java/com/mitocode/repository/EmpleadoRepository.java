package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

}
