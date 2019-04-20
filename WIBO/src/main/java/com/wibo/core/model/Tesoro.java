package com.wibo.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Tesoro")
public class Tesoro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdPanda")
	int pkIdPanda;
	@Column(name = "descripcion")
	String descripcion;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdColeccionable")
    private Coleccionable pkIdColeccionable;
	public int getPkIdPanda() {
		return pkIdPanda;
	}
	public void setPkIdPanda(int pkIdPanda) {
		this.pkIdPanda = pkIdPanda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Coleccionable getPkIdColeccionable() {
		return pkIdColeccionable;
	}
	public void setPkIdColeccionable(Coleccionable pkIdColeccionable) {
		this.pkIdColeccionable = pkIdColeccionable;
	}
    
    
}
