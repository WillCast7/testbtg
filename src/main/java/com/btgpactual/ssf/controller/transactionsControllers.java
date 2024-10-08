package com.btgpactual.ssf.controller;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.TransactionsDTO;
import com.btgpactual.ssf.dto.UserDTO;
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

    @PostMapping
    public APIResponseDTO postTransaction(@Valid @RequestBody TransactionsDTO transaction) {
        return transactionService.saveTransaction(transaction);
    }
}
