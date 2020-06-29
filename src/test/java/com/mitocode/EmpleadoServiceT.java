package com.mitocode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.mitocode.model.Empleado;
import com.mitocode.model.Skill;
import com.mitocode.model.TipoEmpleado;
import com.mitocode.service.EmpleadoService;
import com.mitocode.service.TipoEmpleadoService;

@SpringBootTest
@ContextConfiguration
public class EmpleadoServiceT {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoServiceT.class);

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;

	@Test
	public void insert() {
		Empleado empleado = new Empleado();
		empleado.setNombres("Dany");
		empleado.setApellidos("Cenas Vasquez");
		empleado.setDocumento("12345678");

		empleado.setFechaNacimiento(LocalDate.now());
		empleado.setSueldo(1000);
		empleado.setNumeroHijos(0);
		empleado.setUsuario("admin");
		empleado.setClave("admin");

		TipoEmpleado tipoEmpleado = new TipoEmpleado();
		tipoEmpleado.setIdTipoEmpleado(2);

		empleado.setTipoEmpleado(tipoEmpleado);

		Skill s1 = new Skill();
		s1.setDescripcion("JAVA");

		Skill s2 = new Skill();
		s2.setDescripcion("NET");

		Skill s3 = new Skill();
		s3.setDescripcion("PYTHON");

		List<Skill> skills = new ArrayList<>();
		skills.add(s1);
		skills.add(s2);
		skills.add(s3);

		int status = empleadoService.registrar(empleado, skills);
		Assert.state(status == 1, "Insert failed");

		Assert.state(empleado.getIdEmpleado() > 0, "Insert failed 2");
	}

	@Test
	public void update() {
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(20);
		empleado.setNombres("Juan");
		empleado.setApellidos("Cenas Vasquez");
		empleado.setDocumento("12345678");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = "13-10-1992";

		LocalDate localDate = LocalDate.parse(date, formatter);
		empleado.setFechaNacimiento(localDate);

//		empleado.setFechaNacimiento(LocalDate.now());
		empleado.setSueldo(1000);
		empleado.setNumeroHijos(0);
		empleado.setUsuario("admin");
		empleado.setClave("admin");

		TipoEmpleado tipoEmpleado = new TipoEmpleado();
		tipoEmpleado.setIdTipoEmpleado(2);

		empleado.setTipoEmpleado(tipoEmpleado);

		List<Skill> skills = new ArrayList<>();

		int status = empleadoService.actualizar(empleado, skills);
		Assert.state(status == 1, "Update failed");
	}

	@Test
	public void delete() {
		int idEmpleado = 1;
		int status = empleadoService.eliminar(idEmpleado);
		Assert.state(status == 1, "Deletion failed");
	}

	@Test
	public void list() {
		List<Empleado> list = empleadoService.obtenerEmpleados();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list, "List is null");
		Assert.notEmpty(list, "List is empty");
	}

	@Test
	public void listTipos() {
		List<TipoEmpleado> list = tipoEmpleadoService.obtenerTipos();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list, "List is null");
		Assert.notEmpty(list, "List is empty");
	}

	@Test
	public void testLogin() {
		Empleado empleado = empleadoService.login("admin", "123456");
		logger.info(empleado.toString());
		Assert.notNull(empleado, "Empleado is null");
	}

}
