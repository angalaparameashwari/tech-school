package com.tech_school.app.services.courses;

import com.tech_school.app.dao.repositories.CourseCommitRepository;
import com.tech_school.app.dao.repositories.CourseRepository;
import com.tech_school.app.dao.repositories.StagedChangesRepository;
import com.tech_school.app.dao.repositories.UserRepository;
import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.StagedChanges;
import com.tech_school.app.entity.User;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.mapper.StagedChangesMapper;
import com.tech_school.app.services.users.UserService;
import com.tech_school.core.exceptions.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    CourseRepository courseRepository;
    CourseCommitRepository courseCommitRepository;
    StagedChangesRepository stagedChangesRepository;
    CourseMapper courseMapper;
    StagedChangesMapper stagedChangesMapper;


    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, CourseCommitRepository courseCommitRepository,
                             CourseMapper courseMapper, StagedChangesMapper stagedChangesMapper, StagedChangesRepository stagedChangesRepository){

        this.courseRepository = courseRepository ;
        this.courseCommitRepository = courseCommitRepository;
        this.courseMapper = courseMapper;
        this.stagedChangesRepository = stagedChangesRepository;
        this.stagedChangesMapper = stagedChangesMapper;
    }

    @Override
    public Optional<CourseCommit> create(@Valid CourseCommit courseCommit) {
        List<Course> availableCourse = courseRepository.findByGivenId(courseCommit.getExternalId());
        Optional<CourseCommit> availableDraftCourse = courseCommitRepository.findByExternalId(courseCommit.getExternalId());
        if(!availableCourse.isEmpty() || availableDraftCourse.isPresent()){
            logger.info("course_already_available", "true");
            throw new GeneralException("course already available with the same id ");
        }
        StagedChanges stagedChanges = stagedChangesMapper.stagedChanges();
        stagedChangesRepository.save(stagedChanges);
        courseCommit.setStagedChanges(stagedChanges);
        logger.info("course_id", courseCommit.getExternalId());
        Optional<CourseCommit> response = Optional.of(courseCommitRepository.save(courseCommit));
        return response;
    }

}
