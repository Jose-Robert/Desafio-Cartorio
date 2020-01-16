package com.docket.cartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docket.cartorio.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
	
}
