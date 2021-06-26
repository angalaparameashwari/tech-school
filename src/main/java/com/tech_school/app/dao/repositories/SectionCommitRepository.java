package com.tech_school.app.dao.repositories;

import com.tech_school.app.entity.SectionCommit;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectionCommitRepository extends CrudRepository<SectionCommit, Long>, QuerydslPredicateExecutor<SectionCommit> {
    List<SectionCommit> findByExternalId(String id);
    List<SectionCommit> findByExternalIdAndCommitIdAndState(String id, String commitId, String state);
    List<SectionCommit> findByExternalIdAndCommitId(String id, String commitId);
    List<SectionCommit> findAllByCommitId(String commitId);
}
