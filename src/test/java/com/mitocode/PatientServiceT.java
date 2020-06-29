package com.mitocode;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.mitocode.model.Patient;
import com.mitocode.service.PatientService;

@SpringBootTest
@ContextConfiguration
public class PatientServiceT {

	private static final Logger logger = LoggerFactory.getLogger(PatientServiceT.class);

	@Autowired
	private PatientService patientService;

	@Test
	public void insert() {
		Patient patient = new Patient();
		patient.setFirstName("Sebastian");
		patient.setLastName("Murillo");
		patient.setDni("12345676");
		patient.setNumberClinicaHistory("A123456789");

		int status = patientService.registrar(patient);
		Assert.state(status == 1, "Insert failed");
		Assert.state(patient.getIdPatient() > 0, "Insert failed");
	}

	@Test
	public void update() {
		Patient patient = new Patient();
		patient.setIdPatient(1);
		patient.setFirstName("Carlos");
		patient.setLastName("Murillo");
		patient.setDni("12345677");
		patient.setNumberClinicaHistory("A123456788");

		int status = patientService.actualizar(patient);
		Assert.state(status == 1, "Update failed");
	}

	@Test
	public void delete() {
		int idPatient = 1;
		int status = patientService.eliminar(idPatient);
		Assert.state(status == 1, "Deletion failed");
	}
	
	@Test
	public void list() {
		List<Patient> list = patientService.obtenerPatient();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list, "List is null");
		Assert.notEmpty(list, "List is empty");
	}

}
