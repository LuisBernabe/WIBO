package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Capitulo;

@Repository
public interface CapituloRep extends PagingAndSortingRepository<Capitulo, Integer>{
Capitulo findByNombre(String nombre);
}
