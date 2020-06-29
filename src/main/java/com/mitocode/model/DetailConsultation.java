package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detailconsultation")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DetailConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddetailconsultation", columnDefinition = "serial")
	private int idDetailConsultation;

	@Column(length = 80)
	private String diagnostic;

	@Column(length = 100)
	private String treatment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmedicalconsultation")
	private MedicalConsultation medicalConsultation;

	public DetailConsultation() {
		super();
	}

	public DetailConsultation(int idDetailConsultation, String diagnostic, String treatment,
			MedicalConsultation medicalConsultation) {
		super();
		this.idDetailConsultation = idDetailConsultation;
		this.diagnostic = diagnostic;
		this.treatment = treatment;
		this.medicalConsultation = medicalConsultation;
	}

	public int getIdDetailConsultation() {
		return idDetailConsultation;
	}

	public void setIdDetailConsultation(int idDetailConsultation) {
		this.idDetailConsultation = idDetailConsultation;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

	@Override
	public String toString() {
		return "DetailConsultation [idDetailConsultation=" + idDetailConsultation + ", diagnostic=" + diagnostic
				+ ", treatment=" + treatment + ", medicalConsultation=" + medicalConsultation + "]";
	}

}
