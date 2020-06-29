package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpatient", columnDefinition = "serial")
	private int idPatient;

	@Column(name = "firstname", length = 80)
	private String firstName;

	@Column(name = "lastname", length = 80)
	private String lastName;

	@Column(length = 8)
	private String dni;

	@Column(name = "numberclinicahistory", length = 15)
	private String numberClinicaHistory;

	public Patient() {
		super();
	}

	public Patient(int idPatient, String firstName, String lastName, String dni, String numberClinicaHistory) {
		super();
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.numberClinicaHistory = numberClinicaHistory;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNumberClinicaHistory() {
		return numberClinicaHistory;
	}

	public void setNumberClinicaHistory(String numberClinicaHistory) {
		this.numberClinicaHistory = numberClinicaHistory;
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", firstName=" + firstName + ", lastName=" + lastName + ", dni="
				+ dni + ", numberClinicaHistory=" + numberClinicaHistory + "]";
	}

}
