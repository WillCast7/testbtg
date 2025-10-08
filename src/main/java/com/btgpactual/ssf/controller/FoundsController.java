package com.btgpactual.ssf.controller;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.FoundDTO;
import com.btgpactual.ssf.dto.UserDTO;
import com.btgpactual.ssf.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Autor: William Castaño ;)
 * Fecha: 8/10/2025
 * Descripción:
 */

@RestController
@RequestMapping("/founds")
public class FoundsController {

    @Autowired
    FoundService foundService;

    @GetMapping(produces = "application/json")
    public APIResponseDTO<List<FoundDTO>> getUsers() {
        return foundService.getAllFounds();
    }
}
