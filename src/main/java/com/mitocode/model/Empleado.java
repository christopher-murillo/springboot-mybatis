package com.mitocode.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class Empleado {

	private int idEmpleado;
	@NotBlank(message = "Nombre es obligatorio")
	private String nombres;
	@NotBlank(message = "Apellidos es obligatorio")
	private String apellidos;
	private String documento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private double sueldo;
	private int numeroHijos;
	private String usuario;
	private String clave;
	private TipoEmpleado tipoEmpleado;

	public Empleado() {
		super();
	}

	public Empleado(int idEmpleado, @NotBlank(message = "Nombre es obligatorio") String nombres,
			@NotBlank(message = "Apellidos es obligatorio") String apellidos, String documento,
			LocalDate fechaNacimiento, double sueldo, int numeroHijos, String usuario, String clave,
			TipoEmpleado tipoEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldo = sueldo;
		this.numeroHijos = numeroHijos;
		this.usuario = usuario;
		this.clave = clave;
		this.tipoEmpleado = tipoEmpleado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", documento=" + documento + ", fechaNacimiento=" + fechaNacimiento + ", sueldo=" + sueldo
				+ ", numeroHijos=" + numeroHijos + ", usuario=" + usuario + ", clave=" + clave + ", tipoEmpleado="
				+ tipoEmpleado + "]";
	}

}
