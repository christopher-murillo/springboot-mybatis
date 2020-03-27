package com.mitocode.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempleado", columnDefinition = "serial")
	private int idEmpleado;
	
	
	@NotBlank(message = "Nombre es obligatorio")
	@Column(length = 50)
	private String nombres;

	@NotBlank(message = "Apellidos es obligatorio")
	@Column(length = 100)
	private String apellidos;
	
	@Column(length = 10)
	private String documento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechanacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(columnDefinition = "NUMERIC")
	private double sueldo;
	
	@Column(name = "numerohijos", columnDefinition = "NUMERIC")
	private int numeroHijos;
	
	@Column(length = 10)
	private String usuario;
	
	@Column(length = 10)
	private String clave;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoempleado")
	private TipoEmpleado tipoEmpleado;
	
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Skill> skills;

	public Empleado() {
		super();
	}

	public Empleado(int idEmpleado, @NotBlank(message = "Nombre es obligatorio") String nombres,
			@NotBlank(message = "Apellidos es obligatorio") String apellidos, String documento,
			LocalDate fechaNacimiento, double sueldo, int numeroHijos, String usuario, String clave,
			TipoEmpleado tipoEmpleado, List<Skill> skills) {
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
		this.skills = skills;
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

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", documento=" + documento + ", fechaNacimiento=" + fechaNacimiento + ", sueldo=" + sueldo
				+ ", numeroHijos=" + numeroHijos + ", usuario=" + usuario + ", clave=" + clave + ", tipoEmpleado="
				+ tipoEmpleado + ", skills=" + skills + "]";
	}

}
