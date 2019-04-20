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
@Table(name = "Jugar")
public class Jugar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdJugar")
	int pkIdJugar;
	@Column(name = "completada")
	boolean completada;
    @ManyToOne()
	@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdJugador")
     private Jugador pkIdJugador;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdAventura")
    private Aventura pkIdAventura;
	public int getPkIdJugar() {
		return pkIdJugar;
	}
	public void setPkIdJugar(int pkIdJugar) {
		this.pkIdJugar = pkIdJugar;
	}
	public boolean isCompletada() {
		return completada;
	}
	public void setCompletada(boolean completada) {
		this.completada = completada;
	}
	public Jugador getPkIdJugador() {
		return pkIdJugador;
	}
	public void setPkIdJugador(Jugador pkIdJugador) {
		this.pkIdJugador = pkIdJugador;
	}
	public Aventura getPkIdAventura() {
		return pkIdAventura;
	}
	public void setPkIdAventura(Aventura pkIdAventura) {
		this.pkIdAventura = pkIdAventura;
	}
    
    
}
