package com.tech_school.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "lesson_commits")
public class LessonCommit extends CommonEntities {
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    @Column(nullable = false, name = "lesson_id")
    private String lessonId;
    @Column(nullable = false, name = "course_id")
    private String courseId;
    @Column(nullable = false, name = "section_id")
    private String sectionId;
    private String title;
    private String description;
    private String url;
    private String type;
    private int state;
    @Column(nullable = false, name = "commit_id")
    private String commitId;
//    id INT AUTO_INCREMENT  PRIMARY KEY,
//    external_id VARCHAR(250) NOT NULL UNIQUE,
//    course_id INT REFERENCES courses(id),
//    title VARCHAR(500) NOT NULL,
//    description text NOT NULL,
//    commit_id INT REFERENCES commits(id),
//    state VARCHAR(250) NOT NULL,
//    created_at TIMESTAMP NOT NULL,
//    updated_at TIMESTAMP NOT NULL,
//    deleted VARCHAR(300)
}
