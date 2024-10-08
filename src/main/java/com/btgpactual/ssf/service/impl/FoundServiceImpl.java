package com.btgpactual.ssf.service.impl;

import com.btgpactual.ssf.dto.FoundDTO;
import com.btgpactual.ssf.dto.UserDTO;
import com.btgpactual.ssf.model.entity.FoundsEntity;
import com.btgpactual.ssf.model.entity.UserEntity;
import com.btgpactual.ssf.service.FoundService;

public class FoundServiceImpl implements FoundService {
    public FoundDTO setEntityToDTO(FoundsEntity foundParam){
        FoundDTO dto = new FoundDTO();
        dto.setId(foundParam.getId());
        dto.setCategoria(foundParam.getCategoria());
        dto.setNombre(foundParam.getNombre());
        dto.setMontomin(foundParam.getMontomin());
        return dto;
    }
}
