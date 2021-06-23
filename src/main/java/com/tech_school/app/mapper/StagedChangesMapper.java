package com.tech_school.app.mapper;

import com.tech_school.app.dao.repositories.AuthorRepository;
import com.tech_school.app.entity.StagedChanges;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.core.security.RequestDetails;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StagedChangesMapper {
    AuthorRepository authorRepository;

    public StagedChangesMapper(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }


    public StagedChanges stagedChanges(){
        StagedChanges stagedChanges = new StagedChanges();
        stagedChanges.setExternalId(UUID.randomUUID().toString());
        stagedChanges.setAuthor(authorRepository.findByExternalId(RequestDetails.getCurrentUser()).get());
        stagedChanges.setState(CommitStates.DRAFT.status);
        return stagedChanges;
    }


}
