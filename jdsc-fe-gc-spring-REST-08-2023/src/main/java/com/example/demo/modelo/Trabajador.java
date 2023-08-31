package com.example.demo.modelo;


public class Trabajador {
	
	public enum Trabajos{
		programador, limpiador, camarero, cocinero
	}
	
	private long ID;
	private String nombre;
	private Trabajos trabajo;
	private double salario;
	
	public Trabajador() {}

	public Trabajador(long id, String nombre, Trabajos trabajo) {
		this.ID = id;
		this.nombre = nombre;
		this.trabajo = trabajo.camarero;
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

	public Trabajos getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajos trabajo) {
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
