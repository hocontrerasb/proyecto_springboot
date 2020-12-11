package com.constructora.controller;

import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.constructora.exception.ModeloNotFoundException;
import com.constructora.model.Etapa;
import com.constructora.service.IEtapaService;

@RestController
@RequestMapping("/etapas")
public class EtapaController {
	
	@Autowired
	private IEtapaService service;
	
	@GetMapping
	public ResponseEntity<List<Etapa>> listar() {
		List<Etapa> lista = service.listar();
		return new ResponseEntity<List<Etapa>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Etapa> listarPorId(@PathVariable("id") Integer id) {
		Etapa obj = service.leerPorId(id);
		if (obj.getIdEtapa() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Etapa>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Etapa etapa) {
		Etapa obj = service.registrar(etapa);
		//Etapas/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(etapa.getIdEtapa()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Etapa> modificar(@Valid @RequestBody Etapa etapa) {
		Etapa obj = service.modificar(etapa);
		return new ResponseEntity<Etapa>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Etapa obj = service.leerPorId(id);
		if (obj.getIdEtapa() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
