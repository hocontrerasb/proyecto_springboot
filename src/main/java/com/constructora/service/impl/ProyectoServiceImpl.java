package com.constructora.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.model.Proyecto;
import com.constructora.repo.IProyectoRepo;
import com.constructora.service.IProyectoService;

@Service
public class ProyectoServiceImpl implements IProyectoService {
	
	@Autowired
	private IProyectoRepo repo;
	
	@Override
	public Proyecto registrar(Proyecto obj) {
		return repo.save(obj);
	}
	
	@Override
	public Proyecto modificar(Proyecto obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Proyecto> listar() {
		return repo.findAll();
	}
	
	@Override
	public Proyecto leerPorId(Integer id) {
		Optional<Proyecto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Proyecto();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
