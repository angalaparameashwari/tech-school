package com.tech_school.app.validators;

import com.tech_school.app.dao.repositories.*;
import com.tech_school.app.entity.*;
import com.tech_school.core.exceptions.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LessonValidator {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private LessonsMasterRepository lessonsMasterRepository;
    private LessonCommitRepository lessonCommitRepository;

    private SectionsMasterRepository sectionsMasterRepository;
    private SectionCommitRepository sectionCommitRepository;

    private CoursesMasterRepository coursesMasterRepository;
    private CourseCommitRepository courseCommitRepository;
    private CommitValidator commitValidator;

    @Autowired
    public LessonValidator(LessonsMasterRepository lessonsMasterRepository, LessonCommitRepository lessonCommitRepository,
                           CoursesMasterRepository coursesMasterRepository,CommitValidator commitValidator,
                           SectionsMasterRepository sectionsMasterRepository,SectionCommitRepository sectionCommitRepository,
                           CourseCommitRepository courseCommitRepository){
        this.lessonsMasterRepository = lessonsMasterRepository;
        this.lessonCommitRepository = lessonCommitRepository;
        this.coursesMasterRepository = coursesMasterRepository;
        this.commitValidator = commitValidator;
        this.sectionsMasterRepository = sectionsMasterRepository;
        this.sectionCommitRepository = sectionCommitRepository;
        this.courseCommitRepository = courseCommitRepository;
    }

    public void isCoursePresent(LessonCommit lessonCommit){
        if(!availableCourse(lessonCommit).isPresent()){
            throw new GeneralException("course not found");
        }
    }

    public Optional<CoursesMaster> availableCourse(LessonCommit lessonCommit){
        return coursesMasterRepository.findCoursesMasterByExternalId(lessonCommit.getCourseId());
    }


    public void isSectionAvailable(LessonCommit lessonCommit){
        List<SectionCommit> availableinDraft = new ArrayList<>();
        if(commitValidator.isDraftCommitAvailableForAuthor() != null) {
            availableinDraft = sectionCommitRepository.findByExternalIdAndCommitId(lessonCommit.getSectionId(), lessonCommit.getCommitId());
        }
        if(isAvailableInMaster(lessonCommit) == null && availableinDraft.isEmpty())
            throw new GeneralException("section not already present");
    }

    public SectionsMaster isAvailableInMaster(LessonCommit lessonCommit){
        Optional<SectionsMaster> availableSection = sectionsMasterRepository.findByExternalId(lessonCommit.getSectionId());
        return availableSection.orElse(null);
    }

    public SectionCommit sectionAvailableInDraftState(LessonCommit lessonCommit){
        List<SectionCommit> byGivenIdAndCommit = sectionCommitRepository.findByExternalIdAndCommitId(lessonCommit.getCourseId(),lessonCommit.getCommitId());
        if(byGivenIdAndCommit.isEmpty()){
            return null;
        }
        if(byGivenIdAndCommit.size() > 1){
            throw new GeneralException("unexpected - More than one open commit available for the author");
        }
        return byGivenIdAndCommit.get(0);
    }

    public CourseCommit courseAvailableInDraftState(LessonCommit lessonCommit){
        Optional<CourseCommit> byGivenIdAndAuthor = courseCommitRepository.findByCourseIdAndCommitId(lessonCommit.getCourseId(),lessonCommit.getCommitId());
        return byGivenIdAndAuthor.orElse(null);
    }
}
