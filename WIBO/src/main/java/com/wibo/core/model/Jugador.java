package com.wibo.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Jugador")
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdJugador")
	int pkIdJugador;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "estatus")
	String estatus;
	@Column(name = "genero")
	String genero;
	@Column(name = "power")
	int power;
	@Column(name="password")
	String password;
	@OneToMany(mappedBy = "pkIdJugador", targetEntity=Jugar.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Jugar> jugar = new ArrayList<>();
	@OneToMany(mappedBy = "pkIdJugador", targetEntity=Completada.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Completada> completada = new ArrayList<>();
	public int getPkIdJugador() {
		return pkIdJugador;
	}
	public void setPkIdJugador(int pkIdJugador) {
		this.pkIdJugador = pkIdJugador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Jugar> getJugar() {
		return jugar;
	}
	public void setJugar(List<Jugar> jugar) {
		this.jugar = jugar;
	}
	public List<Completada> getCompletada() {
		return completada;
	}
	public void setCompletada(List<Completada> completada) {
		this.completada = completada;
	}
	
	
	
	

	
	
	 
	
	
}
