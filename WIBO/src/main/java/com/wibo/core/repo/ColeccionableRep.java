package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Coleccionable;

@Repository
public interface ColeccionableRep extends PagingAndSortingRepository<Coleccionable, Integer>{
Coleccionable findByNombre(String nombre);
}
