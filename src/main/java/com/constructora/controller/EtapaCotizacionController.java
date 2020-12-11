package com.constructora.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constructora.model.EtapaCotizacion;
import com.constructora.model.ProyectoEtapa;
import com.constructora.service.IEtapaCotizacionService;
import com.constructora.service.IProyectoEtapaService;

@RestController
@RequestMapping("/consultacotizaciones")
public class EtapaCotizacionController {
	
	@Autowired
	private IEtapaCotizacionService service;
	
	@GetMapping(value = "/{idEtapa}")
	public ResponseEntity<List<EtapaCotizacion>> listar(@PathVariable("idProyecto") Integer idetapa) {
		List<EtapaCotizacion> consultascotizacion = new ArrayList<>();
		consultascotizacion = service.listarCotizacionesPorEtapa(idetapa);
		return new ResponseEntity<List<EtapaCotizacion>>(consultascotizacion, HttpStatus.OK);
	}
}
