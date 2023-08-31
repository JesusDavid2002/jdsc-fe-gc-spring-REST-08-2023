package com.example.ejercicioTA34.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicioTA34.dto.Trabajadores;
import com.example.ejercicioTA34.dto.Trabajo;
import com.example.ejercicioTA34.service.TrabajadoresServiceImpl;

@RestController
@RequestMapping("/api")
public class TrabajadoresController {
	
	@Autowired
	TrabajadoresServiceImpl trabajadoresServiceImpl;
	
	@GetMapping("/trabajadores")
	public List<Trabajadores> listarTrabajadores(){
		return trabajadoresServiceImpl.listarTrabajadores();
	}
	
	@GetMapping("/trabajadores/{id}")
	public Trabajadores listarTrabajadoresID(@PathVariable(name="id")Long id) {
		return trabajadoresServiceImpl.mostrarTrabajadorID(id);
	}
	
	@GetMapping("/trabajadores/trabajo/{trabajo}")
	public List<Trabajadores> listarTrabajadoresTrabajo(@PathVariable(name="trabajo")Trabajo trabajo){
		return trabajadoresServiceImpl.listarTrabajadoresPorTrabajo(trabajo);
	}
	
	@PostMapping("/trabajadores")
	public Trabajadores guardarTrabajador(@RequestBody Trabajadores trabajador) {
		
		switch(trabajador.getTrabajo()) {
		case PROGRAMADOR:	
			trabajador.setSalario(3000);
			break;
		case LIMPIADOR:	
			trabajador.setSalario(900.90);
			break;
		case CAMARERO:	
			trabajador.setSalario(1300.87);
			break;
		case COCINERO:	
			trabajador.setSalario(2500);
			break;
		}
		
		return trabajadoresServiceImpl.guardarTrabajador(trabajador);
	}
	
	@PutMapping("/trabajadores/{id}")
	public Trabajadores actualizarTrabajador(@PathVariable(name="id")Long id, @RequestBody Trabajadores trabajador) {
		
		Trabajadores trabajador_seleccionado = new Trabajadores();
		Trabajadores trabajador_actualizado = new Trabajadores();
		
		trabajador_seleccionado = trabajadoresServiceImpl.mostrarTrabajadorID(id);
		
		trabajador_seleccionado.setNombre(trabajador.getNombre());
		trabajador_seleccionado.setTrabajo(trabajador.getTrabajo());
		
		switch(trabajador.getTrabajo()) {
		case PROGRAMADOR:	
			trabajador_seleccionado.setSalario(3000);
			break;
		case LIMPIADOR:	
			trabajador_seleccionado.setSalario(900.90);
			break;
		case CAMARERO:	
			trabajador_seleccionado.setSalario(1300.87);
			break;
		case COCINERO:	
			trabajador_seleccionado.setSalario(2500);
			break;
		}
		
		trabajador_actualizado = trabajadoresServiceImpl.actualizarTrabajador(trabajador_seleccionado);
		return trabajador_actualizado;
	}
	
	@DeleteMapping("/trabajadores/{id}")
	public void eliminarTrabajador(@PathVariable(name="id")Long id) {
		trabajadoresServiceImpl.eliminarTrabajador(id);
	}
}
