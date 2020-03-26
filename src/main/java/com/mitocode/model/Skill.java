package com.mitocode.model;

public class Skill {

	private int idSkill;
	private String descripcion;
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
