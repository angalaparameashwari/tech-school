package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.AuthorCourse;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorCourseRepository extends CrudRepository<AuthorCourse, Long>, QuerydslPredicateExecutor<AuthorCourse> {
}
