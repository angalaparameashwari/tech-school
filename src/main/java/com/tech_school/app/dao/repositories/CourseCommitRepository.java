package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.Commit;
import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseCommitRepository extends CrudRepository<CourseCommit, Long>, QuerydslPredicateExecutor<CourseCommit> {
    Optional<CourseCommit> findByExternalId(String handle);
    Optional<CourseCommit> findByCourseIdAndCommit(String id, Commit commit);
    Optional<CourseCommit> findByCommit(Commit commit);
}
