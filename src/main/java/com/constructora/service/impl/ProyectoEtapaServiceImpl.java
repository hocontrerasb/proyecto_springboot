package com.constructora.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.model.ProyectoEtapa;
import com.constructora.repo.IProyectoEtapaRepo;
import com.constructora.service.IProyectoEtapaService;


@Service
public class ProyectoEtapaServiceImpl implements IProyectoEtapaService {
	
	@Autowired
	private IProyectoEtapaRepo repo;
	
	@Override
	public List<ProyectoEtapa> listarEtapasPorProyecto(Integer idproyecto) {
		return repo.listarEtapasPorProyecto(idproyecto);
	}
}
