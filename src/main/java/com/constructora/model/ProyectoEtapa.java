package com.constructora.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto_etapa")
@IdClass(ProyectoEtapaPK.class)
public class ProyectoEtapa {
	
	
	@Id
	private Proyecto proyecto;
	
	@Id
	private Etapa etapa;

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}



}
