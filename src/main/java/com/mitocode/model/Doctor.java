package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddoctor", columnDefinition = "serial")
	private int idDoctor;

	@Column(name = "firstname", length = 80)
	private String firstName;

	@Column(name = "lastname", length = 80)
	private String lastName;

	@Column(length = 8)
	private String dni;

	@Column(length = 50)
	private String cmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idspecialty")
	@JsonIgnore
	private Specialty specialty;

	public Doctor() {
		super();
	}

	public Doctor(int idDoctor, String firstName, String lastName, String dni, String cmp, Specialty specialty) {
		super();
		this.idDoctor = idDoctor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.cmp = cmp;
		this.specialty = specialty;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
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

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "Doctor [idDoctor=" + idDoctor + ", firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni
				+ ", cmp=" + cmp + ", specialty=" + specialty + "]";
	}

}
