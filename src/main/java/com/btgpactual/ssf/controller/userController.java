package com.btgpactual.ssf.controller;

import com.btgpactual.ssf.dto.APIResponseDTO;
import com.btgpactual.ssf.dto.UserDTO;
import com.btgpactual.ssf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    public APIResponseDTO<List<UserDTO>> getUsers(@RequestParam(defaultValue = "10") int itemsPerPage,
                                                @RequestParam(defaultValue = "0") int activePage) {
        return userService.getUsers(itemsPerPage, activePage);
    }

    @GetMapping( "/{id}")
    public APIResponseDTO<UserDTO> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public APIResponseDTO postUsers(@Valid @RequestBody UserDTO user) {
        return userService.saveUser(user);
    }

//    @PutMapping( "/{id}")
//    public APIResponseDTO putUsers(@Valid @RequestBody UserDTO user, @PathVariable Long id) {
//        return userService.updateUser(user, id);
//    }
}
