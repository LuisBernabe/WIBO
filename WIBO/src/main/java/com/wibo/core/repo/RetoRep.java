package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Reto;

@Repository
public interface RetoRep extends PagingAndSortingRepository<Reto, Integer>{
Reto findByNombre(String nombre);
}
