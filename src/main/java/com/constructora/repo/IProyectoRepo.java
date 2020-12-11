package com.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constructora.model.Proyecto;

public interface IProyectoRepo extends JpaRepository<Proyecto, Integer> {

}
