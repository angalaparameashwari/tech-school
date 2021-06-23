package com.tech_school.app.controllers;

import com.tech_school.app.api_models.users.CreateUserApiModel;
import com.tech_school.app.api_models.users.UserApiModel;
import com.tech_school.app.services.users.UserService;
import com.tech_school.app.mapper.*;
import com.tech_school.core.exceptions.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.Callable;

@RestController
public class UserController implements UserApi {
    private UserService service;
    private UserMapper mapper;

    @Autowired
    public UserController(UserService service, UserMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Callable<ResponseEntity<UserApiModel>> create(@Valid CreateUserApiModel body) {
        return () -> {
            UserApiModel userApiModel = service.create(mapper.createApiToDbMapper(body))
                    .map(user -> mapper.dbToApiMapper(user))
                    .orElseThrow(() -> new GeneralException("Un expected error"));
            return ResponseEntity.status(HttpStatus.CREATED).body(userApiModel);
        };
    }
}
