package com.tech_school.app.controllers;

import com.tech_school.app.api_models.courses.CourseApiModel;
import com.tech_school.app.api_models.courses.CreateCourseApiModel;
import com.tech_school.app.api_models.users.CreateUserApiModel;
import com.tech_school.app.api_models.users.UserApiModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.concurrent.Callable;

public interface CourseApi {

    @RequestMapping(value = "/courses",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Callable<ResponseEntity<CourseApiModel>> create(@Valid @RequestBody CreateCourseApiModel body);

    @RequestMapping(value = "/courses/{id}/merge/{authorId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Callable<ResponseEntity<CourseApiModel>> merge(@PathVariable("id") String courseId,@PathVariable("authorId") String authorId);
}
