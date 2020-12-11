package com.constructora.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.model.EtapaCotizacion;
import com.constructora.repo.IEtapaCotizacionRepo;
import com.constructora.service.IEtapaCotizacionService;


@Service
public class EtapaCotizacionServiceImpl implements IEtapaCotizacionService {
	
	@Autowired
	private IEtapaCotizacionRepo repo;
	
	@Override
	public List<EtapaCotizacion> listarCotizacionesPorEtapa(Integer idetapa) {
		return repo.listarCotizacionesPorEtapa(idetapa);
	}
}
