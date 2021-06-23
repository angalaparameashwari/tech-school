package com.tech_school.app.controllers;

import com.tech_school.app.api_models.users.CreateUserApiModel;
import com.tech_school.app.api_models.users.UserApiModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.concurrent.Callable;

public interface UserApi {

    @RequestMapping(value = "/users",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Callable<ResponseEntity<UserApiModel>> create(@Valid @RequestBody CreateUserApiModel body);
}
