package com.mitocode.model;

import java.time.LocalDate;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "medicalconsultation")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MedicalConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmedicalconsultation", columnDefinition = "serial")
	private int idMedicalConsultation;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createdate")
	private LocalDate createDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddoctor")
	private Doctor doctor;

	//@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch =
	//FetchType.LAZY)

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpatient")
	private Patient patient;

	//@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)

	public MedicalConsultation() {
		super();
	}

	public MedicalConsultation(Integer idMedicalConsultation, LocalDate createDate, Doctor doctor, Patient patient) {
		super();
		this.idMedicalConsultation = idMedicalConsultation;
		this.createDate = createDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Integer getIdMedicalConsultation() {
		return idMedicalConsultation;
	}

	public void setIdMedicalConsultation(Integer idMedicalConsultation) {
		this.idMedicalConsultation = idMedicalConsultation;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "MedicalConsultation [idMedicalConsultation=" + idMedicalConsultation + ", createDate=" + createDate
				+ ", doctor=" + doctor + ", patient=" + patient + "]";
	}

}
