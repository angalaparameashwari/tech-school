package com.tech_school.app.services.sections;

import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.SectionCommit;

import javax.validation.Valid;
import java.util.Optional;

public interface SectionService {
    Optional<SectionCommit> create(@Valid SectionCommit sectionCommit);
}
