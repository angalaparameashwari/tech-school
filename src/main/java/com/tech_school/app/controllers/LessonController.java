package com.tech_school.app.controllers;

import com.tech_school.app.api_models.lessons.CreateLessonApiModel;
import com.tech_school.app.api_models.lessons.LessonApiModel;
import com.tech_school.app.mapper.LessonMapper;
import com.tech_school.app.services.lessons.LessonService;
import com.tech_school.core.exceptions.GeneralException;
import com.tech_school.core.security.RequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.Callable;

@RestController
public class LessonController implements LessonApi {
    private LessonService service;
    private LessonMapper mapper;

    @Autowired
    public LessonController(LessonService service, LessonMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Callable<ResponseEntity<LessonApiModel>> create(@Valid CreateLessonApiModel body) {
        return () -> {
            RequestDetails.setCurrentUser("Donna");
            LessonApiModel lessonApiModel = service.create(mapper.createLessonToLessonCommit(body))
                    .map(courseCommit -> mapper.lessonCommitToLessonApiModel(courseCommit))
                    .orElseThrow(() -> new GeneralException("Un expected error"));
            return ResponseEntity.status(HttpStatus.CREATED).body(lessonApiModel);
        };
    }
}
