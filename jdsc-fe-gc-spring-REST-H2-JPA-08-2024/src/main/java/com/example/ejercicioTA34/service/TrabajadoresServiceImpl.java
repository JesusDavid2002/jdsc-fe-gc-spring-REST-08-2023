package com.example.ejercicioTA34.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicioTA34.dao.ITrabajadoresDAO;
import com.example.ejercicioTA34.dto.Trabajadores;
import com.example.ejercicioTA34.dto.Trabajo;

@Service
public class TrabajadoresServiceImpl implements ITrabajadoresService{

	
	@Autowired
	ITrabajadoresDAO iTrabajadorDao;
	
	@Override
	public List<Trabajadores> listarTrabajadores() {
		// TODO Auto-generated method stub
		// utilizamos el findAll para mostrar todos los trabajadores
		return iTrabajadorDao.findAll();
	}
	
	@Override
	public Trabajadores mostrarTrabajadorID(Long id) {
		// TODO Auto-generated method stub
		// utilizamos el findById para mostrar el trabajador
		return iTrabajadorDao.findById(id).get();
	}
	
	@Override
	public List<Trabajadores> listarTrabajadoresPorTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		// utilizamos el findByName para mostrar los trabajador con ese trabajo
	       return iTrabajadorDao.findByTrabajo(trabajo);
	}

	@Override
	public Trabajadores guardarTrabajador(Trabajadores trabajador) {
		// TODO Auto-generated method stub
		// utilizamos el save para guardar el trabajador
		return iTrabajadorDao.save(trabajador);
	}

	@Override
	public Trabajadores actualizarTrabajador(Trabajadores trabajador) {
		// TODO Auto-generated method stub
		// utilizamos el save para guardar el trabajador
		return iTrabajadorDao.save(trabajador);
	}

	@Override
	public void eliminarTrabajador(Long id) {
		// TODO Auto-generated method stub
		// utilizamos el deleteById para eliminar el trabajador
		iTrabajadorDao.deleteById(id);
	}


}
