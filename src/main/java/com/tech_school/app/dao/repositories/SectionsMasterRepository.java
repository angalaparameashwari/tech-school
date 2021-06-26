package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.SectionCommit;
import com.tech_school.app.entity.SectionsMaster;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectionsMasterRepository extends CrudRepository<SectionsMaster, Long>, QuerydslPredicateExecutor<SectionsMaster> {
    Optional<SectionsMaster> findByExternalIdAndCommitId(String id, String commitId);
    Optional<SectionsMaster> findByExternalId(String id);
    List<SectionsMaster> findAllByCommitId(String commitId);
}
