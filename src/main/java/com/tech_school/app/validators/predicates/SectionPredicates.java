package com.tech_school.app.validators.predicates;

import com.tech_school.app.entity.SectionCommit;

import java.util.function.Predicate;

public interface SectionPredicates {
    Predicate<String> isNotNull = str -> str != null && !str.equals("");
//    Predicate<SectionCommit> isCoursePresent = sectionCommit -> sectionCommit != null && !str.equals("");

}
