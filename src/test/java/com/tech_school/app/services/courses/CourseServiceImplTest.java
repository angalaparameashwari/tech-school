package com.tech_school.app.services.courses;

import com.tech_school.app.dao.repositories.*;
import com.tech_school.app.entity.Author;
import com.tech_school.app.entity.Commit;
import com.tech_school.app.entity.Course;
import com.tech_school.app.entity.CoursesMaster;
import com.tech_school.app.enums.CommitStates;
import com.tech_school.app.mapper.CommitMapper;
import com.tech_school.app.mapper.CourseMapper;
import com.tech_school.app.mapper.LessonMapper;
import com.tech_school.app.mapper.SectionMapper;
import com.tech_school.app.validators.CourseValidator;
import com.tech_school.core.exceptions.GeneralException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.asserts.Assertion;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    CourseRepository courseRepository;
    @Mock
    CourseMapper courseMapper;
    @Mock
    CourseValidator courseValidator;
    @Mock
    CoursesMasterRepository coursesMasterRepository;
    @Mock
    CourseCommitRepository courseCommitRepository;

    @Mock
    SectionsMasterRepository sectionsMasterRepository;
    @Mock
    SectionCommitRepository sectionCommitRepository;
    @Mock
    SectionMapper sectionMapper;

    @Mock
    LessonCommitRepository lessonCommitRepository;
    @Mock
    LessonsMasterRepository lessonsMasterRepository;
    @Mock
    LessonMapper lessonMapper;

    @Mock
    CommitRepository commitRepository;
    @Mock
    CommitMapper commitMapper;


    @Test
    void createShouldCreateNewCourse(){
        Mockito.when(courseRepository.findByGivenId("JAVA_basics")).thenReturn(Optional.empty());
        Mockito.when(coursesMasterRepository.findCoursesMasterByExternalId("JAVA_basics")).thenReturn(Optional.empty());
        Mockito.when(commitMapper.createCommit("JAVA_basics", CommitStates.MERGED,null))
                .thenReturn(new Commit("commit1",CommitStates.MERGED.status,null,new Author(),"JAVA_basics"));
        CoursesMaster coursesMaster = new CoursesMaster("JAVA_basics", "JAVA_Basics",
                "BasicsOfJava","A basic level course for java beginners","commit1",null);
        Mockito.when(coursesMasterRepository.save(any())).thenReturn(coursesMaster);
        CourseService courseService = new CourseServiceImpl(courseRepository, coursesMasterRepository,
                courseMapper, commitMapper, commitRepository,
                courseValidator, courseCommitRepository,
                sectionsMasterRepository, sectionCommitRepository,
                sectionMapper);
        CoursesMaster coursesMasterReq = new CoursesMaster("JAVA_basics", "JAVA_Basics",
                "BasicsOfJava","A basic level course for java beginners","",null);
        Optional<CoursesMaster> coursesMasterResp = courseService.create(coursesMasterReq);
        Assertions.assertTrue(coursesMasterResp.isPresent());
        Assertions.assertEquals("JAVA_basics",coursesMasterResp.get().getExternalId());
        Assertions.assertEquals("JAVA_Basics",coursesMasterResp.get().getName());
        Assertions.assertEquals("BasicsOfJava",coursesMasterResp.get().getTitle());
        Assertions.assertEquals("A basic level course for java beginners",coursesMasterResp.get().getDescription());
    }

    @Test()
    void createACourseWithExistindId(){
        Mockito.when(coursesMasterRepository.findCoursesMasterByExternalId("JAVA_basics")).thenReturn(Optional.of(new CoursesMaster("JAVA_basics", "JAVA_Basics",
                "BasicsOfJava","A basic level course for java beginners","",null)));
        CourseService courseService = new CourseServiceImpl(courseRepository, coursesMasterRepository,
                courseMapper, commitMapper, commitRepository,
                courseValidator, courseCommitRepository,
                sectionsMasterRepository, sectionCommitRepository,
                sectionMapper);
        CoursesMaster coursesMasterReq = new CoursesMaster("JAVA_basics", "JAVA_Basics",
                "BasicsOfJava","A basic level course for java beginners","",null);
        Assertions.assertThrows(GeneralException.class, () -> courseService.create(coursesMasterReq));
    }

    @Test()
    void createACourseAvailableInMaster(){
        Mockito.when(courseRepository.findByGivenId("JAVA_basics")).thenReturn(Optional.of(new Course("JAVA_basics","commitId"
                ,null,null)));
        CourseService courseService = new CourseServiceImpl(courseRepository, coursesMasterRepository,
                courseMapper, commitMapper, commitRepository,
                courseValidator, courseCommitRepository,
                sectionsMasterRepository, sectionCommitRepository,
                sectionMapper);
        CoursesMaster coursesMasterReq = new CoursesMaster("JAVA_basics", "JAVA_Basics",
                "BasicsOfJava","A basic level course for java beginners","",null);
        Assertions.assertThrows(GeneralException.class, () -> courseService.create(coursesMasterReq));
    }

}