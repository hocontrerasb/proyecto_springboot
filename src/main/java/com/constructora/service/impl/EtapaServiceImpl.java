package com.constructora.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.model.Etapa;
import com.constructora.repo.IEtapaRepo;
import com.constructora.service.IEtapaService;

@Service
public class EtapaServiceImpl implements IEtapaService {
	
	@Autowired
	private IEtapaRepo repo;
	
	@Override
	public Etapa registrar(Etapa obj) {
		return repo.save(obj);
	}
	
	@Override
	public Etapa modificar(Etapa obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Etapa> listar() {
		return repo.findAll();
	}
	
	@Override
	public Etapa leerPorId(Integer id) {
		Optional<Etapa> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Etapa();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
