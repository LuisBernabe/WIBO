package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Panda;

@Repository
public interface PandaRep extends PagingAndSortingRepository<Panda, Integer>{
Panda findByNombre(String nombre);
}
