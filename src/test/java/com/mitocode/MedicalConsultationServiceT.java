package com.mitocode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.mitocode.model.Doctor;
import com.mitocode.model.MedicalConsultation;
import com.mitocode.model.Patient;
import com.mitocode.service.MedicalConsultationService;

public class MedicalConsultationServiceT {

	private static final Logger logger = LoggerFactory.getLogger(MedicalConsultationServiceT.class);

	@Autowired
	private MedicalConsultationService medicalConsultationService;
	
	@Test
	public void insert() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = "13-10-1979";
		
		LocalDate localDate = LocalDate.parse(date, formatter);
		MedicalConsultation medicalconsultation  = new MedicalConsultation();
		medicalconsultation.setCreateDate(localDate);
		
		Doctor doctor = new Doctor();
		doctor.setIdDoctor(1);
		medicalconsultation.setDoctor(doctor);
		
		Patient patient = new Patient();
		patient.setIdPatient(2);
		medicalconsultation.setPatient(patient);
		
		int status = medicalConsultationService.registrar(medicalconsultation);
		Assert.state(status == 1, "Insert failed");
		//Assert.state(medicalconsultation.getIdMedicalConsultation()>0, "Insert failed");
		
	}
	
	@Test
	public void update() {
		MedicalConsultation  medicalconsultation = new MedicalConsultation();
		medicalconsultation.setIdMedicalConsultation(1);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = "13-10-1970";
		
		LocalDate localDate = LocalDate.parse(date, formatter);
		medicalconsultation.setCreateDate(localDate);
		
		Doctor doctor = new Doctor();
		doctor.setIdDoctor(1);
		medicalconsultation.setDoctor(doctor);
		
		Patient patient = new Patient();
		patient.setIdPatient(2);
		medicalconsultation.setPatient(patient);
		
		int status = medicalConsultationService.registrar(medicalconsultation);
		Assert.state(status == 1, "Update failed");
	}
	
	@Test
	public void delete() {
		int idMedicalConsultation = 2;
		int status = medicalConsultationService.eliminar(idMedicalConsultation);
		Assert.state(status == 1, "Deletion failed");
		
	}
	
	@Test
	public void list() {
		List<MedicalConsultation> list = medicalConsultationService.obtenerMedicalConsultation();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list,"List is null");
		Assert.notEmpty(list,"List is empty");
	}
	
}
