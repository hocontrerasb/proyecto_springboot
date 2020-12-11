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
import com.constructora.model.Cotizacion;
import com.constructora.service.ICotizacionService;

@RestController
@RequestMapping("/cotizaciones")
public class CotizacionController {
	
	@Autowired
	private ICotizacionService service;
	
	@GetMapping
	public ResponseEntity<List<Cotizacion>> listar() {
		List<Cotizacion> lista = service.listar();
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cotizacion> listarPorId(@PathVariable("id") Integer id) {
		Cotizacion obj = service.leerPorId(id);
		if (obj.getIdCotizacion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Cotizacion>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cotizacion cotizacion) {
		Cotizacion obj = service.registrar(cotizacion);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cotizacion.getIdCotizacion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Cotizacion> modificar(@Valid @RequestBody Cotizacion cotizacion) {
		Cotizacion obj = service.modificar(cotizacion);
		return new ResponseEntity<Cotizacion>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Cotizacion obj = service.leerPorId(id);
		if (obj.getIdCotizacion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
