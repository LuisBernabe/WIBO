package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.MiniJuego;

@Repository
public interface MiniJuegoRep extends PagingAndSortingRepository<MiniJuego, Integer>{
MiniJuego findByNombreJuego(String nombreJuego);
}
