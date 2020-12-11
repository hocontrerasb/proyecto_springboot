package com.constructora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMaterial;
		
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
}
