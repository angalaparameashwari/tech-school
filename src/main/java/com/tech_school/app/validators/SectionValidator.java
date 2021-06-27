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
public class SectionValidator {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private SectionsMasterRepository sectionsMasterRepository;
    private SectionCommitRepository sectionCommitRepository;

    private CoursesMasterRepository coursesMasterRepository;
    private CourseCommitRepository courseCommitRepository;

    private CommitValidator commitValidator;

    @Autowired
    public SectionValidator(SectionsMasterRepository sectionsMasterRepository, SectionCommitRepository sectionCommitRepository,
                            CoursesMasterRepository coursesMasterRepository,CommitValidator commitValidator,
                            CourseCommitRepository courseCommitRepository){
        this.sectionsMasterRepository = sectionsMasterRepository;
        this.sectionCommitRepository = sectionCommitRepository;
        this.coursesMasterRepository = coursesMasterRepository;
        this.courseCommitRepository = courseCommitRepository;
        this.commitValidator = commitValidator;
    }

    public void isCoursePresent(SectionCommit sectionCommit){
        if(!availableCourse(sectionCommit).isPresent()){
            throw new GeneralException("course not found");
        }
    }

    public Optional<CoursesMaster> availableCourse(SectionCommit sectionCommit){
       return coursesMasterRepository.findCoursesMasterByExternalId(sectionCommit.getCourseId());
    }

    public CourseCommit courseAvailableInDraftState(SectionCommit sectionCommit){
        Optional<CourseCommit> byGivenIdAndAuthor = courseCommitRepository.findByCourseIdAndCommitId(sectionCommit.getCourseId(), sectionCommit.getCommitId());
        return byGivenIdAndAuthor.orElse(null);
    }

    public void isSectionAlreadyAvailable(SectionCommit sectionCommit){
        Optional<SectionsMaster> availableSection = sectionsMasterRepository.findByExternalId(sectionCommit.getSectionId());
        List<SectionCommit> availableinDraft = new ArrayList<>();
        if(commitValidator.isDraftCommitAvailableForAuthor() != null) {
            availableinDraft = sectionCommitRepository.findByExternalIdAndCommitId(sectionCommit.getSectionId(), sectionCommit.getCommitId());
        }
        if(availableSection.isPresent() || !availableinDraft.isEmpty())
            throw new GeneralException("section id already present");
    }

    public SectionCommit sectionAvailableInDraftState(SectionCommit sectionCommit){
        List<SectionCommit> byGivenIdAndCommit = sectionCommitRepository.findByExternalIdAndCommitId(sectionCommit.getCourseId(),sectionCommit.getCommitId());
        if(byGivenIdAndCommit.isEmpty()){
            return null;
        }
        if(byGivenIdAndCommit.size() > 1){
            throw new GeneralException("unexpected - More than one open commit available for the author");
        }
        return byGivenIdAndCommit.get(0);
    }
}
