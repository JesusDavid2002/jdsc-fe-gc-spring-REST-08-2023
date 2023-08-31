package com.example.ejercicioTA34.service;

import java.util.List;

import com.example.ejercicioTA34.dto.Trabajadores;
import com.example.ejercicioTA34.dto.Trabajo;

public interface ITrabajadoresService {
	
	// Listar todos los trabajadores
	public List<Trabajadores> listarTrabajadores();
	
	// Listar el trabajador mediante la id
	public Trabajadores mostrarTrabajadorID(Long id);
	
	// Listar los trabajadores mediante el trabajo
	public List<Trabajadores> listarTrabajadoresPorTrabajo(Trabajo trabajo);
	
	// Guardar un trabajador
	public Trabajadores guardarTrabajador(Trabajadores trabajador);
	
	// Actualizar un trabajador
	public Trabajadores actualizarTrabajador(Trabajadores trabajador);
	
	// Eliminar un trabajador mediante id
	public void eliminarTrabajador(Long id);


}
