package com.tech_school.app.services;

import com.tech_school.app.dao.repositories.*;
import com.tech_school.app.entity.*;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.app.mapper.CommitMapper;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.mapper.SectionMapper;
import com.tech_school.app.services.courses.CourseService;
import com.tech_school.app.services.courses.CourseServiceImpl;
import com.tech_school.app.services.sections.SectionService;
import com.tech_school.app.services.sections.SectionServiceImpl;
import com.tech_school.app.validators.CommitValidator;
import com.tech_school.app.validators.SectionValidator;
import com.tech_school.core.security.RequestDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.spockframework.mock.MockImplementation;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;

@ExtendWith(MockitoExtension.class)
public class SectionServiceImplTest {
    @Mock
    SectionsMasterRepository sectionsMasterRepository;
    @Mock
    SectionCommitRepository sectionCommitRepository;

    @Mock
    CoursesMasterRepository coursesMasterRepository;
    @Mock
    CourseCommitRepository courseCommitRepository;
    @Mock
    CourseMapper courseMapper;

    @Mock
    SectionMapper mapper;
    @Mock
    CommitMapper commitMapper;

    @Mock
    SectionValidator validator;
    @Mock
    CommitValidator commitValidator;
    @Mock
    CommitRepository commitRepository;

    @Test
    void createShouldCreateNewSection() {
        //Given
        SectionCommit sectionCommit = new SectionCommit("JAVA_basics_section_1", "JAVA_basics_section_1", "JAVA_basics_section_1", "sec desc", "JAVA_basics_section_1",
                CommitStates.DRAFT.status, "commit2");
        Mockito.when(commitValidator.isDraftCommitAvailableForAuthor()).thenReturn(new Commit("commit2", CommitStates.DRAFT.status,
                null, new Author(), "JAVA_basics"));
        Mockito.when(sectionCommitRepository.save(sectionCommit)).thenReturn(sectionCommit);
        CoursesMaster coursesMaster = new CoursesMaster();
        Mockito.when(validator.availableCourse(sectionCommit)).thenReturn(Optional.of(coursesMaster));
        CourseCommit courseCommit = new CourseCommit();
        Mockito.when(courseMapper.createCourseDraftFromMaster(sectionCommit, coursesMaster))
                .thenReturn(courseCommit);

        //When
        SectionService sectionService = new SectionServiceImpl(sectionsMasterRepository, sectionCommitRepository,
                mapper, validator, commitMapper, commitValidator, courseMapper,
                coursesMasterRepository, courseCommitRepository);
        Optional<SectionCommit> SectionCommitResp = sectionService.create(sectionCommit);

        //Then
        Mockito.verify(validator).isCoursePresent(sectionCommit);
        Mockito.verify(validator).courseAvailableInDraftState(sectionCommit);
        Mockito.verify(courseMapper).createCourseDraftFromMaster(sectionCommit, coursesMaster);
        Mockito.verify(courseCommitRepository).save(courseCommit);
        Mockito.verify(validator).isSectionAlreadyAvailable(sectionCommit);
        Assertions.assertTrue(SectionCommitResp.isPresent());
        Assertions.assertEquals("JAVA_basics_section_1", SectionCommitResp.get().getExternalId());
        Assertions.assertEquals("JAVA_basics_section_1", SectionCommitResp.get().getSectionId());
        Assertions.assertEquals("JAVA_basics_section_1", SectionCommitResp.get().getTitle());
        Assertions.assertEquals("sec desc", SectionCommitResp.get().getDescription());
    }

}
