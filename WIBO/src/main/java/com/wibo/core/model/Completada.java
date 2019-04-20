package com.wibo.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Completada")
public class Completada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdCompletada")
	int pkIdCompletada;
    @ManyToOne()
	@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdJugador")
     private Jugador pkIdJugador;
	@OneToMany(mappedBy = "pkIdCompletada", targetEntity=Reto.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Reto> reto = new ArrayList<>();
	public int getPkIdCompletada() {
		return pkIdCompletada;
	}
	public void setPkIdCompletada(int pkIdCompletada) {
		this.pkIdCompletada = pkIdCompletada;
	}
	public Jugador getPkIdJugador() {
		return pkIdJugador;
	}
	public void setPkIdJugador(Jugador pkIdJugador) {
		this.pkIdJugador = pkIdJugador;
	}
	public List<Reto> getReto() {
		return reto;
	}
	public void setReto(List<Reto> reto) {
		this.reto = reto;
	}
	
	
}
