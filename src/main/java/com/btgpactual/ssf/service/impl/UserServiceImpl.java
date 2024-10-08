package com.btgpactual.ssf.service.impl;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.UserDTO;
import com.btgpactual.ssf.model.entity.UserEntity;
import com.btgpactual.ssf.model.repository.UserRepository;
import com.btgpactual.ssf.service.UserService;
import com.btgpactual.ssf.util.constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public APIResponseDTO<List<UserDTO>> getUsers(int itemPerPage, int activePage) {
        APIResponseDTO<List<UserDTO>> response = new APIResponseDTO();

        final Pageable pageable = PageRequest.of(activePage, itemPerPage);
        Page<UserEntity> users = userRepository.findAll(pageable);
        try{
            if (users != null && !users.isEmpty()) {
                List<UserDTO> dtoList = new ArrayList<>();
                for(UserEntity user : users){
                    dtoList.add(setEntityToDTO(user));
                }
                response.setPageable(dtoList, constants.messages.consultGood, "200", users.getPageable());
            } else {
                response.setFailError(constants.messages.noData, "400", "vacio");
            }
        } catch (Exception e) {
            System.err.println(constants.messages.error + e);
            response.setFailError(constants.messages.error, "500", e.getMessage());
        }

        return response;
    }

    public UserDTO setEntityToDTO(UserEntity userParam){
        UserDTO dto = new UserDTO();
        dto.setId(userParam.getId());
        dto.setNombres(userParam.getNombres());
        dto.setCorreo(userParam.getCorreo());
        dto.setTelefono(userParam.getTelefono());
        dto.setMonto(userParam.getMonto());
        dto.setFcreacion(userParam.getFcreacion());
        return dto;
    }

    public UserEntity setDTOToEntity(UserDTO userParam){
        UserEntity dto = new UserEntity();
        dto.setNombres(userParam.getNombres());
        dto.setCorreo(userParam.getCorreo());
        dto.setTelefono(userParam.getTelefono());
        dto.setMonto(userParam.getMonto());
        return dto;
    }

    public APIResponseDTO<UserDTO> getUser(long id){
        APIResponseDTO<UserDTO> response = new APIResponseDTO();
        Optional<UserEntity> userEntityOptional = Optional.of(new UserEntity());
        try{
            userEntityOptional = userRepository.findById(id);
            if(userEntityOptional.isPresent()){
                UserEntity userEntity = userEntityOptional.get();
                UserDTO user = setEntityToDTO(userEntity);
                response.setResponse(user, constants.messages.consultGood, "200");
            }else {
                response.setFailError(constants.messages.noData, "400", "vacio");
            }
        } catch (Exception e) {
            System.err.println(constants.messages.error + e);
            response.setFailError(constants.messages.error, "500", e.getMessage());
        }
        return response;
    }

    public APIResponseDTO<String> saveUser(UserDTO user){
        APIResponseDTO<String> response = new APIResponseDTO<>();
        try {
            UserEntity userEntity = setDTOToEntity(user);
            if (userEntity == null) {
                response.setFailError(constants.messages.getGetResponseErrorSwitchDTOToEntity, "500", "error");
            }else{
                userRepository.save(userEntity);
                response.setSuccess(constants.messages.responseSaveUserGood, "200");
            }
        } catch (Exception e) {
            response.setFailError(constants.messages.getResponseSaveError, "500", e.getMessage());
        }
        return response;
    }
}
