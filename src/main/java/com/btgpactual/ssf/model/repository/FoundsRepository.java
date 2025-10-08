package com.btgpactual.ssf.model.repository;

import com.btgpactual.ssf.model.entity.FoundsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.List;

public interface FoundsRepository extends CrudRepository<FoundsEntity, Long>{

    @Override
    public List<FoundsEntity> findAll();
}
