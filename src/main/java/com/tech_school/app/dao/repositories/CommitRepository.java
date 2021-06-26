package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.Author;
import com.tech_school.app.entity.Commit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommitRepository extends CrudRepository<Commit, Long>, QuerydslPredicateExecutor<Commit> {
    Optional<Commit> findByState(int state);

    Optional<Commit> findByStateAndAuthor(int state, Author author);

    Optional<Commit> findByExternalId(String id);

    Optional<Commit> findFirstByAuthorOrderByUpdatedAtDesc(Author author);

    List<Commit> findByAuthorOrderByUpdatedAtDesc(Author author);

}
