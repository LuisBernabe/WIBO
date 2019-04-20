package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Tesoro;

@Repository
public interface TesoroRep extends PagingAndSortingRepository<Tesoro, Integer>{
Tesoro findByNombre(String nombre);
}
