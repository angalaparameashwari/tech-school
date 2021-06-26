package com.tech_school.app.validators;

import com.tech_school.app.dao.repositories.AuthorRepository;
import com.tech_school.app.dao.repositories.CommitRepository;
import com.tech_school.app.entity.Author;
import com.tech_school.app.entity.Commit;
import com.tech_school.core.security.RequestDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseValidator {
        private AuthorRepository authorRepository;

        public CourseValidator(AuthorRepository authorRepository){
            this.authorRepository = authorRepository;
        }


        public Author getAuthor(){
            Optional<Author> byState = authorRepository.findByExternalId(RequestDetails.getCurrentUser());
            return byState.orElse(null);
        }
    }

