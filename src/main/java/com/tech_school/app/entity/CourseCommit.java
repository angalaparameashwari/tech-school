package com.tech_school.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_commits")
public class CourseCommit extends CommonEntities {
    @Column(nullable = false, name = "external_id")
    @Builder.Default
    private String externalId  = UUID.randomUUID().toString();
    private String title;
    private String description;
    private int state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commit_id")
    private Commit commit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staged_id")
    private StagedChanges stagedChanges;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
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
