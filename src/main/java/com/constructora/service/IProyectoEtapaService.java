package com.constructora.service;

import java.util.List;

import com.constructora.model.ProyectoEtapa;

public interface IProyectoEtapaService  {
	
	
	List<ProyectoEtapa> listarEtapasPorProyecto(Integer idProyecto);
	
	

}
