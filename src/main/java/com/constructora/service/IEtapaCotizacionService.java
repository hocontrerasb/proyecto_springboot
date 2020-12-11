package com.constructora.service;

import java.util.List;

import com.constructora.model.EtapaCotizacion;

public interface IEtapaCotizacionService  {
	
	
	List<EtapaCotizacion> listarCotizacionesPorEtapa(Integer idEtapa);
	
	

}
