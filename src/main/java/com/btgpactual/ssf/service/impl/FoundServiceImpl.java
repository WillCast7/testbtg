package com.btgpactual.ssf.service.impl;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.FoundDTO;
import com.btgpactual.ssf.dto.TransactionsDTO;
import com.btgpactual.ssf.dto.UserDTO;
import com.btgpactual.ssf.model.entity.FoundsEntity;
import com.btgpactual.ssf.model.entity.UserEntity;
import com.btgpactual.ssf.model.repository.FoundsRepository;
import com.btgpactual.ssf.service.FoundService;
import com.btgpactual.ssf.util.constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoundServiceImpl implements FoundService {

    @Autowired
    FoundsRepository foundsRepository;

    public FoundDTO setEntityToDTO(FoundsEntity foundParam){
        return FoundDTO.builder()
                .id(foundParam.getId())
                .categoria(foundParam.getCategoria())
                .nombre(foundParam.getNombre())
                .fcreacion(foundParam.getFcreacion())
                .montomin(foundParam.getMontomin())
                .fedicion(foundParam.getFedicion())
                .build();
    }

    public APIResponseDTO<List<FoundDTO>> getAllFounds(){
        APIResponseDTO<List<FoundDTO>> response = new APIResponseDTO();
        List<FoundsEntity> founds = foundsRepository.findAll();

        response.setResponse(
        founds.stream().map(this::setEntityToDTO)
                .collect(Collectors.toList()), constants.messages.consultGood, "200");

        return response;
    }
}
