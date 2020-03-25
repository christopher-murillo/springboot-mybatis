package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Empleado;
import com.mitocode.model.Skill;

public interface EmpleadoService {

	Integer registrar(Empleado empleado, List<Skill> skills);

	Integer actualizar(Empleado empleado, List<Skill> skills);

	Integer eliminar(Integer idEmpleado);

	Empleado obtenerPorId(Integer idEmpleado);

	List<Empleado> obtenerEmpleados();

	Empleado login(String usuario, String clave);
}
