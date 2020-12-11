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
import com.constructora.model.Material;
import com.constructora.service.IMaterialService;

@RestController
@RequestMapping("/materiales")
public class MaterialController {
	
	@Autowired
	private IMaterialService service;
	
	@GetMapping
	public ResponseEntity<List<Material>> listar() {
		List<Material> lista = service.listar();
		return new ResponseEntity<List<Material>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Material> listarPorId(@PathVariable("id") Integer id) {
		Material obj = service.leerPorId(id);
		if (obj.getIdMaterial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Material>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Material material) {
		Material obj = service.registrar(material);
		//Materials/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(material.getIdMaterial()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Material> modificar(@Valid @RequestBody Material material) {
		Material obj = service.modificar(material);
		return new ResponseEntity<Material>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Material obj = service.leerPorId(id);
		if (obj.getIdMaterial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
