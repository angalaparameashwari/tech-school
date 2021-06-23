package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.LessonCommit;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonCommitRepository extends CrudRepository<LessonCommit, Long>, QuerydslPredicateExecutor<LessonCommit> {
}
