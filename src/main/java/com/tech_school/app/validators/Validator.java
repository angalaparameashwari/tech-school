package com.tech_school.app.validators;

import com.tech_school.app.dao.repositories.CoursesMasterRepository;
import com.tech_school.app.entity.CoursesMaster;
import com.tech_school.app.entity.SectionCommit;
import com.tech_school.core.exceptions.GeneralException;

import java.util.Optional;

public class Validator {

    private CoursesMasterRepository coursesMasterRepository;

    public Validator(CoursesMasterRepository coursesMasterRepository){
        this.coursesMasterRepository = coursesMasterRepository;
    }

    public void isCoursePresent(SectionCommit sectionCommit){
        Optional<CoursesMaster> availableCourse = coursesMasterRepository.findCoursesMasterByExternalId(sectionCommit.getCourseId());
        if(!availableCourse.isPresent()){
            throw new GeneralException("course not found");
        }
    }

}
