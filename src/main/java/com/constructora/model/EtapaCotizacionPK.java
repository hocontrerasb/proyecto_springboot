package com.constructora.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EtapaCotizacionPK implements Serializable {
		
	@ManyToOne
	@JoinColumn(name = "id_etapa", nullable = false)
	private Etapa etapa;

	@ManyToOne
	@JoinColumn(name = "id_cotizacion", nullable = false)
	private Cotizacion cotizacion;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cotizacion == null) ? 0 : cotizacion.hashCode());
		result = prime * result + ((etapa == null) ? 0 : etapa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtapaCotizacionPK other = (EtapaCotizacionPK) obj;
		if (cotizacion == null) {
			if (other.cotizacion != null)
				return false;
		} else if (!cotizacion.equals(other.cotizacion))
			return false;
		if (etapa == null) {
			if (other.etapa != null)
				return false;
		} else if (!etapa.equals(other.etapa))
			return false;
		return true;
	}
}
