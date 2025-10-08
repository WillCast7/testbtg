package com.btgpactual.ssf.controller;

import com.btgpactual.ssf.dto.*;
import com.btgpactual.ssf.service.TransactionService;
import com.btgpactual.ssf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class transactionsControllers {
    @Autowired
    private TransactionService transactionService;

    @GetMapping(produces = "application/json")
    public APIResponseDTO<List<TransactionsDTO>> getTransaction(@RequestParam(defaultValue = "10") int itemsPerPage,
                                                          @RequestParam(defaultValue = "0") int activePage) {
        return transactionService.getTransactions(itemsPerPage, activePage);
    }

    @GetMapping( "/{id}")
    public APIResponseDTO<TransactionsDTO> getTransaction(@PathVariable Long id) {
        return transactionService.getTransaction(id);
    }

    @PostMapping(produces = "application/json")
    public APIResponseDTO postTransaction(@RequestBody TransactionDTO transaction) {
        System.out.println("working?");
        return transactionService.saveTransaction(transaction);
    }
}
