package com.constructora.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "etapa_cotizacion")
@IdClass(EtapaCotizacionPK.class)
public class EtapaCotizacion {
	
	
	@Id
	private Etapa etapa;
	
	@Id
	private Cotizacion cotizacion;

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	

}
