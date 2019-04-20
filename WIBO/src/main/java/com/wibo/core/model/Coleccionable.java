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
@Table(name = "Coleccionable")
public class Coleccionable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdColeccionable")
	int pkIdColeccionable;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "img")
	String img;
	@OneToMany(mappedBy = "pkIdColeccionable", targetEntity=Reto.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Reto> reto = new ArrayList<>();
	@OneToMany(mappedBy = "pkIdColeccionable", targetEntity=Panda.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Panda> panda = new ArrayList<>();
	@OneToMany(mappedBy = "pkIdColeccionable", targetEntity=Tesoro.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Tesoro> tesoro = new ArrayList<>();
	public int getPkIdColeccionable() {
		return pkIdColeccionable;
	}
	public void setPkIdColeccionable(int pkIdColeccionable) {
		this.pkIdColeccionable = pkIdColeccionable;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<Reto> getReto() {
		return reto;
	}
	public void setReto(List<Reto> reto) {
		this.reto = reto;
	}
	public List<Panda> getPanda() {
		return panda;
	}
	public void setPanda(List<Panda> panda) {
		this.panda = panda;
	}
	public List<Tesoro> getTesoro() {
		return tesoro;
	}
	public void setTesoro(List<Tesoro> tesoro) {
		this.tesoro = tesoro;
	}
	
	
}
