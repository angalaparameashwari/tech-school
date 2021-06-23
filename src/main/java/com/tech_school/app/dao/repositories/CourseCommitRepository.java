package com.tech_school.app.dao.repositories;

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
    @Query(value = "select * From Course_commits where external_id = ?1 and author_id = ?2 and state in (100,200) order by updated_at desc", nativeQuery=true)
    List<Course> findByGivenIdAndAuthor(String id, long authorId);
}
