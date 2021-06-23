package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.Commit;
import com.tech_school.app.entity.StagedChanges;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagedChangesRepository extends CrudRepository<StagedChanges, Long>, QuerydslPredicateExecutor<StagedChanges> {
}
