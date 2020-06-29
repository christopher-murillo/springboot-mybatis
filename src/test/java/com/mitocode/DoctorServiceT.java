package com.mitocode;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.mitocode.model.Doctor;
import com.mitocode.model.Specialty;
import com.mitocode.service.DoctorService;
import com.mitocode.service.SpecialtyService;

@SpringBootTest
@ContextConfiguration
public class DoctorServiceT {

	private static final Logger logger = LoggerFactory.getLogger(DoctorServiceT.class);

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SpecialtyService specialtyService;

	@Test
	public void insert() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Carmen");
		doctor.setLastName("Renteria");
		doctor.setDni("12345678");
		doctor.setCmp("cmp1");

		Specialty specialty = new Specialty();
		specialty.setIdSpecialty(1);

		doctor.setSpecialty(specialty);

		int status = doctorService.registrar(doctor);
		Assert.state(status == 1, "Insert failed");
		Assert.state(doctor.getIdDoctor() > 0, "Insert failed");
	}

	@Test
	public void update() {
		Doctor doctor = new Doctor();
		doctor.setIdDoctor(1);
		doctor.setFirstName("Roberto");
		doctor.setLastName("Cuellar");
		doctor.setDni("12345678");
		doctor.setCmp("cmp1");

		Specialty specialty = new Specialty();
		specialty.setIdSpecialty(2);

		doctor.setSpecialty(specialty);
		int status = doctorService.actualizar(doctor);
		Assert.state(status == 1, "Update failed");

	}

	@Test
	public void delete() {
		int idDoctor = 1;
		int status = doctorService.eliminar(idDoctor);
		Assert.state(status == 1, "Deletion failed");

	}
	
	@Test
	public void listSpecialty() {
		List<Specialty> list = specialtyService.obtenerSpecialty();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list,"List is Null");
		Assert.notEmpty(list,"List is empty");
	}
}
