package com.constructora.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.constructora.model.EtapaCotizacion;


public interface IEtapaCotizacionRepo extends JpaRepository<EtapaCotizacion, Integer> {
	
	//@Transactional
	@Modifying
	@Query(value = "INSERT INTO etapa_cotizacion(id_etapa, id_cotizacion) VALUES (:idEtapa, :idCotizacion)", nativeQuery = true)
	Integer registrar(@Param("idEtapa") Integer idEtapa, @Param("idCotizacion") Integer idCotizacion);


	@Query("from EtapaCotizacion ce where idEtapa = :idEtapa")
	List<EtapaCotizacion> listarCotizacionesPorEtapa(@Param("idEtapa") Integer idetapa);

}
