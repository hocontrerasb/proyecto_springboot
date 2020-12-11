package com.constructora.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.model.Cotizacion;
import com.constructora.repo.ICotizacionRepo;
import com.constructora.service.ICotizacionService;

@Service
public class CotizacionServiceImpl implements ICotizacionService {
	
	@Autowired
	private ICotizacionRepo repo;
	
	@Override
	public Cotizacion registrar(Cotizacion obj) {
		return repo.save(obj);
	}
	
	@Override
	public Cotizacion modificar(Cotizacion obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Cotizacion> listar() {
		return repo.findAll();
	}
	
	@Override
	public Cotizacion leerPorId(Integer id) {
		Optional<Cotizacion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cotizacion();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
