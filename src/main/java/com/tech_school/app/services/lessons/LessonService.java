package com.tech_school.app.services.lessons;

import com.tech_school.app.entity.LessonCommit;
import com.tech_school.app.entity.SectionCommit;

import javax.validation.Valid;
import java.util.Optional;

public interface LessonService {
    Optional<LessonCommit> create(@Valid LessonCommit lessonCommit);
}
