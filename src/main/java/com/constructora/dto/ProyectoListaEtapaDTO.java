package com.constructora.dto;

import java.util.List;

import com.constructora.model.Etapa;
import com.constructora.model.Proyecto;

public class ProyectoListaEtapaDTO {
	
	private Proyecto proyecto;
	private List<Etapa> lstEtapa;
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public List<Etapa> getLstEtapa() {
		return lstEtapa;
	}
	public void setLstEtapa(List<Etapa> lstEtapa) {
		this.lstEtapa = lstEtapa;
	}
	
	
}
