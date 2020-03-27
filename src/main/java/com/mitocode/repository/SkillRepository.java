package com.mitocode.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Empleado;
import com.mitocode.model.Skill;

@Repository
@Transactional
public interface SkillRepository extends CrudRepository<Skill, Integer>{
	
//	Integer removeByEmpleado(Empleado empleado);
	
	@Modifying
	@Query("DELETE FROM Skill s WHERE s.empleado = ?1")
	Integer eliminar(Empleado empleado);

}
