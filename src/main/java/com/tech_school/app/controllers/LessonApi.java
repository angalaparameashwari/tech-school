package com.tech_school.app.controllers;

import com.tech_school.app.api_models.lessons.CreateLessonApiModel;
import com.tech_school.app.api_models.lessons.LessonApiModel;
import com.tech_school.app.api_models.sections.CreateSectionApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.concurrent.Callable;

public interface LessonApi {

    @RequestMapping(value = "/lessons",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    Callable<ResponseEntity<LessonApiModel>> create(@Valid @RequestBody CreateLessonApiModel body);
}
