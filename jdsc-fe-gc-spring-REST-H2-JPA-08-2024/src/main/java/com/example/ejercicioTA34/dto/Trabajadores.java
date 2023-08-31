package com.example.ejercicioTA34.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trabajadores")
public class Trabajadores {

	
	@Id
	// con el genereatevalue y el genereationtype busca el ultimo valor e incrementa
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	// mediante el column juntamos el atributo con la columna
	@Column(name = "nombre")
	private String nombre;
	@Enumerated(EnumType.STRING)
	@Column(name = "trabajo")
	private Trabajo trabajo;
	@Column(name = "salario")
	private double salario;
	
	public Trabajadores() {}

	public Trabajadores(long id, String nombre, Trabajo trabajo, double salario) {
		this.ID = id;
		this.nombre = nombre;
		this.trabajo = trabajo;
		this.salario = salario;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}


	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	

	@Override
	public String toString() {
		return "Trabajador [ID=" + ID + ", nombre=" + nombre + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}
}
