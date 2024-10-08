package com.btgpactual.ssf.model.repository;

import com.btgpactual.ssf.model.entity.FoundsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface FoundsRepository extends CrudRepository<FoundsEntity, Long>, ListPagingAndSortingRepository<FoundsEntity, Long> {
}
