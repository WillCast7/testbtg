package com.btgpactual.ssf.service;

import com.btgpactual.ssf.dto.FoundDTO;
import com.btgpactual.ssf.model.entity.FoundsEntity;

public interface FoundService {
    public FoundDTO setEntityToDTO(FoundsEntity user);
}
