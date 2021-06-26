package com.tech_school.app.mapper;


import com.tech_school.app.dao.repositories.AuthorRepository;
import com.tech_school.app.dao.repositories.CommitRepository;
import com.tech_school.app.entity.Author;
import com.tech_school.app.entity.Commit;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.core.security.RequestDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CommitMapper {
    AuthorRepository authorRepository;
    CommitRepository commitRepository;
    CommitMapper(AuthorRepository authorRepository,CommitRepository CommitRepository){
        this.commitRepository = CommitRepository;
        this.authorRepository = authorRepository;
    }

    public Commit createCommit(String courseId, CommitStates commitStates, String previousCommit){
        Commit commit = new Commit();
        Optional<Author> author = authorRepository.findByExternalId(RequestDetails.getCurrentUser());
        commit.setAuthor(author.get());
        commit.setExternalId(UUID.randomUUID().toString());
        commit.setCourseId(courseId);
        commit.setState(commitStates.status);
        commit.setPreviousCommit(previousCommit);
        return commitRepository.save(commit);
    }
}
