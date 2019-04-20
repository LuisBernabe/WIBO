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
@Table(name = "Reto")
public class Reto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdReto")
	int pkIdReto;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "descripcion")
	String descripcion;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdCompletada")
    private Completada pkIdCompletada;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdColeccionable")
    private Coleccionable pkIdColeccionable;
	public int getPkIdReto() {
		return pkIdReto;
	}
	public void setPkIdReto(int pkIdReto) {
		this.pkIdReto = pkIdReto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Completada getPkIdCompletada() {
		return pkIdCompletada;
	}
	public void setPkIdCompletada(Completada pkIdCompletada) {
		this.pkIdCompletada = pkIdCompletada;
	}
	public Coleccionable getPkIdColeccionable() {
		return pkIdColeccionable;
	}
	public void setPkIdColeccionable(Coleccionable pkIdColeccionable) {
		this.pkIdColeccionable = pkIdColeccionable;
	}
    
    
}
