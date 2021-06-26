package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.LessonsMaster;
import com.tech_school.app.entity.SectionsMaster;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonsMasterRepository extends CrudRepository<LessonsMaster, Long>, QuerydslPredicateExecutor<LessonsMaster> {
    List<LessonsMaster> findAllByCommitId(String commitId);
}
