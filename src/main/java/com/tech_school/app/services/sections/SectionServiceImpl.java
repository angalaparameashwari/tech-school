package com.tech_school.app.services.sections;

import com.tech_school.app.dao.repositories.CourseCommitRepository;
import com.tech_school.app.dao.repositories.CourseRepository;
import com.tech_school.app.dao.repositories.SectionCommitRepository;
import com.tech_school.app.dao.repositories.SectionRepository;
import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.Section;
import com.tech_school.app.entity.SectionCommit;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.mapper.SectionMapper;
import com.tech_school.app.services.courses.CourseService;
import com.tech_school.core.exceptions.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    SectionRepository sectionRepository;
    SectionCommitRepository sectionCommitRepository;
    SectionMapper mapper;


    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository, SectionCommitRepository sectionCommitRepository, SectionMapper mapper){

        this.sectionRepository = sectionRepository ;
        this.sectionCommitRepository = sectionCommitRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<SectionCommit> create(@Valid SectionCommit sectionCommit) {
        Optional<Section> availableCourse = sectionRepository.findByExternalId(sectionCommit.getExternalId());
        Optional<CourseCommit> availableDraftCourse = sectionCommitRepository.findByExternalId(courseCommit.getExternalId());
        if(!availableCourse.isEmpty() || availableDraftCourse.isPresent()){
            logger.info("course_already_available", "true");
            throw new GeneralException("course already available with the same id ");
        }
        logger.info("course_id", courseCommit.getExternalId());
        Optional<CourseCommit> response = Optional.of(courseCommitRepository.save(courseCommit));
        return response;
    }

}
