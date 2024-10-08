package com.btgpactual.ssf.model.repository;

import com.btgpactual.ssf.model.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, ListPagingAndSortingRepository<UserEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u SET u.nombres = :nombre, u.correo = :correo, u.telefono = :telefono, u.monto = :monto WHERE u.id = :id")
    void updateUser(@Param("nombre") String nombre,
                    @Param("correo") String correo,
                    @Param("telefono") String telefono,
                    @Param("monto") int monto,
                    @Param("id") long id);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u SET u.monto = :monto WHERE u.id = :id")
    void updateAmount(int monto, long id);
}
