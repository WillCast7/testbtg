package com.btgpactual.ssf.service;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.SimpleTransactionDTO;
import com.btgpactual.ssf.dto.TransactionsDTO;
import com.btgpactual.ssf.dto.UserDTO;

import java.util.List;

public interface TransactionService {
    public APIResponseDTO<List<TransactionsDTO>> getTransactions(int itemPerPage, int activePage);
    public APIResponseDTO<TransactionsDTO> getTransaction(long id);
    public APIResponseDTO<String> saveTransaction(TransactionsDTO transaction);
}
