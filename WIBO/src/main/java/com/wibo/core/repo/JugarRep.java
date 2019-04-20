package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Jugar;

@Repository
public interface JugarRep extends PagingAndSortingRepository<Jugar, Integer>{
}
