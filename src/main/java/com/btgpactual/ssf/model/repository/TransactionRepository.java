package com.btgpactual.ssf.model.repository;

import com.btgpactual.ssf.dto.SimpleTransactionDTO;
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


    @Transactional
    @Query("SELECT us.nombres, tr.tipo, tr.monto, us.correo, us.telefono, fnd.categoria, fnd.nombre FROM TransactionsEntity tr\n" +
            "    INNER JOIN UserEntity us \n" +
            "    ON us.id = tr.usuario.id \n" +
            "    INNER JOIN FoundsEntity fnd\n" +
            "    ON fnd.id = tr.fondo.id \n" +
            "    WHERE tr.id= :id")
    TransactionsEntity simpleTransaction(long id);



}
