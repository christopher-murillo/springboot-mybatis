package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.mapper.EmpleadoMapper;
import com.mitocode.model.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoMapper empleadoMapper;

	@Override
	public Integer registrar(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoMapper.registrar(empleado);
	}

	@Override
	public Integer actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoMapper.actualizar(empleado);
	}

	@Override
	public Integer eliminar(Integer idEmpleado) {
		// TODO Auto-generated method stub
		return empleadoMapper.eliminar(idEmpleado);
	}

	@Override
	public Empleado obtenerPorId(Integer idEmpleado) {
		// TODO Auto-generated method stub
		return empleadoMapper.obtenerPorId(idEmpleado);
	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		// TODO Auto-generated method stub
		return empleadoMapper.obtenerEmpleados();
	}

	@Override
	public Empleado login(String usuario, String clave) {
		// TODO Auto-generated method stub
		return empleadoMapper.login(usuario, clave);
	}

}
