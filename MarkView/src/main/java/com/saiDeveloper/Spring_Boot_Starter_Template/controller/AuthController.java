package com.saiDeveloper.Spring_Boot_Starter_Template.controller;


import com.saiDeveloper.Spring_Boot_Starter_Template.exception.UserException;
import com.saiDeveloper.Spring_Boot_Starter_Template.request.UserLoginRequest;
import com.saiDeveloper.Spring_Boot_Starter_Template.request.UserRegisterRequest;
import com.saiDeveloper.Spring_Boot_Starter_Template.response.AuthResponse;
import com.saiDeveloper.Spring_Boot_Starter_Template.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody @Valid UserRegisterRequest user) throws UserException {
        log.info("Registering user: {}", user);
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid UserLoginRequest user) throws UserException {
        log.info("Logging in user: {}", user);
        return service.login(user);
    }
}
