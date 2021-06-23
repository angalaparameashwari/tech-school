package com.tech_school.app.services.courses;

import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CourseCommit;

import javax.validation.Valid;
import java.util.Optional;

public interface CourseService {
    Optional<CourseCommit> create(@Valid CourseCommit courseCommit);
}
