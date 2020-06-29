package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Specialty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idspecialty", columnDefinition = "serial")
	private int idSpecialty;
	
	@Column(length = 80)
	private String name;
	
	public Specialty() {
		super();
	}

	public Specialty(int idSpecialty, String name) {
		super();
		this.idSpecialty = idSpecialty;
		this.name = name;
	}

	public int getIdSpecialty() {
		return idSpecialty;
	}

	public void setIdSpecialty(int idSpecialty) {
		this.idSpecialty = idSpecialty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Specialty [idSpecialty=" + idSpecialty + ", name=" + name + "]";
	}
	
			
}
