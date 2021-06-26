package com.tech_school.app.services.lessons;

import com.tech_school.app.dao.repositories.*;
import com.tech_school.app.entity.Commit;
import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.LessonCommit;
import com.tech_school.app.entity.SectionCommit;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.app.mapper.CommitMapper;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.mapper.LessonMapper;
import com.tech_school.app.mapper.SectionMapper;
import com.tech_school.app.services.sections.SectionService;
import com.tech_school.app.validators.CommitValidator;
import com.tech_school.app.validators.LessonValidator;
import com.tech_school.app.validators.SectionValidator;
import com.tech_school.app.validators.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    LessonsMasterRepository lessonsMasterRepository;
    LessonCommitRepository lessonCommitRepository;

    CourseCommitRepository courseCommitRepository;
    CourseMapper courseMapper;

    SectionCommitRepository sectionCommitRepository;


    LessonMapper mapper;
    CommitMapper commitMapper;

    LessonValidator validator;
    CommitValidator commitValidator;



    @Autowired
    public LessonServiceImpl( LessonsMasterRepository lessonsMasterRepository, LessonCommitRepository lessonCommitRepository,
                              LessonMapper mapper, LessonValidator validator,
                             CommitMapper commitMapper, CommitValidator commitValidator, CourseCommitRepository courseCommitRepository,
                              CourseMapper courseMapper,SectionCommitRepository sectionCommitRepository){
        this.lessonsMasterRepository = lessonsMasterRepository;
        this.lessonCommitRepository = lessonCommitRepository;
        this.mapper = mapper;
        this.validator = validator;
        this.commitMapper = commitMapper;
        this.commitValidator = commitValidator;
        this.courseCommitRepository = courseCommitRepository;
        this.courseMapper = courseMapper;
        this.sectionCommitRepository = sectionCommitRepository;
    }

    @Override
    public Optional<LessonCommit> create(@Valid LessonCommit lessonCommit) {
        lessonCommit.setCommitId(getCommitId(lessonCommit));
        validator.isCoursePresent(lessonCommit);
        validator.isSectionAvailable(lessonCommit);
        if(validator.courseAvailableInDraftState(lessonCommit) == null){
            createCourseDraft(lessonCommit);
        }
        if(validator.sectionAvailableInDraftState(lessonCommit) == null){
            createSectionDraft(lessonCommit);
        }
        logger.info("lession_id", lessonCommit.getLessonId());
        return Optional.of(lessonCommitRepository.save(lessonCommit));
    }

    String getCommitId(LessonCommit lessonCommit){
        Commit draftCommitAvailableForAuthor = commitValidator.isDraftCommitAvailableForAuthor();
        if(draftCommitAvailableForAuthor == null){
            return commitMapper.createCommit(lessonCommit.getCourseId(), CommitStates.DRAFT,commitValidator.getAuthorsLastetMerge().getExternalId()).getExternalId();
        }
            return draftCommitAvailableForAuthor.getExternalId();
    }

    private void createCourseDraft(LessonCommit lessonCommit){
        if(validator.courseAvailableInDraftState(lessonCommit) == null){
            CourseCommit courseDraftFromMaster = courseMapper.createCourseDraftFromMaster(lessonCommit, validator.availableCourse(lessonCommit).get());
            courseCommitRepository.save(courseDraftFromMaster);
        }
    }

    private void createSectionDraft(LessonCommit lessonCommit){
        if(validator.courseAvailableInDraftState(lessonCommit) == null){
            SectionCommit courseDraftFromMaster = courseMapper.createSectionDraftFromMaster(lessonCommit, validator.isAvailableInMaster(lessonCommit));
            sectionCommitRepository.save(courseDraftFromMaster);
        }
    }
}
