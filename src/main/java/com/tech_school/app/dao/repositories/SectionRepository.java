package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.Section;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long>, QuerydslPredicateExecutor<Section> {
    Optional<Section> findByExternalId(String id);
}
