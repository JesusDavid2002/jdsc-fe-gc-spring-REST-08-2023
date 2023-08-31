package com.example.ejercicioTA34.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicioTA34.dto.Trabajadores;
import com.example.ejercicioTA34.dto.Trabajo;

public interface ITrabajadoresDAO extends JpaRepository<Trabajadores, Long>{

	// Lista los clientes mediante el trabajo
	public List<Trabajadores> findByTrabajo(Trabajo trabajo);

}
