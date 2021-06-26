package com.tech_school.app.services.courses;

import com.tech_school.app.dao.repositories.*;
import com.tech_school.app.entity.*;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.app.mapper.CommitMapper;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.mapper.LessonMapper;
import com.tech_school.app.mapper.SectionMapper;
import com.tech_school.app.validators.CourseValidator;
import com.tech_school.core.exceptions.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    CourseRepository courseRepository;
    CourseMapper courseMapper;
    CourseValidator courseValidator;

    CoursesMasterRepository coursesMasterRepository;
    CourseCommitRepository courseCommitRepository;

    SectionsMasterRepository sectionsMasterRepository;
    SectionCommitRepository sectionCommitRepository;
    SectionMapper sectionMapper;

    LessonCommitRepository lessonCommitRepository;
    LessonsMasterRepository lessonsMasterRepository;
    LessonMapper lessonMapper;


    CommitRepository commitRepository;
    CommitMapper commitMapper;


    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, CoursesMasterRepository coursesMasterRepository,
                             CourseMapper courseMapper, CommitMapper commitMapper, CommitRepository commitRepository,
                             CourseValidator courseValidator, CourseCommitRepository courseCommitRepository,
                             SectionsMasterRepository sectionsMasterRepository, SectionCommitRepository sectionCommitRepository,
                             SectionMapper sectionMapper){

        this.courseRepository = courseRepository ;
        this.coursesMasterRepository = coursesMasterRepository;
        this.courseMapper = courseMapper;
        this.commitMapper = commitMapper;
        this.commitRepository = commitRepository;
        this.courseValidator = courseValidator;
        this.courseCommitRepository = courseCommitRepository;
        this.sectionsMasterRepository = sectionsMasterRepository;
        this.sectionCommitRepository = sectionCommitRepository;
        this.sectionMapper = sectionMapper;
    }

    @Override
    public Optional<CoursesMaster> create(@Valid CoursesMaster courseMaster) {
        Optional<Course> availableCourse = courseRepository.findByGivenId(courseMaster.getExternalId());
        Optional<CoursesMaster> unPublishedCourse = coursesMasterRepository.findCoursesMasterByExternalId(courseMaster.getExternalId());
        if(availableCourse.isPresent() || unPublishedCourse.isPresent()){
            logger.info("course_already_available", "true");
            throw new GeneralException("course already available with the same id ");
        }
        logger.info("course_id", courseMaster.getExternalId());
        Commit commit = commitMapper.createCommit(courseMaster.getExternalId(), CommitStates.MERGED, null);
        courseMaster.setCommitId(commit.getExternalId());
        return Optional.of(coursesMasterRepository.save(courseMaster));
    }

//    @Override
//    public Optional<CoursesMaster> merge(@Valid String id, String authorId) {
//        Author author = courseValidator.getAuthor();
//        Optional<Commit> byStateAndAuthor = commitRepository.findByStateAndAuthor(CommitStates.DRAFT.status,author);
//        if(!byStateAndAuthor.isPresent()){
//            throw new GeneralException("nothing to merge");
//        }
//        fillCourseDetails(byStateAndAuthor);
//        fillSections(byStateAndAuthor);
//        fillLessons(byStateAndAuthor);
//    }

    void fillLessons(Optional<Commit> byStateAndAuthor){
        Set<String> mergedSections = new HashSet<>();
        List<LessonCommit> lessonsByCommitId = lessonCommitRepository.findAllByCommitId(byStateAndAuthor.get().getExternalId());
        lessonsByCommitId.forEach(lessonCommit -> {
            LessonsMaster lessonsMaster = lessonMapper.lessonCommitToLessonMaster(lessonCommit);
            lessonsMasterRepository.save(lessonsMaster);
            mergedSections.add(lessonsMaster.getExternalId());
        });

        List<LessonsMaster> lessonsFromMaster = lessonsMasterRepository.findAllByCommitId(byStateAndAuthor.get().getPreviousCommit());
        lessonsFromMaster.forEach(lessonsMaster -> {
            if(!mergedSections.contains(lessonsMaster.getExternalId())){
                lessonsMaster.setCommitId(byStateAndAuthor.get().getExternalId());
                lessonsMasterRepository.save(lessonsMaster);
            }
        });
    }

    void fillCourseDetails(Optional<Commit> byStateAndAuthor){
        Optional<CourseCommit> courseByCommitId = courseCommitRepository.findByCommit(byStateAndAuthor.get());
        if(!courseByCommitId.isPresent()){
            throw new GeneralException("Unexpected - unable for the course in drafts");
        }
        CoursesMaster coursesMaster = courseMapper.courseCommitToCourseMaster(courseByCommitId.get(),byStateAndAuthor.get().getPreviousCommit());
        coursesMasterRepository.save(coursesMaster);
    }


    void fillSections(Optional<Commit> byStateAndAuthor){
        Set<String> mergedSections = new HashSet<>();
        fillSectionsFromCommits(byStateAndAuthor,mergedSections);
        fillSectionsFromPreviousCommit(byStateAndAuthor,mergedSections);
    }

    void fillSectionsFromCommits(Optional<Commit> byStateAndAuthor,Set<String> mergedSections){
        List<SectionCommit> sectionsByCommitId = sectionCommitRepository.findAllByCommitId(byStateAndAuthor.get().getExternalId());
        sectionsByCommitId.forEach(sectionCommit -> {
            SectionsMaster sectionsMaster = sectionMapper.sectionCommitToSectionMaster(sectionCommit);
            sectionsMasterRepository.save(sectionsMaster);
            mergedSections.add(sectionsMaster.getExternalId());
        });
    }

    void fillSectionsFromPreviousCommit(Optional<Commit> byStateAndAuthor,Set<String> mergedSections){
        List<SectionsMaster> sectionsFromMaster = sectionsMasterRepository.findAllByCommitId(byStateAndAuthor.get().getPreviousCommit());
        sectionsFromMaster.forEach(sectionsMaster -> {
            if(!mergedSections.contains(sectionsMaster.getExternalId())){
                sectionsMaster.setCommitId(byStateAndAuthor.get().getExternalId());
                sectionsMasterRepository.save(sectionsMaster);
            }
        });
    }

}
