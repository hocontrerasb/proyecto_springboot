package com.constructora.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.constructora.model.ProyectoEtapa;


public interface IProyectoEtapaRepo extends JpaRepository<ProyectoEtapa, Integer> {
	//@Transactional
	@Modifying
	@Query(value = "INSERT INTO proyecto_etapa(id_proyecto, id_etapa) VALUES (:idProyecto, :idEtapa)", nativeQuery = true)
	Integer registrar(@Param("idProyecto") Integer idProyecto, @Param("idEtapa") Integer idEtapa);

	@Query("from ProyectoEtapa ce where id_Proyecto = :idProyecto")
	List<ProyectoEtapa> listarEtapasPorProyecto(@Param("idProyecto") Integer idproyecto);

}
