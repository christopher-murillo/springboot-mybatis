package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idskill", columnDefinition = "serial")
	private int idSkill;

	@Column(length = 50)
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idempleado")
	@JsonIgnore
	private Empleado empleado;

	public Skill() {
		super();
	}

	public Skill(String descripcion, Empleado empleado) {
		super();
		this.descripcion = descripcion;
		this.empleado = empleado;
	}

	public int getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Skill [idSkill=" + idSkill + ", descripcion=" + descripcion + "]";
	}

}
