package com.tech_school.app.dao.repositories;


import com.tech_school.app.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User> {
    Optional<User> findByExternalId(String handle);

    @Query(value = "select * From Users u where u.external_id = :id", nativeQuery=true)
    Optional<User> findByGivenId(String id);
}
