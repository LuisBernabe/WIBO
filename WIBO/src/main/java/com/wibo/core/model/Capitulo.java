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
@Table(name = "Capitulo")
public class Capitulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkIdCapitulo")
	int pkIdCapitulo;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "paginas")
	int paginas;
	@Column(name = "completado")
	boolean completado;
	@Column(name = "categoria")
	String categoria;
    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="pkIdAventura")
    private Aventura pkIdAventura;
	@OneToMany(mappedBy = "pkIdCapitulo", targetEntity=Presenta.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Presenta> presenta = new ArrayList<>();
	public int getPkIdCapitulo() {
		return pkIdCapitulo;
	}
	public void setPkIdCapitulo(int pkIdCapitulo) {
		this.pkIdCapitulo = pkIdCapitulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public boolean isCompletado() {
		return completado;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Aventura getPkIdAventura() {
		return pkIdAventura;
	}
	public void setPkIdAventura(Aventura pkIdAventura) {
		this.pkIdAventura = pkIdAventura;
	}
	public List<Presenta> getPresenta() {
		return presenta;
	}
	public void setPresenta(List<Presenta> presenta) {
		this.presenta = presenta;
	}

	
}
