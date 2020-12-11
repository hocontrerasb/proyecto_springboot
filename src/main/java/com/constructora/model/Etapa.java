package com.constructora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etapa")
public class Etapa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEtapa;
		
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	@Column(name = "total_mano_obra", nullable = false, length = 50)
	private Integer total_mano_obra;
	
	public Integer getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(Integer idEtapa) {
		this.idEtapa = idEtapa;
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

	public Integer getTotal_mano_obra() {
		return total_mano_obra;
	}

	public void setTotal_mano_obra(Integer total_mano_obra) {
		this.total_mano_obra = total_mano_obra;
	}


}
