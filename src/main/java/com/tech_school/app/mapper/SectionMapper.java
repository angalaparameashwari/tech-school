package com.tech_school.app.mapper;

import com.tech_school.app.api_models.sections.CreateSectionApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
import com.tech_school.app.dao.repositories.CommitRepository;
import com.tech_school.app.entity.*;
import com.tech_school.app.enums.ChangeType;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.app.validators.SectionValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SectionMapper {
    private CommitRepository commitRepository;
    private SectionValidator validator;

    public SectionMapper(CommitRepository commitRepository, SectionValidator validator){
        this.commitRepository = commitRepository;
        this.validator = validator;
    }

     public SectionApiModel sectionCommitToSectionApiModel(SectionCommit sectionCommit){
         SectionApiModel apiModel = new SectionApiModel();
         apiModel.setId(sectionCommit.getSectionId());
         apiModel.setCourse_id(sectionCommit.getCourseId());
         apiModel.setDescription(sectionCommit.getDescription());
         apiModel.setTitle(sectionCommit.getTitle());
         return apiModel;
    }

    public SectionCommit createSectionToSectionCommit(CreateSectionApiModel createSectionApiModel){
        SectionCommit sectionCommit = new SectionCommit();
        sectionCommit.setSectionId(createSectionApiModel.getId());
        sectionCommit.setDescription(createSectionApiModel.getDescription());
        sectionCommit.setTitle(createSectionApiModel.getTitle());
        sectionCommit.setCourseId(createSectionApiModel.getCourseId());
        sectionCommit.setState(ChangeType.ADDED.status);
        sectionCommit.setCourseId(createSectionApiModel.getCourseId());
        return sectionCommit;
    }

    public SectionsMaster sectionCommitToSectionMaster(SectionCommit sectionCommit){
        SectionsMaster sectionsMaster = new SectionsMaster();
        sectionsMaster.setExternalId(sectionCommit.getSectionId());
        sectionsMaster.setCourseId(sectionCommit.getCourseId());
        sectionsMaster.setDescription(sectionCommit.getDescription());
        sectionsMaster.setTitle(sectionCommit.getTitle());
        sectionsMaster.setCommitId(sectionCommit.getCommitId());
        return sectionsMaster;
    }

}
