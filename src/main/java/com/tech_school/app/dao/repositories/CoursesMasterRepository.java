package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CoursesMaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursesMasterRepository extends CrudRepository<CoursesMaster, Long>, QuerydslPredicateExecutor<CoursesMaster> {
        Optional<CoursesMaster> findCoursesMasterByExternalId(String id);
}
