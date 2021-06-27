package com.tech_school.app.mapper;

import com.tech_school.app.api_models.lessons.CreateLessonApiModel;
import com.tech_school.app.api_models.lessons.LessonApiModel;
import com.tech_school.app.dao.repositories.CommitRepository;
import com.tech_school.app.entity.LessonCommit;
import com.tech_school.app.entity.LessonsMaster;
import com.tech_school.app.entity.SectionCommit;
import com.tech_school.app.entity.SectionsMaster;
import com.tech_school.app.enums.ChangeType;
import com.tech_school.app.validators.LessonValidator;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {
    private CommitRepository commitRepository;
    private LessonValidator validator;

    public LessonMapper(CommitRepository commitRepository, LessonValidator validator){
        this.commitRepository = commitRepository;
        this.validator = validator;
    }

    public LessonApiModel lessonCommitToLessonApiModel(LessonCommit lessonCommit){
        LessonApiModel apiModel = new LessonApiModel();
        apiModel.setId(lessonCommit.getLessonId());
        apiModel.setCourseId(lessonCommit.getCourseId());
        apiModel.setSectionId(lessonCommit.getSectionId());
        apiModel.setDescription(lessonCommit.getDescription());
        apiModel.setTitle(lessonCommit.getTitle());
        apiModel.setUrl(lessonCommit.getUrl());
        apiModel.setType(lessonCommit.getType());
        return apiModel;
    }

    public LessonApiModel lessonCommitToLessonApiModel(LessonsMaster lessonsMaster){
        LessonApiModel apiModel = new LessonApiModel();
        apiModel.setId(lessonsMaster.getExternalId());
        apiModel.setSectionId(lessonsMaster.getSectionId());
        apiModel.setDescription(lessonsMaster.getDescription());
        apiModel.setTitle(lessonsMaster.getTitle());
        apiModel.setUrl(lessonsMaster.getUrl());
        apiModel.setType(lessonsMaster.getType());
        return apiModel;
    }

    public LessonCommit createLessonToLessonCommit(CreateLessonApiModel createLessonApiModel){
        LessonCommit lessonCommit = new LessonCommit();
        lessonCommit.setSectionId(createLessonApiModel.getId());
        lessonCommit.setDescription(createLessonApiModel.getDescription());
        lessonCommit.setTitle(createLessonApiModel.getTitle());
        lessonCommit.setCourseId(createLessonApiModel.getCourseId());
        lessonCommit.setSectionId(createLessonApiModel.getSectionId());
        lessonCommit.setState(ChangeType.ADDED.status);
        lessonCommit.setCourseId(createLessonApiModel.getCourseId());
        return lessonCommit;
    }

    public LessonsMaster lessonCommitToLessonMaster(LessonCommit lessonCommit){
        LessonsMaster lessonsMaster = new LessonsMaster();
        lessonsMaster.setSectionId(lessonCommit.getSectionId());
        lessonsMaster.setExternalId(lessonCommit.getLessonId());
        lessonsMaster.setDescription(lessonCommit.getDescription());
        lessonsMaster.setTitle(lessonCommit.getTitle());
        lessonsMaster.setUrl(lessonCommit.getUrl());
        lessonsMaster.setType(lessonCommit.getType());
        lessonsMaster.setCommitId(lessonCommit.getCommitId());
        return lessonsMaster;
    }
}
