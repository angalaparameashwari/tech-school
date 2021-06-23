package com.tech_school.app.validators;

import com.tech_school.app.dao.repositories.SectionCommitRepository;
import com.tech_school.app.dao.repositories.SectionRepository;
import com.tech_school.app.entity.Section;
import com.tech_school.app.entity.SectionCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SectionValidator {
    private SectionRepository sectionRepository;
    private SectionCommitRepository sectionCommitRepository;
    @Autowired
    public SectionValidator(SectionRepository sectionRepository,SectionCommitRepository sectionCommitRepository){
        this.sectionRepository = sectionRepository;
        this.sectionCommitRepository = sectionCommitRepository;
    }

//    public boolean isCoursePresent(SectionCommit sectionCommit){
//        Optional<Section> alreadyAvailableSection = sectionRepository.findByExternalId(sectionCommit.getExternalId());
//        if(alreadyAvailableSection.isPresent())
//            return true;
//        sectionCommitRepository.findByExternalId(sectionCommit.getExternalId());
//    }
}
