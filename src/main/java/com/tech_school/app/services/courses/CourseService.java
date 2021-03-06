package com.tech_school.app.services.courses;

import com.tech_school.app.api_models.courses.CourseApiModel;
import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.CoursesMaster;

import javax.validation.Valid;
import java.util.Optional;

public interface CourseService {
    Optional<CoursesMaster> create(@Valid CoursesMaster coursesMaster);
    Optional<CourseApiModel> merge(@Valid String id, String authorId);
}
