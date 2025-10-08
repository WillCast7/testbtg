package com.btgpactual.ssf.service;

import com.btgpactual.ssf.dto.*;

import java.util.List;

public interface TransactionService {
    public APIResponseDTO<List<TransactionsDTO>> getTransactions(int itemPerPage, int activePage);
    public APIResponseDTO<TransactionsDTO> getTransaction(long id);
    public APIResponseDTO<String> saveTransaction(TransactionDTO transaction);
}
