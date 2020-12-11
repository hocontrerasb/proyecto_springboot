package com.constructora.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.model.Material;
import com.constructora.repo.IMaterialRepo;
import com.constructora.service.IMaterialService;

@Service
public class MaterialServiceImpl implements IMaterialService {
	
	@Autowired
	private IMaterialRepo repo;
	
	@Override
	public Material registrar(Material obj) {
		return repo.save(obj);
	}
	
	@Override
	public Material modificar(Material obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Material> listar() {
		return repo.findAll();
	}
	
	@Override
	public Material leerPorId(Integer id) {
		Optional<Material> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Material();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
