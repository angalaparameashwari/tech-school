package com.tech_school.app.validators;

import com.tech_school.app.dao.repositories.AuthorRepository;
import com.tech_school.app.dao.repositories.CommitRepository;
import com.tech_school.app.entity.Commit;
import com.tech_school.core.security.RequestDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommitValidator {
    private CommitRepository commitRepository;
    private AuthorRepository authorRepository;
    public CommitValidator(CommitRepository commitRepository, AuthorRepository authorRepository){
        this.commitRepository = commitRepository;
        this.authorRepository = authorRepository;
    }

   public Commit isDraftCommitAvailableForAuthor(){
       Optional<Commit> byState =commitRepository.findByStateAndAuthor(100,  authorRepository.findByExternalId(RequestDetails.getCurrentUser()).get());
//        commitRepository.findByStateAndAuthor(100, RequestDetails.getCurrentUser());
       return byState.orElse(null);
   }

    public Commit getAuthorsLastetMerge(){
        List<Commit> byState =commitRepository.findFirstByAuthorOrderByUpdatedAtDesc(authorRepository.findByExternalId(RequestDetails.getCurrentUser()).get());
//        return byState.orElse(null);
        return new Commit();
    }

    public Commit getByCommitId(String commitId){
        Optional<Commit> byState =commitRepository.findByExternalId(commitId);
        return byState.orElse(null);
    }
}
