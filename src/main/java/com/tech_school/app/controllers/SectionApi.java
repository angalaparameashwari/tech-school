package com.tech_school.app.controllers;

import com.tech_school.app.api_models.courses.CourseApiModel;
import com.tech_school.app.api_models.courses.CreateCourseApiModel;
import com.tech_school.app.api_models.sections.CreateSectionApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.concurrent.Callable;

public interface SectionApi {

    @RequestMapping(value = "/courses",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Callable<ResponseEntity<SectionApiModel>> create(@Valid @RequestBody CreateSectionApiModel body);
}
