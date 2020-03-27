package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.TipoEmpleado;

@Repository
public interface TipoEmpleadoRepository extends CrudRepository<TipoEmpleado, Integer> {

}
