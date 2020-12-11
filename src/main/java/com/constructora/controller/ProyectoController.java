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
import com.constructora.model.Proyecto;
import com.constructora.service.IProyectoService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
	
	@Autowired
	private IProyectoService service;
	
	@GetMapping
	public ResponseEntity<List<Proyecto>> listar() {
		List<Proyecto> lista = service.listar();
		return new ResponseEntity<List<Proyecto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proyecto> listarPorId(@PathVariable("id") Integer id) {
		Proyecto obj = service.leerPorId(id);
		if (obj.getIdProyecto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Proyecto proyecto) {
		Proyecto obj = service.registrar(proyecto);
		//Proyectos/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proyecto.getIdProyecto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Proyecto> modificar(@Valid @RequestBody Proyecto proyecto) {
		Proyecto obj = service.modificar(proyecto);
		return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Proyecto obj = service.leerPorId(id);
		if (obj.getIdProyecto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
