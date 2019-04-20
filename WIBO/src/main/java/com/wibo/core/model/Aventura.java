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
@Table(name = "Aventura")
public class Aventura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdAventura")
	int pkIdAventura;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "bloqueda")
	boolean bloqueda;
	@OneToMany(mappedBy = "pkIdAventura", targetEntity=Jugar.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Jugar> jugar = new ArrayList<>();
	@OneToMany(mappedBy = "pkIdAventura", targetEntity=Capitulo.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Capitulo> Capitulo = new ArrayList<>();
	@OneToMany(mappedBy = "pkIdAventura", targetEntity=Presenta.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Presenta> presenta = new ArrayList<>();
	public int getPkIdAventura() {
		return pkIdAventura;
	}
	public void setPkIdAventura(int pkIdAventura) {
		this.pkIdAventura = pkIdAventura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isBloqueda() {
		return bloqueda;
	}
	public void setBloqueda(boolean bloqueda) {
		this.bloqueda = bloqueda;
	}
	public List<Jugar> getJugar() {
		return jugar;
	}
	public void setJugar(List<Jugar> jugar) {
		this.jugar = jugar;
	}
	public List<Capitulo> getCapitulo() {
		return Capitulo;
	}
	public void setCapitulo(List<Capitulo> capitulo) {
		Capitulo = capitulo;
	}
	public List<Presenta> getPresenta() {
		return presenta;
	}
	public void setPresenta(List<Presenta> presenta) {
		this.presenta = presenta;
	}
	
	
}
