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
@Table(name = "Presenta")
public class Presenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdPresenta")
	int pkIdPresenta;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdAventura")
    private Aventura pkIdAventura;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdCapitulo")
    private Aventura pkIdCapitulo;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdMinijuego")
    private Aventura pkIdMinijuego;
	public int getPkIdPresenta() {
		return pkIdPresenta;
	}
	public void setPkIdPresenta(int pkIdPresenta) {
		this.pkIdPresenta = pkIdPresenta;
	}
	public Aventura getPkIdAventura() {
		return pkIdAventura;
	}
	public void setPkIdAventura(Aventura pkIdAventura) {
		this.pkIdAventura = pkIdAventura;
	}
	public Aventura getPkIdCapitulo() {
		return pkIdCapitulo;
	}
	public void setPkIdCapitulo(Aventura pkIdCapitulo) {
		this.pkIdCapitulo = pkIdCapitulo;
	}
	public Aventura getPkIdMinijuego() {
		return pkIdMinijuego;
	}
	public void setPkIdMinijuego(Aventura pkIdMinijuego) {
		this.pkIdMinijuego = pkIdMinijuego;
	}
    
    
}
