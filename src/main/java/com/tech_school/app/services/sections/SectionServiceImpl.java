package com.tech_school.app.services.sections;

import com.tech_school.app.dao.repositories.CourseCommitRepository;
import com.tech_school.app.dao.repositories.CoursesMasterRepository;
import com.tech_school.app.dao.repositories.SectionCommitRepository;
import com.tech_school.app.dao.repositories.SectionsMasterRepository;
import com.tech_school.app.entity.Commit;
import com.tech_school.app.entity.CourseCommit;
import com.tech_school.app.entity.SectionCommit;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.app.mapper.CommitMapper;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.mapper.SectionMapper;
import com.tech_school.app.validators.CommitValidator;
import com.tech_school.app.validators.SectionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    SectionsMasterRepository sectionsMasterRepository;
    SectionCommitRepository sectionCommitRepository;

    CoursesMasterRepository coursesMasterRepository;
    CourseCommitRepository courseCommitRepository;
    CourseMapper courseMapper;

    SectionMapper mapper;
    CommitMapper commitMapper;

    SectionValidator validator;
    CommitValidator commitValidator;


    @Autowired
    public SectionServiceImpl(SectionsMasterRepository sectionsMasterRepository, SectionCommitRepository sectionCommitRepository,
                              SectionMapper mapper, SectionValidator validator,
                              CommitMapper commitMapper, CommitValidator commitValidator, CourseMapper courseMapper,
                              CoursesMasterRepository coursesMasterRepository, CourseCommitRepository courseCommitRepository) {
        this.sectionsMasterRepository = sectionsMasterRepository;
        this.sectionCommitRepository = sectionCommitRepository;
        this.mapper = mapper;
        this.validator = validator;
        this.commitMapper = commitMapper;
        this.commitValidator = commitValidator;
        this.coursesMasterRepository = coursesMasterRepository;
        this.courseCommitRepository = courseCommitRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public Optional<SectionCommit> create(@Valid SectionCommit sectionCommit) {
        sectionCommit.setCommitId(getCommitId(sectionCommit));
        validator.isCoursePresent(sectionCommit);
        createCourseDraft(sectionCommit);
        validator.isSectionAlreadyAvailable(sectionCommit);
        logger.info("section_id", sectionCommit.getSectionId());
        return Optional.of(sectionCommitRepository.save(sectionCommit));
    }

    private String getCommitId(SectionCommit sectionCommit) {
        Commit draftCommitAvailableForAuthor = commitValidator.isDraftCommitAvailableForAuthor();
        if (draftCommitAvailableForAuthor == null) {
            return commitMapper.createCommit(sectionCommit.getCourseId(), CommitStates.DRAFT, commitValidator.getAuthorsLastetMerge().getExternalId()).getExternalId();
        }
        return draftCommitAvailableForAuthor.getExternalId();
    }

    private void createCourseDraft(SectionCommit sectionCommit) {
        if (validator.courseAvailableInDraftState(sectionCommit) == null) {
            CourseCommit courseDraftFromMaster = courseMapper.createCourseDraftFromMaster(sectionCommit,
                    validator.availableCourse(sectionCommit).get());
            courseCommitRepository.save(courseDraftFromMaster);
        }
    }

}
