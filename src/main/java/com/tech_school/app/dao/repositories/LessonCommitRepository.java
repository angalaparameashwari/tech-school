package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.LessonCommit;
import com.tech_school.app.entity.SectionCommit;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonCommitRepository extends CrudRepository<LessonCommit, Long>, QuerydslPredicateExecutor<LessonCommit> {
    List<LessonCommit> findAllByCommitId(String commitId);
}
