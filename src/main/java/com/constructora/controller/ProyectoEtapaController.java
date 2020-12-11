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

import com.constructora.model.ProyectoEtapa;
import com.constructora.service.IProyectoEtapaService;

@RestController
@RequestMapping("/consultaetapas")
public class ProyectoEtapaController {
	
	@Autowired
	private IProyectoEtapaService service;
	
	@GetMapping(value = "/{idProyecto}")
	public ResponseEntity<List<ProyectoEtapa>> listar(@PathVariable("idProyecto") Integer idproyecto) {
		List<ProyectoEtapa> consultasetapa = new ArrayList<>();
		consultasetapa = service.listarEtapasPorProyecto(idproyecto);
		return new ResponseEntity<List<ProyectoEtapa>>(consultasetapa, HttpStatus.OK);
	}
}
