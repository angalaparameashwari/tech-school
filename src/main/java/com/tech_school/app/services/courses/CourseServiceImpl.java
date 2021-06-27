package com.tech_school.app.services.courses;

import com.tech_school.app.api_models.courses.CourseApiModel;
import com.tech_school.app.api_models.lessons.LessonApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
import com.tech_school.app.controllers.SectionApi;
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
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public Optional<CourseApiModel> merge(@Valid String id, String authorId) {
        Author author = courseValidator.getAuthor();
        Optional<Commit> byStateAndAuthor = commitRepository.findByStateAndAuthor(CommitStates.DRAFT.status,author);
        if(!byStateAndAuthor.isPresent()){
            throw new GeneralException("nothing to merge");
        }
        CoursesMaster coursesMaster = fillCourseDetails(byStateAndAuthor);
        List<SectionsMaster> sectionsMasters = fillSections(byStateAndAuthor);
        List<LessonsMaster> lessonsMasters = fillLessons(byStateAndAuthor);
        List<LessonApiModel> lessonApiModels = new ArrayList<>();
        lessonsMasters.stream().forEach(lessonMaster -> {
            lessonApiModels.add(lessonMapper.lessonCommitToLessonApiModel(lessonMaster));
        });
        List<SectionApiModel> sectionApiModels = new ArrayList<>();
        sectionsMasters.stream().forEach(sectionsMaster -> {
            sectionApiModels.add(sectionMapper.sectionsMasterToSectionApiModel(sectionsMaster,filterBasedOnSectionId(sectionsMaster.getExternalId(),lessonApiModels)));
        });
        return Optional.of(courseMapper.courseMasterToCourseApiModel(coursesMaster,sectionApiModels));
    }

    private List<LessonApiModel> filterBasedOnSectionId(String sectionId, List<LessonApiModel> lessonApiModels){
        return lessonApiModels.stream().filter(lessonApiModel -> lessonApiModel.getSectionId().equals(sectionId)).collect(Collectors.toList());
    }

    List<LessonsMaster> fillLessons(Optional<Commit> byStateAndAuthor){
        Set<String> mergedSections = new HashSet<>();
        List<LessonsMaster> lessonsMasters = new ArrayList<>();
        List<LessonCommit> lessonsByCommitId = lessonCommitRepository.findAllByCommitId(byStateAndAuthor.get().getExternalId());
        lessonsByCommitId.forEach(lessonCommit -> {
            LessonsMaster lessonsMaster = lessonMapper.lessonCommitToLessonMaster(lessonCommit);
            lessonsMasters.add(lessonsMasterRepository.save(lessonsMaster));
            mergedSections.add(lessonsMaster.getExternalId());
        });

        List<LessonsMaster> lessonsFromMaster = lessonsMasterRepository.findAllByCommitId(byStateAndAuthor.get().getPreviousCommit());
        lessonsFromMaster.forEach(lessonsMaster -> {
            if(!mergedSections.contains(lessonsMaster.getExternalId())){
                lessonsMaster.setCommitId(byStateAndAuthor.get().getExternalId());
                lessonsMasters.add(lessonsMasterRepository.save(lessonsMaster));
            }
        });
        return lessonsMasters;
    }

    CoursesMaster fillCourseDetails(Optional<Commit> byStateAndAuthor){
        Optional<CourseCommit> courseByCommitId = courseCommitRepository.findByCommitId(byStateAndAuthor.get().getExternalId());
        if(!courseByCommitId.isPresent()){
            throw new GeneralException("Unexpected - unable to find drafts for this course");
        }
        CoursesMaster coursesMaster = courseMapper.courseCommitToCourseMaster(courseByCommitId.get(),byStateAndAuthor.get().getPreviousCommit());
        return coursesMasterRepository.save(coursesMaster);
    }


    List<SectionsMaster> fillSections(Optional<Commit> byStateAndAuthor){
        Set<String> mergedSections = new HashSet<>();
        List<SectionsMaster> sectionsMasters = new ArrayList<>();
        fillSectionsFromCommits(byStateAndAuthor,mergedSections,sectionsMasters);
        fillSectionsFromPreviousCommit(byStateAndAuthor,mergedSections,sectionsMasters);
        return sectionsMasters;
    }

    void fillSectionsFromCommits(Optional<Commit> byStateAndAuthor,Set<String> mergedSections, List<SectionsMaster> sectionsMasters){
        List<SectionCommit> sectionsByCommitId = sectionCommitRepository.findAllByCommitId(byStateAndAuthor.get().getExternalId());
        sectionsByCommitId.forEach(sectionCommit -> {
            SectionsMaster sectionsMaster = sectionMapper.sectionCommitToSectionMaster(sectionCommit);
            sectionsMasters.add(sectionsMasterRepository.save(sectionsMaster));
            mergedSections.add(sectionsMaster.getExternalId());
        });
    }

    void fillSectionsFromPreviousCommit(Optional<Commit> byStateAndAuthor,Set<String> mergedSections, List<SectionsMaster> sectionsMasters){
        List<SectionsMaster> sectionsFromMaster = sectionsMasterRepository.findAllByCommitId(byStateAndAuthor.get().getPreviousCommit());
        sectionsFromMaster.forEach(sectionsMaster -> {
            if(!mergedSections.contains(sectionsMaster.getExternalId())){
                sectionsMaster.setCommitId(byStateAndAuthor.get().getExternalId());
                sectionsMasters.add(sectionsMasterRepository.save(sectionsMaster));
            }
        });
    }

}
