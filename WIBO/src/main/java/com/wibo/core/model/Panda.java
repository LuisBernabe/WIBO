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
@Table(name = "Panda")
public class Panda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdPanda")
	int pkIdPanda;
	@Column(name = "enUso")
	boolean enUso;
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
	public boolean isEnUso() {
		return enUso;
	}
	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}
	public Coleccionable getPkIdColeccionable() {
		return pkIdColeccionable;
	}
	public void setPkIdColeccionable(Coleccionable pkIdColeccionable) {
		this.pkIdColeccionable = pkIdColeccionable;
	}
    
    
}
