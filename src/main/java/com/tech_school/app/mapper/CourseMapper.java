package com.tech_school.app.mapper;

import com.tech_school.app.api_models.courses.CourseApiModel;
import com.tech_school.app.api_models.courses.CreateCourseApiModel;
import com.tech_school.app.entity.Author;
import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.StagedChanges;
import com.tech_school.app.enums.CommitStates;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CourseMapper {

     public CourseApiModel courseCommitToCourseApiModel(CourseCommit courseCommit){
         CourseApiModel apiModel = new CourseApiModel();
         apiModel.setId(courseCommit.getExternalId());
         apiModel.setDescription(courseCommit.getDescription());
         apiModel.setTitle(courseCommit.getTitle());
         apiModel.setState(CommitStates.name(courseCommit.getState()));
         return apiModel;
    }

    public StagedChanges stagedChanges(Author authorId){
        StagedChanges stagedChanges = new StagedChanges();
        stagedChanges.setExternalId(UUID.randomUUID().toString());
        stagedChanges.setAuthor(authorId);
        stagedChanges.setState(CommitStates.DRAFT.status);
        return stagedChanges;
    }

    public CourseCommit createCourseToCourseCommit(CreateCourseApiModel createCourseApiModel){
        CourseCommit courseCommit = new CourseCommit();
        courseCommit.setExternalId(createCourseApiModel.getId());
        courseCommit.setDescription(createCourseApiModel.getDescription());
        courseCommit.setTitle(createCourseApiModel.getTitle());
        courseCommit.setState(CommitStates.DRAFT.status);
        return courseCommit;
    }
}
