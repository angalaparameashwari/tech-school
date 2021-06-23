package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.UserCourse;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends CrudRepository<UserCourse, Long>, QuerydslPredicateExecutor<UserCourse> {
}
