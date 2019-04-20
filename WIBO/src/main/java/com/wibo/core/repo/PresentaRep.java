package com.wibo.core.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wibo.core.model.Presenta;

@Repository
public interface PresentaRep extends PagingAndSortingRepository<Presenta, Integer>{

}
