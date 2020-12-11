package com.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constructora.model.Material;

public interface IMaterialRepo extends JpaRepository<Material, Integer> {

}
