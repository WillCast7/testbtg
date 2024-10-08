package com.btgpactual.ssf.service;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.UserDTO;
import com.btgpactual.ssf.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    public APIResponseDTO<List<UserDTO>> getUsers(int itemsPerPage, int activePage);
    public APIResponseDTO<UserDTO> getUser(long id);
    public APIResponseDTO<String> saveUser(UserDTO user);
    public UserDTO setEntityToDTO(UserEntity user);

}
