package com.btgpactual.ssf.service.impl;

import com.btgpactual.ssf.model.entity.FoundsEntity;
import com.btgpactual.ssf.model.entity.UserEntity;
import com.btgpactual.ssf.model.repository.FoundsRepository;
import com.btgpactual.ssf.model.repository.UserRepository;
import com.btgpactual.ssf.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InitializerServiceImpl implements InitializerService {

    @Autowired
    private FoundsRepository foundsRepository;


    @Autowired
    private UserRepository userRepository;

    public void startInitializer(){
        foundInitizlizer();
        userInitizlizer();
    }

    public void foundInitizlizer(){
        FoundsEntity pactualRecaudadora = FoundsEntity.builder()
                .nombre("FPV_BTG_PACTUAL_RECAUDADORA")
                .montomin(75000)
                .categoria("FPV")
                .build();

        FoundsEntity pactualEcopetrol = FoundsEntity.builder()
                .nombre("FPV_BTG_PACTUAL_ECOPETROL")
                .montomin(125000)
                .categoria("FPV")
                .build();

        FoundsEntity deudaPrivada = FoundsEntity.builder()
                .nombre("DEUDAPRIVADA")
                .montomin(50000)
                .categoria("FIC")
                .build();

        FoundsEntity fdoAcciones = FoundsEntity.builder()
                .nombre("FDO-ACCIONES")
                .montomin(250000)
                .categoria("FIC")
                .build();

        FoundsEntity pactualDinamica = FoundsEntity.builder()
                .nombre("FPV_BTG_PACTUAL_DINAMICA")
                .montomin(100000)
                .categoria("FPV")
                .build();
        try {
            foundsRepository.saveAll(List.of(pactualRecaudadora, pactualEcopetrol, deudaPrivada, fdoAcciones, pactualDinamica));
        }catch (Exception e){
            System.out.println("Ha ocurrido un error..." + e);
        }
    }
    public void userInitizlizer(){

        UserEntity william = UserEntity.builder()
                .nombres("William Castano")
                .correo("williamisrael210@gmail.com")
                .telefono("3023424366")
                .monto(500000)
                .build();

        UserEntity aaron = UserEntity.builder()
                .nombres("Aaron Castano")
                .correo("aaron2017@gmail.com")
                .telefono("300212125")
                .monto(500000)
                .build();

        UserEntity xiomara = UserEntity.builder()
                .nombres("Xiomara Diaz")
                .correo("marawara08@gmail.com")
                .telefono("3046842171")
                .monto(500000)
                .build();

        try {
            userRepository.saveAll(List.of(william, aaron, xiomara));
        }catch (Exception e){
            System.out.println("Ha ocurrido un error..." + e);
        }
    }
}
