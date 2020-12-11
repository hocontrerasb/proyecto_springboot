package com.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constructora.model.Cotizacion;

public interface ICotizacionRepo extends JpaRepository<Cotizacion, Integer> {

}
