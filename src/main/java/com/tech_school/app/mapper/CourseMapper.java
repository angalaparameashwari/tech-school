package com.tech_school.app.mapper;

import com.tech_school.app.api_models.courses.CourseApiModel;
import com.tech_school.app.api_models.courses.CreateCourseApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
import com.tech_school.app.entity.*;
import com.tech_school.app.enums.CommitStates;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseMapper {

     public CourseApiModel courseCommitToCourseApiModel(CourseCommit courseCommit){
         CourseApiModel apiModel = new CourseApiModel();
         apiModel.setId(courseCommit.getCourseId());
         apiModel.setDescription(courseCommit.getDescription());
         apiModel.setTitle(courseCommit.getTitle());
         return apiModel;
    }

    public CourseApiModel courseMasterToCourseApiModel(CoursesMaster coursesMaster){
        CourseApiModel apiModel = new CourseApiModel();
        apiModel.setId(coursesMaster.getExternalId());
        apiModel.setDescription(coursesMaster.getDescription());
        apiModel.setTitle(coursesMaster.getTitle());
        apiModel.setName(coursesMaster.getName());
        apiModel.setState(CommitStates.MERGED.name);
        return apiModel;
    }

    public CourseApiModel courseMasterToCourseApiModel(CoursesMaster coursesMaster, List<SectionApiModel> sectionApiModels){
        CourseApiModel apiModel = new CourseApiModel();
        apiModel.setId(coursesMaster.getExternalId());
        apiModel.setDescription(coursesMaster.getDescription());
        apiModel.setTitle(coursesMaster.getTitle());
        apiModel.setName(coursesMaster.getName());
        apiModel.setState(CommitStates.MERGED.name);
        apiModel.setSections(sectionApiModels);
        return apiModel;
    }

    public CourseCommit createCourseDraftFromMaster(SectionCommit sectionCommit, CoursesMaster coursesMaster){
        CourseCommit courseCommit = new CourseCommit();
        courseCommit.setCourseId(sectionCommit.getCourseId());
        courseCommit.setDescription(coursesMaster.getDescription());
        courseCommit.setTitle(coursesMaster.getTitle());
        courseCommit.setName(coursesMaster.getName());
        courseCommit.setCommitId(sectionCommit.getCommitId());
        return courseCommit;
    }


    public CoursesMaster createCourseToCourseMaster(CreateCourseApiModel createCourseApiModel){
        CoursesMaster coursesMaster = new CoursesMaster();
        coursesMaster.setExternalId(createCourseApiModel.getId());
        coursesMaster.setDescription(createCourseApiModel.getDescription());
        coursesMaster.setTitle(createCourseApiModel.getTitle());
        coursesMaster.setName(createCourseApiModel.getName());
        return coursesMaster;
    }

    public CoursesMaster courseCommitToCourseMaster(CourseCommit courseCommit, String previousCommit){
        CoursesMaster coursesMaster = new CoursesMaster();
        coursesMaster.setExternalId(courseCommit.getCourseId());
        coursesMaster.setDescription(courseCommit.getDescription());
        coursesMaster.setTitle(courseCommit.getTitle());
        coursesMaster.setName(courseCommit.getName());
        coursesMaster.setPreviousCommit(previousCommit);
        coursesMaster.setCommitId(courseCommit.getCommitId());
        return coursesMaster;
    }

    public CourseCommit createCourseDraftFromMaster(LessonCommit lessonCommit, CoursesMaster coursesMaster){
        CourseCommit courseCommit = new CourseCommit();
        courseCommit.setCourseId(lessonCommit.getCourseId());
        courseCommit.setDescription(coursesMaster.getDescription());
        courseCommit.setTitle(coursesMaster.getTitle());
        courseCommit.setName(coursesMaster.getName());
        courseCommit.setCommitId(lessonCommit.getCommitId());
        return courseCommit;
    }

    public SectionCommit createSectionDraftFromMaster(LessonCommit lessonCommit, SectionsMaster sectionsMaster){
        SectionCommit sectionCommit = new SectionCommit();
        sectionCommit.setCourseId(lessonCommit.getCourseId());
        sectionCommit.setDescription(sectionsMaster.getDescription());
        sectionCommit.setTitle(sectionsMaster.getTitle());
        sectionCommit.setCommitId(lessonCommit.getCommitId());
        return sectionCommit;
    }
}
