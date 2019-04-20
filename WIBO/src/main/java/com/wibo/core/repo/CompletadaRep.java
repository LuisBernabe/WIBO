package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Completada;

@Repository
public interface CompletadaRep extends PagingAndSortingRepository<Completada, Integer>{
}
