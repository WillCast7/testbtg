package com.btgpactual.ssf.service;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.FoundDTO;
import com.btgpactual.ssf.model.entity.FoundsEntity;

import java.util.List;

public interface FoundService {
    public FoundDTO setEntityToDTO(FoundsEntity user);
    public APIResponseDTO<List<FoundDTO>> getAllFounds();
}
