package com.tech_school.app.services

import com.tech_school.app.api_models.courses.CreateCourseApiModel
import com.tech_school.app.dao.repositories.CommitRepository
import com.tech_school.app.dao.repositories.CourseCommitRepository
import com.tech_school.app.dao.repositories.CourseRepository
import com.tech_school.app.dao.repositories.CoursesMasterRepository
import com.tech_school.app.dao.repositories.SectionCommitRepository
import com.tech_school.app.dao.repositories.SectionsMasterRepository
import com.tech_school.app.entity.CoursesMaster
import com.tech_school.app.mapper.CommitMapper
import com.tech_school.app.mapper.CourseMapper
import com.tech_school.app.mapper.SectionMapper
import com.tech_school.app.validators.CourseValidator
import spock.lang.Specification

class CourseServiceImpl extends Specification {
    def courseRepository = Mock(CourseRepository);
    def coursesMasterRepository = Mock(CoursesMasterRepository);
    def courseMapper = Mock(CourseMapper);
    def commitMapper = Mock(CommitMapper);
    def commitRepository = Mock(CommitRepository);
    def courseValidator = Mock(CourseValidator);
    def courseCommitRepository = Mock(CourseCommitRepository);
    def sectionsMasterRepository = Mock(SectionsMasterRepository);
    def sectionCommitRepository = Mock(SectionCommitRepository);
    def sectionMapper = Mock(SectionMapper);



    def courseService = new com.tech_school.app.services.courses.CourseServiceImpl(courseRepository, coursesMasterRepository,
            courseMapper, commitMapper, commitRepository, courseValidator, courseCommitRepository,
            sectionsMasterRepository, sectionCommitRepository, sectionMapper );


    def createCourseMaster = new CoursesMaster("Java_HeadFirst","Java_HeadFirst","Java_HeadFirst","Java for beginners", "first_commit","null");

    def "test create course item"() {

        when:
        courseService.create(createCourseMaster);

        then:
        1* coursesMasterRepository.findCoursesMasterByExternalId(*_) >> Optional.of(createCourseMaster);

    }
}

//public CourseServiceImpl(CourseRepository courseRepository, CoursesMasterRepository coursesMasterRepository,
//                         CourseMapper courseMapper, CommitMapper commitMapper, CommitRepository commitRepository,
//                         CourseValidator courseValidator, CourseCommitRepository courseCommitRepository,
//                         SectionsMasterRepository sectionsMasterRepository, SectionCommitRepository sectionCommitRepository,
//                         SectionMapper sectionMapper)
