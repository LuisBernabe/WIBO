package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Aventura;

@Repository
public interface AventuraRep extends PagingAndSortingRepository<Aventura, Integer> {
 Aventura findByNombre(String nombre);
}
