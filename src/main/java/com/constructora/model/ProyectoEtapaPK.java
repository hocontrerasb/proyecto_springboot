package com.constructora.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProyectoEtapaPK implements Serializable {
	
	
	@ManyToOne
	@JoinColumn(name = "id_proyecto", nullable = false)
	private Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name = "id_etapa", nullable = false)
	private Etapa etapa;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proyecto == null) ? 0 : proyecto.hashCode());
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
		ProyectoEtapaPK other = (ProyectoEtapaPK) obj;
		if (proyecto == null) {
			if (other.proyecto != null)
				return false;
		} else if (!proyecto.equals(other.proyecto))
			return false;
		if (etapa == null) {
			if (other.etapa != null)
				return false;
		} else if (!etapa.equals(other.etapa))
			return false;
		return true;
	}
}
