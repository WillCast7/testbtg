package com.btgpactual.ssf.model.repository;

import com.btgpactual.ssf.model.entity.TransactionsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionsEntity, Long>, ListPagingAndSortingRepository<TransactionsEntity, Long> {
    @Transactional
    @Query("SELECT COUNT(te) FROM TransactionsEntity te WHERE te.monto = :monto AND te.usuario.id = :id AND te.tipo = :tipo")
    int countTransactions(int monto, long id, String tipo);
}
