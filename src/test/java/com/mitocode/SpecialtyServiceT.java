package com.mitocode;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.mitocode.model.Specialty;
import com.mitocode.service.SpecialtyService;

@SpringBootTest
@ContextConfiguration
public class SpecialtyServiceT {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoServiceT.class);

	@Autowired
	private SpecialtyService specialtyService;

	@Test
	public void insert() {
		Specialty specialty = new Specialty();
		specialty.setName("Pediatria");

		int status = specialtyService.registrar(specialty);
		Assert.state(status == 1, "Insert failed");
		// Assert.state(specialty.getIdSpecialty()> 0, "Insert failed2");
	}

	@Test
	public void update() {
		Specialty specialty = new Specialty();
		specialty.setIdSpecialty(3);
		specialty.setName("Urologia");

		int status = specialtyService.actualizar(specialty);
		Assert.state(status == 1, "Update failed");
	}

	@Test
	public void delete() {
		int idPaciente = 7;
		int status = specialtyService.eliminar(idPaciente);
		Assert.state(status == 1, "Deletion failed");
	}

	@Test
	public void list() {
		List<Specialty> list = specialtyService.obtenerSpecialty();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list, "List is null");
		Assert.notEmpty(list, "List is empty");
	}

}
