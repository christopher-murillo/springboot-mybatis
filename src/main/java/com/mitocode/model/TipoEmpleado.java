package com.mitocode.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipoempleado")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class TipoEmpleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipoempleado", columnDefinition = "serial")
	private int idTipoEmpleado;
	
	@Column(length = 50)
	private String descripcion;
	
	@Transient
	private String estado;

	public TipoEmpleado() {
		super();
	}

	public TipoEmpleado(int idTipoEmpleado, String descripcion) {
		super();
		this.idTipoEmpleado = idTipoEmpleado;
		this.descripcion = descripcion;
	}

	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoEmpleado [idTipoEmpleado=" + idTipoEmpleado + ", descripcion=" + descripcion + "]";
	}

}
