package com.btgpactual.ssf.service.impl;

import com.btgpactual.ssf.dto.*;
import com.btgpactual.ssf.model.entity.FoundsEntity;
import com.btgpactual.ssf.model.entity.TransactionsEntity;
import com.btgpactual.ssf.model.entity.UserEntity;
import com.btgpactual.ssf.model.repository.FoundsRepository;
import com.btgpactual.ssf.model.repository.TransactionRepository;
import com.btgpactual.ssf.model.repository.UserRepository;
import com.btgpactual.ssf.service.FoundService;
import com.btgpactual.ssf.service.TransactionService;
import com.btgpactual.ssf.service.UserService;
import com.btgpactual.ssf.util.constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoundsRepository foundsRepository;

    @Autowired
    private UserService userService;


    private FoundService foundService;

    public APIResponseDTO<List<TransactionsDTO>> getTransactions(int itemPerPage, int activePage) {
        APIResponseDTO<List<TransactionsDTO>> response = new APIResponseDTO();

        final Pageable pageable = PageRequest.of(activePage, itemPerPage);
        Page<TransactionsEntity> transactions = transactionRepository.findAll(pageable);
        try{
            if (transactions != null && !transactions.isEmpty()) {
                List<TransactionsDTO> dtoList = new ArrayList<>();
                for(TransactionsEntity transaction : transactions){
                    dtoList.add(setEntityToDTO(transaction));
                }
                response.setPageable(dtoList, constants.messages.consultGood, "200", transactions.getPageable());
            } else {
                response.setFailError(constants.messages.noData, "400", "vacio");
            }
        } catch (Exception e) {
            System.err.println(constants.messages.error + e);
            response.setFailError(constants.messages.error, "500", e.getMessage());
        }

        return response;
    }

    public TransactionsDTO setEntityToDTO(TransactionsEntity transaction){
        UserDTO user = UserDTO.builder()
                .id(transaction.getUsuario().getId())
                .monto(transaction.getUsuario().getMonto())
                .correo(transaction.getUsuario().getCorreo())
                .nombres(transaction.getUsuario().getNombres())
                .telefono(transaction.getUsuario().getTelefono())
                .build();

        FoundDTO found = FoundDTO.builder()
                .nombre(transaction.getFondo().getNombre())
                .categoria(transaction.getFondo().getCategoria())
                .montomin(transaction.getFondo().getMontomin())
                .id(transaction.getFondo().getId())
                .build();

        TransactionsDTO dto = TransactionsDTO.builder()
                .monto(transaction.getMonto())
                .fondo(found)
                .usuario(user)
                .tipo(transaction.getTipo())
                .build();
        return dto;
    }

    public TransactionsDTO setEntityToDTOSimple(TransactionsEntity transaction){
        TransactionsDTO dto = new TransactionsDTO();

        dto.setId(transaction.getId());
        dto.setId(transaction.getId());
        dto.setMonto(transaction.getMonto());
        dto.setTipo(transaction.getTipo());
        dto.setFcreacion(transaction.getFcreacion());
        return dto;
    }

    public TransactionsEntity setDTOToEntity(TransactionDTO transactionParams){
        TransactionsEntity entity = new TransactionsEntity();
        UserEntity userEntity = new UserEntity();
        FoundsEntity foundsEntity = new FoundsEntity();

        foundsEntity.setId((long) transactionParams.getFondo());
        userEntity.setId((long) transactionParams.getUsuario());
        entity.setTipo(transactionParams.getTipo());
        entity.setMonto(transactionParams.getMonto());
        entity.setUsuario(userEntity);
        entity.setFondo(foundsEntity);
        return entity;
    }

    public APIResponseDTO<TransactionsDTO> getTransaction(long id){
        APIResponseDTO<TransactionsDTO> response = new APIResponseDTO();
        Optional<TransactionsEntity> transactionEntityOptional = Optional.of(new TransactionsEntity());
        try{
            transactionEntityOptional = transactionRepository.findById(id);
            System.out.println("transactionEntityOptional");
                TransactionsEntity transactionsEntity = transactionEntityOptional.get();
            System.out.println(transactionsEntity.getTipo());
            if(transactionEntityOptional.isPresent()){
                TransactionsDTO transaction = setEntityToDTOSimple(transactionsEntity);
                response.setResponse(transaction, constants.messages.consultGood, "200");
            }else {
                response.setFailError(constants.messages.noData, "400", "vacio");
            }
        } catch (Exception e) {
            System.err.println(constants.messages.error + e);
            response.setFailError(constants.messages.error, "500", e.getMessage());
        }
        return response;
    }

    public APIResponseDTO<String> saveTransaction(TransactionDTO transaction){
        APIResponseDTO<String> response = new APIResponseDTO<>();
        System.out.println(transaction);
        try {
            TransactionsEntity transactionsEntity = setDTOToEntity(transaction);
            Optional<FoundsEntity> foundEntityOptional = Optional.of(new FoundsEntity());
            Optional<UserEntity> userEntityOptional = Optional.of(new UserEntity());

            if (transactionsEntity == null) {
                response.setFailError(constants.messages.getGetResponseErrorSwitchDTOToEntity, "500", "error");
            }else{
                userEntityOptional = userRepository.findById((long) transaction.getUsuario());
                foundEntityOptional = foundsRepository.findById((long) transaction.getFondo());

                if(!userEntityOptional.isPresent()) {
                    response.setFailError(constants.messages.getResponseSaveError, "400", "El usuario no existe");
                    return response;
                }

                if(!foundEntityOptional.isPresent()) {
                    response.setFailError(constants.messages.getResponseSaveError, "400", "El fondo no existe");
                    return response;
                }
                    UserEntity userEntity = userEntityOptional.get();
                    FoundsEntity foundEntity = foundEntityOptional.get();

                    if(foundEntity.getMontomin() > transaction.getMonto()){
                        response.setFailError(constants.messages.getResponseSaveError, "400", constants.messages.errorlowTransaction + foundEntity.getMontomin());
                        return response;
                    }

                    if(userEntity.getMonto() < transaction.getMonto() && Objects.equals(transaction.getTipo(), constants.variables.subscription)){
                        response.setFailError(constants.messages.getResponseSaveError, "400", constants.messages.errorLowAmmount + foundEntity.getNombre());
                        return response;
                    }

                    int newAmount;
                    if(Objects.equals(transaction.getTipo(), constants.variables.subscription)){
                        newAmount = userEntity.getMonto() - transaction.getMonto();
                    }else {
                        newAmount = userEntity.getMonto() + transaction.getMonto();
                    }

                    int transactionCounter = transactionRepository.countTransactions(transaction.getMonto(),
                            transaction.getUsuario(),
                            constants.variables.subscription);

                     if(Objects.equals(transactionCounter,0) && Objects.equals(transaction.getTipo(), constants.variables.unsubscription)){
                        response.setFailError(constants.messages.getResponseSaveError, "400", constants.messages.errorUnsubscriptionForSubscription);
                        return response;
                    }
                    userRepository.updateAmount(newAmount, userEntity.getId());
                    transactionRepository.save(transactionsEntity);
            }

            response.setSuccess(constants.messages.responseSaveUserGood, "200");

        } catch (Exception e) {
            response.setFailError(constants.messages.getResponseSaveError, "400", e.getMessage());
        }
        return response;
    }
}
