package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, QuerydslPredicateExecutor<Course> {
        @Query(value = "select * From Courses where external_id = ?1", nativeQuery=true)
        Optional<Course> findByGivenId(String id);

}
