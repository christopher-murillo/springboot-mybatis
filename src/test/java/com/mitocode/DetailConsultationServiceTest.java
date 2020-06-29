package com.mitocode;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.mitocode.model.DetailConsultation;
import com.mitocode.model.MedicalConsultation;
import com.mitocode.service.DetailConsultationService;

@SpringBootTest
@ContextConfiguration
public class DetailConsultationServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(DetailConsultationServiceTest.class);
	
	@Autowired
	private DetailConsultationService detailConsultationService;
	
	@Test
	public void insert() {
		DetailConsultation detailConsultation = new DetailConsultation();
		detailConsultation.setDiagnostic("Diagnostico2");
		detailConsultation.setTreatment("Tratamiento2");
		
		MedicalConsultation medicalConsultation = new MedicalConsultation();
		medicalConsultation.setIdMedicalConsultation(1);
		
		detailConsultation.setMedicalConsultation(medicalConsultation);
		
		int status = detailConsultationService.registrar(detailConsultation);
		Assert.state(status == 1, "Insert failed");
		
		//Assert.state(detailConsultation.getIdDetailConsultation() >0, "Insert failed");
		
	}
	
	@Test
	public void update() {
		DetailConsultation detailConsultation = new DetailConsultation();
		detailConsultation.setIdDetailConsultation(1);
		detailConsultation.setDiagnostic("Diagnostico1.1");
		detailConsultation.setTreatment("Tratamiento1.1");
		
		MedicalConsultation medicalConsultation = new MedicalConsultation();
		medicalConsultation.setIdMedicalConsultation(1);
		
		detailConsultation.setMedicalConsultation(medicalConsultation);
		
		int status = detailConsultationService.registrar(detailConsultation);
		Assert.state(status == 1, "Update failed");
	
	}
	
	@Test
	public void delete() {
		int idDetailConsultation = 2;
		int status = detailConsultationService.eliminar(idDetailConsultation);
		Assert.state(status == 1, "Deletion failed");
	}
	
	@Test
	public void list() {
		List<DetailConsultation> list = detailConsultationService.obtenerDetailConsultation();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list, "List is null");
		Assert.notEmpty(list, "List is empty");
	}
	
	
}
