package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Trabajador;
import com.google.gson.Gson;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class JdscFeGcSpringRest082023Application {

	public static void main(String[] args) {
		SpringApplication.run(JdscFeGcSpringRest082023Application.class, args);
	}
	
	private List<Trabajador> trabajadores = new ArrayList<>();
	Gson gson = new Gson();
	
	// Mostramos a todos los trabjadores mediante el toJson
	@GetMapping("/empleados")
	public String getTrabajadores() {
		String lista = gson.toJson(trabajadores);
		return lista;
	}
	
	// Añadimos un trabajador mediante fromJson y lo mostramos
	@PostMapping("/empleados")
	public String postTrabajadores(@RequestBody String newTrabajador) {
		
		Trabajador trabajador = gson.fromJson(newTrabajador, Trabajador.class);

		switch(trabajador.getTrabajo()) {
		case programador:	
			trabajador.setSalario(3000);
			break;
		case limpiador:	
			trabajador.setSalario(900.90);
			break;
		case camarero:	
			trabajador.setSalario(1300.87);
			break;
		case cocinero:	
			trabajador.setSalario(2500);
			break;
		}
		
		trabajadores.add(trabajador);
		return trabajadores.toString();
	}
	
	// Recoge los datos del trabajador mediante el fromJson
	// En el bucle recorrera los trabajadores hasta llegar al que tiene la id
	// Seteara todos los campos y hara la conversion a sueldo automaticamente
	@PutMapping("/empleados/{id}")
	public void updateTrabajadores(@PathVariable Long id, @RequestBody String trabajadorData) {
		
		Trabajador trabajador_id = gson.fromJson(trabajadorData, Trabajador.class);
			
		for(Trabajador trabajador: trabajadores) {
			if(trabajador.getID() == id) {
				trabajador.setNombre(trabajador_id.getNombre());
				trabajador.setTrabajo(trabajador_id.getTrabajo());
				
				switch(trabajador.getTrabajo()) {
				case programador:	
					trabajador.setSalario(3000);
					break;
				case limpiador:	
					trabajador.setSalario(900.90);
					break;
				case camarero:	
					trabajador.setSalario(1300.87);
					break;
				case cocinero:	
					trabajador.setSalario(2500);
					break;
				}
			}
		}
	}
	
	// Recorre la lista de trabajadores y cuando llegue al de la id puesta se eliminara
	@DeleteMapping("/empleados/{id}")
	public void deleteTrabajadores(@PathVariable Long id) {
		for(int i = 0; i < trabajadores.size(); i++) {
			if(trabajadores.get(i).getID() == id) {
				trabajadores.remove(i);
				break;
			}
		}
	}
}
