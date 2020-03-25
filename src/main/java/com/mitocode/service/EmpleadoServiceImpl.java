package com.mitocode.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.mapper.EmpleadoMapper;
import com.mitocode.mapper.SkillMapper;
import com.mitocode.model.Empleado;
import com.mitocode.model.Skill;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoMapper empleadoMapper;

	@Autowired
	private SkillMapper skillMapper;

	@Override
	public Integer registrar(Empleado empleado, List<Skill> skills) {
		int status = empleadoMapper.registrar(empleado);
		skills = skills.stream().map(s -> {
			return new Skill(s.getDescripcion(), empleado);
		}).collect(Collectors.toList());
		if (!skills.isEmpty()) {
			skillMapper.registrar(skills);
		}
		return status;
	}

	@Override
	public Integer actualizar(Empleado empleado, List<Skill> skills) {
		skillMapper.eliminarSkillsPorEmpleado(empleado.getIdEmpleado());
		int status = empleadoMapper.actualizar(empleado);
		skills = skills.stream().map(s -> {
			return new Skill(s.getDescripcion(), empleado);
		}).collect(Collectors.toList());
		if (!skills.isEmpty()) {
			skillMapper.registrar(skills);
		}
		return status;
	}

	@Override
	public Integer eliminar(Integer idEmpleado) {
		skillMapper.eliminarSkillsPorEmpleado(idEmpleado);
		return empleadoMapper.eliminar(idEmpleado);
	}

	@Override
	public Empleado obtenerPorId(Integer idEmpleado) {
		return empleadoMapper.obtenerPorId(idEmpleado);
	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		return empleadoMapper.obtenerEmpleados();
	}

	@Override
	public Empleado login(String usuario, String clave) {
		return empleadoMapper.login(usuario, clave);
	}

}
