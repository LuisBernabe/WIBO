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
@Table(name = "MiniJuego")
public class MiniJuego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdMinijuego")
	int pkIdMinijuego;
	@Column(name = "puntaje")
	int puntaje;
	@Column(name = "nombreJuego")
	String nombreJuego;
	@OneToMany(mappedBy = "pkIdMinijuego", targetEntity=Presenta.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Presenta> presenta = new ArrayList<>();
	public int getPkIdMinijuego() {
		return pkIdMinijuego;
	}
	public void setPkIdMinijuego(int pkIdMinijuego) {
		this.pkIdMinijuego = pkIdMinijuego;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getNombreJuego() {
		return nombreJuego;
	}
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}
	public List<Presenta> getPresenta() {
		return presenta;
	}
	public void setPresenta(List<Presenta> presenta) {
		this.presenta = presenta;
	}
	
	
}
