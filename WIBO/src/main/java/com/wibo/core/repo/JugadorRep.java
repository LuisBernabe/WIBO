package com.wibo.core.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Jugador;

@Repository
public interface JugadorRep extends PagingAndSortingRepository<Jugador, Integer>{
	List<Jugador> findByNombre(String nombre);
}
