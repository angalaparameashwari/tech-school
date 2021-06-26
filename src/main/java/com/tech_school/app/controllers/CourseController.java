package com.tech_school.app.controllers;

import com.tech_school.app.api_models.courses.CourseApiModel;
import com.tech_school.app.api_models.courses.CreateCourseApiModel;
import com.tech_school.app.api_models.users.CreateUserApiModel;
import com.tech_school.app.api_models.users.UserApiModel;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.services.courses.CourseService;
import com.tech_school.core.exceptions.GeneralException;
import com.tech_school.core.security.RequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.Callable;

@RestController
public class CourseController implements CourseApi {
    private CourseService service;
    private CourseMapper mapper;

    @Autowired
    public CourseController(CourseService service, CourseMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Callable<ResponseEntity<CourseApiModel>> create(@Valid CreateCourseApiModel body) {
        return () -> {
            RequestDetails.setCurrentUser(body.getAuthorId());
            CourseApiModel courseApiModel = service.create(mapper.createCourseToCourseMaster(body))
                    .map(courseMaster -> mapper.courseMasterToCourseApiModel(courseMaster))
                    .orElseThrow(() -> new GeneralException("Un expected error"));
            return ResponseEntity.status(HttpStatus.CREATED).body(courseApiModel);
        };
    }

//    @Override
//    public Callable<ResponseEntity<CourseApiModel>> retrieve(String courseId, String authorId) {
////        return () -> {
////            RequestDetails.setCurrentUser("authorId");
////            CourseApiModel courseApiModel = service.merge(courseId,authorId)
////                    .map()
////        }
//    }
}
