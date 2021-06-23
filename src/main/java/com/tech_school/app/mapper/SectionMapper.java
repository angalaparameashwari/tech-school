package com.tech_school.app.mapper;

import com.tech_school.app.api_models.sections.CreateSectionApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
import com.tech_school.app.entity.SectionCommit;
import com.tech_school.app.enums.CommitStates;
import org.springframework.stereotype.Component;

@Component
public class SectionMapper {

     public SectionApiModel sectionCommitToSectionApiModel(SectionCommit sectionCommit){
         SectionApiModel apiModel = new SectionApiModel();
         apiModel.setId(sectionCommit.getExternalId());
         apiModel.setDescription(sectionCommit.getDescription());
         apiModel.setTitle(sectionCommit.getTitle());
         apiModel.setState(CommitStates.name(sectionCommit.getState()));
         return apiModel;
    }

    public SectionCommit createSectionToSectionCommit(CreateSectionApiModel createSectionApiModel){
        SectionCommit sectionCommit = new SectionCommit();
        sectionCommit.setDescription(createSectionApiModel.getDescription());
        sectionCommit.setTitle(createSectionApiModel.getTitle());
        sectionCommit.setState(CommitStates.DRAFT.status);
        return sectionCommit;
    }
}
