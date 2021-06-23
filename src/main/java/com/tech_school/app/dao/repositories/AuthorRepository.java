package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.Author;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>, QuerydslPredicateExecutor<Author> {
   Optional<Author> findByExternalId(String id);
}
