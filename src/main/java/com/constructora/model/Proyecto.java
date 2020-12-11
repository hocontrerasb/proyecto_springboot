package com.constructora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de proyectos")
@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProyecto;

	@ApiModelProperty(notes = "Nombre del proyecto, solo caracteres")
	@Column(name = "nombreProyecto", nullable = false, length = 50)
	private String nombreProyecto;


	@ApiModelProperty(notes = "Fecha inicio del proyecto, formato fecha")
	@Column(name = "fechaInicio", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaInicio;

	@ApiModelProperty(notes = "Nombre del contacto, maximo 50 caracteres")
	@Column(name = "nombreContacto", nullable = false, length = 50)
	private String nombreContacto;

	@ApiModelProperty(notes = "Teléfono del contacto")
	@Column(name = "telefonoContacto", nullable = false, length = 50)
	private Integer telefonoContacto;

	@ApiModelProperty(notes = "Estado del proyecto, en palabras")
	@Column(name = "estado", nullable = false, length = 50)
	private String estado;


	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public Integer getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(Integer telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	
}
